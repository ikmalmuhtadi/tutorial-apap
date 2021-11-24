package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    public String encrypt(String password);
    List<UserModel> getUserList();
    void deleteUser(UserModel user);
    UserModel getUserByUsername(String username);
    void updatePasswordUser(UserModel user, String password);
    boolean checkPassword(String password);
}
