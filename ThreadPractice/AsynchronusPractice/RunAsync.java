package com.ishmamruhan.Dhrubok_Practice_Session.AsynchronusPractice;


import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/*
*   Run Async Method:
*   ------------------
*   Method type will be void.
*   We didn't return anything after execution
*/


public class RunAsync {


    // Without Lambda
    // Also No executor. Thread comes from "Fork Join Pool Global Thread"
    static Void readData(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(new Runnable() {
            @Override
            public void run() {
                try {
                    List<JsonDataModel> objects =
                            mapper.readValue(
                                    jsonFile,
                                    new TypeReference<List<JsonDataModel>>() {
                                    });

                    System.out.println("Thread Name: "+Thread.currentThread().getName());
                    System.out.println(objects.size());
                    //objects.forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Something wrong!");
                    throw new RuntimeException(e);
                }
            }
        });

        return runAsync.get();
    }


    // With Lambda   (Just remove everything before () expression)
    // Here, we use Custom Executor. So, Thread will come from our custom mentioned thread
    static void readDataWithLambdaAndCustomExecutor(File jsonFile) throws ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        Executor executor = Executors.newFixedThreadPool(3);

        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(
                () -> {
                try {
                    List<JsonDataModel> objects =
                            mapper.readValue(
                                    jsonFile,
                                    new TypeReference<List<JsonDataModel>>() {
                                    });

                    System.out.println("Thread Name: "+Thread.currentThread().getName());
                    System.out.println(objects.size());
                    //objects.forEach(System.out::println);
                } catch (IOException e) {
                    System.out.println("Something wrong!");
                    throw new RuntimeException(e);
                }

        }, executor);

        //return runAsync.get(); // If we think this is Blocking my thread then we can follow next line
        runAsync.toCompletableFuture();

        return;
    }



    public static void main(String[] args) throws ExecutionException, InterruptedException {

        // readData(new File("data.json"));
        // Process working on thread and this thread comes from Fork Join Pool Global Thread
        readData(new File("data.json"));


        //Thread will come from Custom Cached Thread and Used Lambda expression here
        readDataWithLambdaAndCustomExecutor(new File("data.json"));
    }
}
