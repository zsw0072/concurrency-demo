package com.concurrency.concurrencydemo.example.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchExample2 {

    private final static int threadCount = 200;

    public static void main(String[] args) throws Exception{

        ExecutorService executorService = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(threadCount);
        for (int i = 0; i < threadCount ; i++) {
            final int threadNum = i;

            executorService.execute(()->{
                try{
                    test1(threadNum);
                }catch (Exception e ){
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        System.out.println("finish");
        executorService.shutdown();
    }

    private static void test1(int threadNum) throws Exception{
        Thread.sleep(100);
        System.out.println(threadNum);

    }
}
