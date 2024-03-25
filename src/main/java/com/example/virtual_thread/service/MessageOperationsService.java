package com.example.virtual_thread.service;


import com.example.virtual_thread.data.MessageTable;
import com.example.virtual_thread.repo.MessageTableRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class MessageOperationsService {

    private final ExecutorService virtualThreadExecutor = Executors.newVirtualThreadPerTaskExecutor();

    private final ExecutorService traditionalThreadPool = Executors.newFixedThreadPool(10);

    private final MessageTableRepository messageRepo;

    public MessageOperationsService(MessageTableRepository messageRepo) {
        this.messageRepo = messageRepo;
    }

    public String parallelDatabaseOperationsWithVirtualThreads() {
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<Void>> virtualTasks = IntStream.range(0, 10000)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    messageRepo.save(new MessageTable("Message from task "+ i + " using Virtual Threads"));
                }, virtualThreadExecutor)).toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(virtualTasks.toArray(new CompletableFuture[0]));
        allTasks.join();

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        String result = "Virtual threads completed database operations in " + totalTime + " ms.";
        System.out.println(result);

        return result;
    }

    public String parallelDatabaseOperationsWithFixedThreads() {
        long startTime = System.currentTimeMillis();

        List<CompletableFuture<Void>> tasks = IntStream.range(0, 10000)
                .mapToObj(i -> CompletableFuture.runAsync(() -> {
                    messageRepo.save(new MessageTable("Message from task " + i + " using Traditional Threads"));
                }, traditionalThreadPool)).toList();

        CompletableFuture<Void> allTasks = CompletableFuture.allOf(tasks.toArray(new CompletableFuture[0]));
        allTasks.join();

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        String result = "Traditional threads completed database operations in " + totalTime  + "ms";
        System.out.println(result);
        return result;
    }
}
