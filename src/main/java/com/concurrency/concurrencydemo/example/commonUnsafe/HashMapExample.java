package com.concurrency.concurrencydemo.example.commonUnsafe;

import com.concurrency.concurrencydemo.annotations.NotThreadSafe;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@NotThreadSafe
public class HashMapExample {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    private static Map<Integer,Integer> map = new HashMap<Integer,Integer>();

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            final int count = i;
            executorService.execute(()->{
                try{
                    semaphore.acquire(); //获得许可信号量
                    update(count);
                    semaphore.release(); //释放许可信号量

                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown(); //每执行完一次操作，计算器会 - 1
            });
        }
        countDownLatch.await(); //保证所有的请求执行完
        executorService.shutdown();
        System.out.println(map.size());
    }

    private static void update(int i) {
        map.put(i,i);
    }
}
