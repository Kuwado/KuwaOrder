package controller;

import model.User;
import model.subsytem.UserSystem;

public class UserController {
    public User user;
    public final UserSystem userSystem = new UserSystem();

    public User getUserByEmailAndPassword(String email, String password) {
        user =  userSystem.selectTypeByEmailAndPass(email, password);
        return user;
    }

}
