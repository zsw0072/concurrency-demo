package com.concurrency.concurrencydemo.example.count;

import com.concurrency.concurrencydemo.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

@ThreadSafe
public class CountExample2 {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    public static AtomicInteger count = new AtomicInteger(0);


    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {

                    semaphore.acquire(); //获得许可信号量
                    add();
                    semaphore.release(); //释放许可信号量

                } catch (Exception e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown(); //每执行完一次操作，计算器会 - 1
            });
        }
        countDownLatch.await(); //保证所有的请求执行完
        executorService.shutdown();
        System.out.printf("count: " + count.get());
    }

    private static void add() {
        count.incrementAndGet(); //先增加再获取 //当前的值与底层的值作对比，两个值相同才继续相关操作，（CAS - compareAndSwap 实现）
        // count.getAndIncrement(); //先获取再增加
    }
}
