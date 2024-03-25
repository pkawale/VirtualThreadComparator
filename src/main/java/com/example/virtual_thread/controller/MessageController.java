package com.example.virtual_thread.controller;

import com.example.virtual_thread.service.MessageOperationsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    private final MessageOperationsService messageOperationsService;

    public MessageController(MessageOperationsService messageOperationsService) {
        this.messageOperationsService = messageOperationsService;
    }

    @GetMapping("/testVirtualThreadsOperations")
    public String virtualThreadsDatabaseOperations() {
        return messageOperationsService.parallelDatabaseOperationsWithVirtualThreads();
    }

    @GetMapping("/testTraditionalThreadsOperations")
    public String traditionalThreadsDatabaseOperations() {
        return messageOperationsService.parallelDatabaseOperationsWithFixedThreads();
    }


}
