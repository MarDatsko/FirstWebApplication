package com.example.mushrooms.controler;

import com.example.mushrooms.domain.Message;
import com.example.mushrooms.domain.User;
import com.example.mushrooms.repos.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MessageController {

    @Autowired
    private MessageRepo messageRepo;

    @GetMapping(value = "/")
    public String first(Map<String,Object>model){
       return "first";
    }

    @PostMapping(value = "/main")
    public String add(@AuthenticationPrincipal User user,
                      @RequestParam String text,
                      @RequestParam String tag,
                      Map<String, Object> model){

        Message m = new Message();
        m.setTag(tag);
        m.setText(text);
        m.setAuthor(user);
        messageRepo.save(m);

        Iterable<Message> messages = messageRepo.findAll();
        model.put("messages", messages);
        model.put("filter", "");

        return "main";
    }

    @GetMapping(value = "/main")
    public String main(@RequestParam(required = false) String filter, Map<String, Object> model){
        Iterable<Message> messages = messageRepo.findAll();

        if(filter != null && !filter.isEmpty()) {
            messages = messageRepo.findByTag(filter);
        }
        else {
            messages = messageRepo.findAll();
        }

        model.put("messages", messages);
        model.put("filter", "");

        return "main";
    }


}
