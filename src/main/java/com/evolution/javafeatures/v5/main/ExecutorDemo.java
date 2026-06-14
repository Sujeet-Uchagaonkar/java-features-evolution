package com.evolution.javafeatures.v5.main;

import java.time.LocalDateTime;
import java.util.concurrent.*;
import java.util.stream.IntStream;

import static java.lang.Thread.sleep;

public class ExecutorDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Executor is high level concurrency framework which simplifies thread management and task execution
        //Separates task submission from thread management.
        //Improves application performance by reusing threads through thread pools.
        //Provides better control over concurrent task execution and resource utilization.

        // Executor is a base interface and ExecutorService extends it.
        // We can create following types of thread pools which ExecutorService can use to execute : SingleThreadExecutor, FixedThreadPool, CachedThreadPool, ScheduledExecutorService
        // SingleThreadExecutor - Creates a thread pool with a single thread that executes tasks sequentially.
        // FixedThreadPool - Creates a pool with a fixed number of threads. Excess tasks are queued until a thread becomes available.
        // CachedThreadPool - Creates threads as needed and reuses idle ones. Suitable for many short-lived asynchronous tasks.

        ExecutorService singleThreadexecutor = Executors.newSingleThreadExecutor();
        ExecutorService fixedThreadexecutor = Executors.newFixedThreadPool(5);
        ExecutorService cachedThreadExecutor = Executors.newCachedThreadPool();

        //Create Runnable Task
        Runnable runnableTask = () -> {
            IntStream.range(1,6).forEach( x->{
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Runnable task #"+x+" executed at :"+ LocalDateTime.now());
            }
        );
        };

        //Create Callable Task
        Callable<String> callableTask = () -> {
            sleep(3000);
            return "Callable Task Completed!!";
        };


        System.out.println("singleThreadexecutor tasks started at :"+LocalDateTime.now());
        singleThreadexecutor.submit(runnableTask);
        singleThreadexecutor.shutdown();
        System.out.println("singleThreadexecutor tasks ended at :"+LocalDateTime.now());


        System.out.println("cachedThreadExecutorResponse tasks started at :"+LocalDateTime.now());
        //Method execute is for tasks that don’t need to return anything. It takes only Runnable tasks
        cachedThreadExecutor.execute(runnableTask);
        //Method is for tasks that might have a result or might throw an exception, and you want to be informed about it.
        Future<String> cachedThreadExecutorResponse = cachedThreadExecutor.submit(callableTask);
        System.out.println("Cached callable future response: "+cachedThreadExecutorResponse.get());
        cachedThreadExecutor.shutdown();
        System.out.println("cachedThreadExecutorResponse tasks ended at :"+LocalDateTime.now());

    }

}
