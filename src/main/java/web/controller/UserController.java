package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.ServiceUser;

import java.util.ArrayList;
import java.util.List;


@Controller
public class UserController {
    @Autowired
    private ServiceUser serviceUser;

    @RequestMapping("/")
    public String showAllUser(Model model) {
        model.addAttribute("allUser", serviceUser.listUser());
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");
//        model.addAttribute("messages", messages);
        return "index";
    }
}
