package com.example.ailawyerbackend.Controllers;

import com.example.ailawyerbackend.Services.AdviceService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class ChatController {

    @Autowired
    AdviceService adviceService;

    @PostMapping("/chat")
    public String getChat(@RequestBody String input) throws JsonProcessingException {

//        System.out.println(input);

        String output = adviceService.getAdvice(input);
        return output;
    }

    @GetMapping("")
    public String defaultRoute(){
        return "<h1>Hello World!";
    }
}
