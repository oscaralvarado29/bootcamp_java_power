package com.rutas.signup.domain.usecase;

import com.rutas.signup.domain.api.IUserServicePort;
import com.rutas.signup.domain.exception.EmailInvalidFormatException;
import com.rutas.signup.domain.exception.MissingMandatoryDataException;
import com.rutas.signup.domain.exception.PasswordInvalidFormatException;
import com.rutas.signup.domain.model.User;
import com.rutas.signup.domain.spi.IUserPersistencePort;
import org.hibernate.validator.internal.constraintvalidators.hv.EmailValidator;

import java.util.List;

public class UserUseCase implements IUserServicePort {

    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    /**
     * @param user UserEntity to be saved
     */
    @Override
    public void saveUser(User user) {
        validationOfComplianceWithTheRequirementsForSaveUser(user);
        userPersistencePort.saveUser(user);
    }

    private void validationOfComplianceWithTheRequirementsForSaveUser(User user) {
        EmailValidator emailValidator = new EmailValidator();
        String passwordPattern = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[“*_-])(?=.*[a-zA-Z]).{8,15}$";
        List<Character> specialCharactersNotAllowed = List.of('!', '"', '#', '$', '%', '&', '/', '(', ')', '=', '?', '¡', '¿', '¨', '^', '´', '`', '+', '{', '}', '[', ']', 'ç', 'Ç', 'º', 'ª', '°', '¬', '|', '·', '>', '<', ';', ':', ',', '.', ' ','@','\\','~','_', '-', 'ñ', 'Ñ', 'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú', 'à', 'è', 'ì', 'ò', 'ù', 'À', 'È', 'Ì', 'Ò', 'Ù', 'ä', 'ë', 'ï', 'ö', 'ü', 'Ä', 'Ë', 'Ï', 'Ö', 'Ü');

        if (!emailValidator.isValid(user.getEmail(), null)) {
            throw new EmailInvalidFormatException();
        }
        if (user.getName() == null || user.getEmail() == null || user.getFamilyName() == null || user.getAddress() == null || user.getPhoneNumber() == null || user.getPassword() == null) {
            throw new MissingMandatoryDataException();
        }
        if (!user.getPassword().matches(passwordPattern)) {
            throw new PasswordInvalidFormatException();
        } else{
            for (Character character : specialCharactersNotAllowed) {
                if (user.getPassword().contains(character.toString())) {
                    throw new PasswordInvalidFormatException();
                }
            }
        }
    }

    /**
     * @param userEmail email of the user to find
     * @return UserEntity with the email passed by parameter
     */
    @Override
    public User findUserByEmail(String userEmail) {
        return userPersistencePort.findUserByEmail(userEmail);
    }
}

