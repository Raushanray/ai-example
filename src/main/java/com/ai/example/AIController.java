package com.ai.example;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ai")
public class AIController {

    private OllamaChatClient client;

    private static final String PROMPT = "what is C language";

    public AIController(OllamaChatClient client) {
        this.client = client;
    }


    @GetMapping("/prompt")
    private String promptResponse(){
        String response = client.call(PROMPT);
        return response;
    }
}
