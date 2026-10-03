package com.spring.ai.controller;


import com.spring.ai.dto.ChatRequest;
import com.spring.ai.dto.ChatResponse;
import com.spring.ai.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/chat")
@RequiredArgsConstructor
public class ChatController {

    private final AIService aiService;

    @PostMapping
    public ChatResponse chat(@RequestBody ChatRequest request) {

        String response = aiService.chat(request.message());

        return new ChatResponse(response);
    }
}