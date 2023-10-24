package project.hospital.controller.logincontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TypeOfUserController {
    //Should use Factory design pattern
    @GetMapping("/type")
    public String directLogin() {
        //To-do
        return "";
    }
}
