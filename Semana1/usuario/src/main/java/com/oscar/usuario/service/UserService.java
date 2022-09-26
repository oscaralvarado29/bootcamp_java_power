package com.oscar.usuario.service;

import com.oscar.usuario.dto.UserDto;
import com.oscar.usuario.exceptionhandler.*;
import com.oscar.usuario.mapper.UserMapper;
import com.oscar.usuario.model.User;
import com.oscar.usuario.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiredArgsConstructor
@Service
@Transactional
public class UserService implements IUserService{

    private final IUserRepository userRepository;
    private final UserMapper userMapper;

    /**
     * @param userDto object with user data
     */

    public void saveUser(UserDto userDto)  {
        if (userDto.getUserEmail() != null ) {
            if (userRepository.findByUserEmail(userDto.getUserEmail()).isPresent()) {
                throw new UserAlreadyExistsException();
            }
            if (userDto.getUserName() == null || userDto.getUserSurname() == null || userDto.getUserPhone() == null || userDto.getUserAddress() == null || userDto.getUserPassword() == null) {
                throw new MissingMandatoryDataException();
            }
            emailValidator(userDto.getUserEmail());
            passwordValidator(userDto.getUserPassword());
            User user = userMapper.toUser(userDto);
            userRepository.save(user);
        } else{
            throw new EmailNotPresentException();
        }

    }

    private void passwordValidator(String userPassword) {
        String passworRegex = "^(?=.*\\w)(?=.*[*_-])(?=\\S+$).{8,15}$";
        Pattern pattern = Pattern.compile(passworRegex);
        Matcher matcher = pattern.matcher(userPassword);
        if (!matcher.matches()) {
            throw new PasswordNotValidException();
        }
    }

    private void emailValidator(String userEmail) {
        EmailValidator emailValidator = new EmailValidator();
        if (!emailValidator.isValid(userEmail, null)) {
            throw new EmailInvaldFormatException();
        }
    }

    /**
     * @param userEmail user email to delete
     */

    public void deleteUser(String userEmail) {

        if (userRepository.findByUserEmail(userEmail).isPresent()) {
            userRepository.deleteByUserEmail(userEmail);
        } else {
            throw new UserNotFoundException();
        }
    }

    /**
     * @param userDto object with user data
     */
    @Override
    public void updateUser(UserDto userDto) {
        if (userDto.getUserEmail() != null) {
            Optional<User> newUser = userRepository.findByUserEmail(userDto.getUserEmail());
            if (newUser.isPresent()) {

                if (userDto.getUserName() != null) {
                    newUser.get().setUserName(userDto.getUserName());
                }
                if (userDto.getUserSurname() != null) {
                    newUser.get().setUserSurname(userDto.getUserSurname());
                }
                if (userDto.getUserPhone() != null) {
                    newUser.get().setUserPhone(userDto.getUserPhone());
                }
                if (userDto.getUserAddress() != null) {
                    newUser.get().setUserAddress(userDto.getUserAddress());
                }
                if (userDto.getUserEmail() != null) {
                    newUser.get().setUserEmail(userDto.getUserEmail());
                }
                if (userDto.getUserPassword() != null) {
                    newUser.get().setUserPassword(userDto.getUserPassword());
                }

                userRepository.save(newUser.get());
            } else {
                throw new UserNotFoundException();
            }
        } else {
            throw new UserNotFoundException();
        }

    }

    /**
     * @param userEmail user email to find user
     * @return the call to the method toUserDto of the UserMapper class
     */
    public UserDto getUserByEmail(String userEmail) {
        User user = userRepository.findByUserEmail(userEmail).orElseThrow(UserNotFoundException::new);
        return userMapper.toUserDto(user);
    }


}
