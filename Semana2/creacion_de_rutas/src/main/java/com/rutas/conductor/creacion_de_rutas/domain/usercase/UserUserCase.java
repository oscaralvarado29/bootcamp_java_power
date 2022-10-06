package com.rutas.conductor.creacion_de_rutas.domain.usercase;

import com.rutas.conductor.creacion_de_rutas.domain.api.IUserServicePort;
import com.rutas.conductor.creacion_de_rutas.domain.exceptions.*;
import com.rutas.conductor.creacion_de_rutas.domain.model.User;
import com.rutas.conductor.creacion_de_rutas.domain.spi.IUserPersistencePort;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import java.util.List;

public class UserUserCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUserCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    /**
     * @param user User to be saved
     */
    @Override
    public void saveUser(User user) {
        validationOfComplianceWithTheRequirementsForSaveUser(user);
        userPersistencePort.saveUser(user);
    }

    private void validationOfComplianceWithTheRequirementsForSaveUser(User user) {
        EmailValidator emailValidator = new EmailValidator();
        String passwordPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[“*_-])(?=.*[a-zA-Z]).{8,15}$";
        List<Character> specialCharactersNotAllowed = List.of('!', '"', '#', '$', '%', '&', '/', '(', ')', '=', '?', '¡', '¿', '¨', '^', '´', '`', '+', '{', '}', '[', ']', 'ç', 'Ç', 'º', 'ª', '°', '¬', '|', '·', '>', '<', ';', ':', ',', '.', ' ','@','\\');

        if (!emailValidator.isValid(user.getUserEmail(), null)) {
            throw new EmailInvalidFormatException();
        }
        if (user.getUserName() == null || user.getUserSurname() == null || user.getUserPhone() == null || user.getUserAddress() == null || user.getUserPassword() == null || user.getUserEmail() == null) {
            throw new MissingMandatoryDataException();
        }
        if (!user.getUserPassword().matches(passwordPattern)) {
            throw new PasswordInvalidException();
        } else{
            for (Character character : specialCharactersNotAllowed) {
                if (user.getUserPassword().contains(character.toString())) {
                    throw new PasswordInvalidException();
                }
            }
        }
    }

    /**
     * @param user user to update
     */
    @Override
    public void updateUser(User user) {
        userPersistencePort.updateUser(user);
    }

    /**
     * @param userEmail  email of the user to be deleted
     */
    @Override
    public void deleteUser(String userEmail) {
        userPersistencePort.deleteUser(userEmail);
    }

    /**
     * @param userEmail email of the user to find
     * @return User with the email passed by parameter
     */
    @Override
    public User findUserByEmail(String userEmail) {
        return userPersistencePort.findByUserEmail(userEmail);
    }

    /**
     * @param id
     * @return
     */
    @Override
    public User getUser(Long id) {
        return userPersistencePort.getUser(id);
    }

    /**
     * @return list of all users
     */
    @Override
    public List<User> getAllUsers() {
        return userPersistencePort.getAllUsers();
    }
}
