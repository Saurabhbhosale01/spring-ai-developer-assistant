package com.spring.ai.service;


import com.spring.ai.prompt.Prompts;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIService {

    private final ChatClient chatClient;

    /*
     * chatClient  → The ChatClient bean used to communicate with the AI model.
     * .prompt()   → Creates a new prompt/request that will be sent to the model.
     * .user(message) → Adds the user's message to the prompt.
     * .system(...) → Adds system-level instructions that define
     *                the AI assistant's behavior and role.
     * .call()     → Sends the prompt to the configured AI model and gets the response.
     * .content()  → Extracts the actual text content from the AI response.
     *
     * Overall flow:
     * ChatClient → Create Prompt →System Instructions +  Add User Message → Call AI Model → Get Response Text
     */
    public String chat(String message) {
        return chatClient
                .prompt()
                .user(message)
                .system(Prompts.DEVELOPER_ASSISTANT)
                .call()
                .content();
    }
}