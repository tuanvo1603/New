package project.hospital.controller.logincontroller.authentication.check;

import project.hospital.controller.logincontroller.authentication.usernamecheck.UsernameChecking;
import project.hospital.controller.logincontroller.authentication.passwordcheck.PasswordChecking;

public abstract class CheckingUser {
    //Should use Singleton design pattern
    PasswordChecking passwordChecking;
    UsernameChecking userChecking;
    abstract boolean authenticate(String username, String password);
}
