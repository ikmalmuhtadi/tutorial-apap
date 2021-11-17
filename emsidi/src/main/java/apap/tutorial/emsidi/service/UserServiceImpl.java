package apap.tutorial.emsidi.service;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDb userDb;

    @Override
    public UserModel addUser(UserModel user) {
        String pass = encrypt(user.getPassword());
        user.setPassword(pass);
        return userDb.save(user);
    }

    @Override
    public String encrypt(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }

    @Override
    public List<UserModel> getUserList() {
        return userDb.findAll();
    }

    @Override
    public void deleteUser(UserModel user) {
        userDb.delete(user);
    }

    @Override
    public UserModel getUserByUsername(String username) {
        return userDb.findByUsername(username);
    }

    @Override
    public void updatePasswordUser(UserModel user, String password) {
        String passwordEnc = encrypt(password);
        user.setPassword(passwordEnc);
        userDb.save(user);
    }

    @Override
    public boolean checkPassword(String password) {
        boolean angka = false;
        boolean hurufBesar = false;
        boolean hurufKecil = false;
        boolean simbol = false;
        boolean jumlahKarakter = password.length() >= 8;

        for(char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hurufBesar = true;
            }
            if (Character.isLowerCase(c)) {
                hurufKecil = true;
            }
            if (Character.isDigit(c)) {
                angka = true;
            }
            if (String.valueOf(c).matches("[^A-Za-z0-9]")) {
                simbol = true;
            }
        }
        return angka && hurufBesar && hurufKecil && simbol && jumlahKarakter;
    }


}
