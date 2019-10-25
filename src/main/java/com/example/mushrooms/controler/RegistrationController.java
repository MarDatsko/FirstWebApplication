package com.example.mushrooms.controler;

import com.example.mushrooms.domain.Role;
import com.example.mushrooms.domain.User;
import com.example.mushrooms.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Controller
@RequestMapping
public class RegistrationController {

    @Autowired
    private UserRepo userRepo;

    @GetMapping(value ="/reg")
    public String reg(){
        return "reg";
    }

    @PostMapping(value = "/reg")
    public String addUser(User user,Map<String,Object> model){
        User userFromDb = userRepo.findByUsername(user.getUsername());

        if(userFromDb != null){
            model.put("messages", "Exit");
            return "reg";
        }

        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepo.save(user);

        return "redirect:/login";
    }
}
