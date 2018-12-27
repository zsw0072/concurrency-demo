package com.concurrency.concurrencydemo.example.AQS;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreExample4 {

    private final static int threadCount = 20;

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < threadCount ; i++) {
            final int threadNum = i;
            executorService.execute(()->{
                try{
                    if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){ //尝试获取一个许可
                        test1(threadNum);
                        semaphore.release(); //释放一个许可
                    }
                }catch (Exception e ){
                    e.printStackTrace();
                }
            });
        }
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void test1(int threadNum) throws Exception{
        System.out.println(threadNum);
        Thread.sleep(1000);
    }
}
