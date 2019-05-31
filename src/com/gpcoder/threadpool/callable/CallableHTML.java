package com.gpcoder.threadpool.callable;

import java.util.concurrent.*;

public class CallableHTML {
    public static void main(String a, String b){

        ExecutorService executor = Executors.newFixedThreadPool(5);

        Callable<String> callable;
        Future<Integer> future;


        executor.shutdown();
        while (!executor.isTerminated()){

        }

    }
}
