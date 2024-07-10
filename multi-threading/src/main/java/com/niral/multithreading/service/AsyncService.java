package com.niral.multithreading.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

/**
 * Service class to demonstrate asynchronous operations using CompletableFuture.
 */
@Service
@EnableAsync
public class AsyncService {

    /**
     * Simulates fetching data from the first service asynchronously.
     *
     * @return CompletableFuture containing the result of the operation.
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    @Async
    public CompletableFuture<String> fetchDataFromService1() throws InterruptedException {
        // Simulate a long-running task
        Thread.sleep(2000);
        return CompletableFuture.completedFuture("Data from Service 1");
    }

    /**
     * Simulates fetching data from the second service asynchronously.
     *
     * @return CompletableFuture containing the result of the operation.
     * @throws InterruptedException if the thread is interrupted while sleeping.
     */
    @Async
    public CompletableFuture<String> fetchDataFromService2() throws InterruptedException {
        // Simulate a long-running task
        Thread.sleep(3000);
        return CompletableFuture.completedFuture("Data from Service 2");
    }

    /**
     * Combines the results from both services asynchronously.
     *
     * @return CompletableFuture containing the combined result of both services.
     * @throws InterruptedException 
     */
    public CompletableFuture<String> fetchCombinedData() throws InterruptedException {
        CompletableFuture<String> service1 = fetchDataFromService1();
        CompletableFuture<String> service2 = fetchDataFromService2();

        return service1.thenCombine(service2, (result1, result2) -> result1 + " & " + result2);
    }
}
