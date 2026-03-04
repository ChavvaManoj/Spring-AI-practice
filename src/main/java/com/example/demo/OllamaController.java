//package com.example.demo;
//
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
//import org.springframework.ai.chat.memory.InMemoryChatMemory;
//import org.springframework.ai.chat.model.ChatResponse;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.ai.ollama.OllamaChatModel;
//
//@RestController
//public class OllamaController {
//
//    private ChatClient chatClient;
//
//    public OllamaController(OllamaChatModel chatModel){
//        this.chatClient = ChatClient.create(chatModel);
//    }
//
//    //----------Using Builder if only one model is used in the application
////    public OpenAIController(ChatClient.Builder builder){
////        this.chatClient = builder
////                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
////                .build();
////    }
//
//    //@GetMapping("/api/{message}")
//    public ResponseEntity<String> getAnswer(@PathVariable String message) {
//
////        String response = chatClient
////                .prompt(message)
////                . call()
////                .content();
//
//
//
//        ChatResponse chatResponse = chatClient
//                .prompt(message)
//                .call()
//                .chatResponse();
//
//        System.out.println(chatResponse.getMetadata().getModel());
//
//        String response = chatResponse
//                .getResult()
//                .getOutput()
//                .getText();
//
//        return ResponseEntity.ok(response);   // returning AI response
//    }
//
//    @PostMapping("/api/product")
//    public String getProducts(@RequestParam String text ){
//
//
//
//        return "";
//    }
//}
