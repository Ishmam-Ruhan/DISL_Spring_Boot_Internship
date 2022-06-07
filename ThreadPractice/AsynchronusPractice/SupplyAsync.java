package com.ishmamruhan.Dhrubok_Practice_Session.AsynchronusPractice;

/*
 *   Supply Async Method:
 *   ------------------
 *   Method type will return something.
 *   We will return something after execution
 */

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class SupplyAsync {

    // Our Database
    static List<JsonDataModel> fetchData(){
        ObjectMapper mapper = new ObjectMapper();

        try {
            List<JsonDataModel> data = mapper.readValue(new File("data.json"), new TypeReference<List<JsonDataModel>>() {
            });

            return data;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  null;
    }



    static List<JsonDataModel> getData () throws ExecutionException, InterruptedException {

        // Executor has 5 threads
        Executor executor = Executors.newFixedThreadPool(5);

        // Here we use Supplier Functional interface and our custom executor
        // Supplier functional interface won't take any input. It just returns
        CompletableFuture<List<JsonDataModel>> supplyAsync = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread: " + Thread.currentThread().getName());
            return fetchData();
        }, executor);


        return supplyAsync.get();
    }

    /*
    *   Supply Async Scenario:
    *
    *   We have to find all id greater then 20 and send notification:
    */


    static void notifyUsers(){

        Executor executor = Executors.newFixedThreadPool(5);

        CompletableFuture.supplyAsync(() -> {
            System.out.println("Get data: "+Thread.currentThread().getName());
           return fetchData();
        }, executor).thenApplyAsync((users) -> {
            System.out.println("Filter data: "+Thread.currentThread().getName());
            return users.stream()
                        .filter(user -> user.getId()>20)
                        .collect(Collectors.toList());
        },executor).thenApplyAsync((users) -> {
            System.out.println("Separate email data: "+Thread.currentThread().getName());
            return users.stream()
                    .map(user -> user.getEmail())
                    .collect(Collectors.toList());
        },executor).thenApplyAsync((emails) -> {
            System.out.println("Sort data: "+Thread.currentThread().getName());
            return emails.stream()
                    .sorted(new Comparator<String>() {
                        @Override
                        public int compare(String o1, String o2) {
                            return o1.compareTo(o2);
                        }
                    })
                    .collect(Collectors.toList());
        }, executor).thenAcceptAsync((usersEmail) -> {
            System.out.println("Send Mail data: "+Thread.currentThread().getName());
            usersEmail.stream().forEach(userEmail -> sendMail(userEmail));
        },executor);

    }

    static void sendMail(String email){
        System.out.println("Sending email: "+email);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //getData().forEach(System.out::println);

        notifyUsers();
    }
}
