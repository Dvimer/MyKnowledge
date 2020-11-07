package chapter8;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MyAppThread {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        if (executorService instanceof ThreadPoolExecutor){
            ((ThreadPoolExecutor) executorService).setCorePoolSize(10);
        }else {
            throw new AssertionError("Опаньки, Плохое допущение");
        }
    }
}
