package project.hospital.controller.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.hospital.controller.logincontroller.authentication.check.CheckingUser;

@Controller
public class LoginController {
    private CheckingUser authentication;

    @GetMapping("/login")
    public String directLoginForm(){
        return "dropdown-userlogo";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {

        //To-do
        return "login";
    }
}
