package com.niral.multithreading.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * Test class for AsyncService.
 */
@SpringBootTest
@ContextConfiguration(classes = {AsyncService.class, TestConfig.class})
public class AsyncServiceTest {

    @Autowired
    private AsyncService asyncService;

    /**
     * Test for fetchDataFromService1 method.
     *
     * @throws ExecutionException if the computation threw an exception
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
    @Test
    public void testFetchDataFromService1() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = asyncService.fetchDataFromService1();
        String result = future.get();
        assertThat(result).isEqualTo("Data from Service 1");
    }

    /**
     * Test for fetchDataFromService2 method.
     *
     * @throws ExecutionException if the computation threw an exception
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
    @Test
    public void testFetchDataFromService2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = asyncService.fetchDataFromService2();
        String result = future.get();
        assertThat(result).isEqualTo("Data from Service 2");
    }

    /**
     * Test for fetchCombinedData method.
     *
     * @throws ExecutionException if the computation threw an exception
     * @throws InterruptedException if the current thread was interrupted while waiting
     */
    @Test
    public void testFetchCombinedData() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = asyncService.fetchCombinedData();
        String result = future.get();
        assertThat(result).isEqualTo("Data from Service 1 & Data from Service 2");
    }
}
