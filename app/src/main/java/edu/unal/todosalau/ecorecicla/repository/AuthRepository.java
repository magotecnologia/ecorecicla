package edu.unal.todosalau.ecorecicla.repository;

import java.util.List;

import javax.inject.Inject;

import at.favre.lib.crypto.bcrypt.BCrypt;
import edu.unal.todosalau.ecorecicla.data.EcoreciclaDatabase;
import edu.unal.todosalau.ecorecicla.data.entity.UserEntity;
import edu.unal.todosalau.ecorecicla.exception.NotFoundUser;

public class AuthRepository {
    private final EcoreciclaDatabase db;

    @Inject
    public AuthRepository(EcoreciclaDatabase db) {
        this.db = db;
    }

    public UserEntity getUserByNameAndPass(String username, String password) throws NotFoundUser {
        List<UserEntity> foundUsers = db.userDao().findUsersByName(username);
        if (foundUsers.isEmpty()) throw new NotFoundUser();
        String hashedPass = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        for (UserEntity user : foundUsers) {
            BCrypt.Result result = BCrypt.verifyer().verify(user.password.toCharArray(), hashedPass);
            if (result.verified) return user;
        }
        throw new NotFoundUser();
    }
}
