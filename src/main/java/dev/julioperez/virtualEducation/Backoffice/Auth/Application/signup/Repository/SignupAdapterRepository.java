package dev.julioperez.virtualEducation.Backoffice.Auth.Application.signup.Repository;

import dev.julioperez.virtualEducation.Backoffice.Auth.Domain.Model.User;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.UserDao;
import dev.julioperez.virtualEducation.Backoffice.Auth.Infrastructure.Repository.Dao.VerificationTokenDao;

public class SignupAdapterRepository {

    private final UserDao userDao;
    private final VerificationTokenDao verificationTokenDao;

    public SignupAdapterRepository(UserDao userDao, VerificationTokenDao verificationTokenDao) {
        this.userDao = userDao;
        this.verificationTokenDao = verificationTokenDao;
    }

    public User createUser(User user){
        //todo: call dao to create userEntity
        //todo: check if persistence process did OK
        //todo: use model mapper to convert userEntity to user
        return null;
    }

    public void createToken(String token, Long userId){
        //todo: call dao to create tokenEntity
        //todo: check if persistence process did OK
    }
}
