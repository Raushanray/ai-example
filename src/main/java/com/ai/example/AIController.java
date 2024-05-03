package com.ai.example;

import org.springframework.ai.ollama.OllamaChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/ai")
public class AIController {

    private OllamaChatClient client;

//    private static final String PROMPT = "what is C language";

    public AIController(OllamaChatClient client) {
        this.client = client;
    }


    /*@GetMapping("/prompt")
    private String promptResponse(){
        String response = client.call(PROMPT);
        return response;
    }*/

  /*  @GetMapping("/prompt")
    private String promptResponse(
            @RequestParam("prompt") String prompt
    ){
        String response = client.call(prompt);
        return response;
    }*/

    @GetMapping("/prompt")
    private Flux<String> promptResponse(
            @RequestParam("prompt") String prompt
    ){
        Flux<String> response = client.stream(prompt);
        return response;
    }
}
