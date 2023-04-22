package org.geeksforgeeks;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerDemo {

    public static void main(String[] args) {
        System.out.println("Starting server...");
        Scanner scanner = new Scanner(System.in);
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        System.out.println("Provide your first input");
        while (true){
           String data = scanner.nextLine();
           executorService.submit(new Runnable() {
               @Override
               public void run() {
                   System.out.println("Processing Data: " +data + " with Threadname : " +Thread.currentThread().getName());
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
                   System.out.println("Enter your next input: ");
               }
           });
        }
    }
}
