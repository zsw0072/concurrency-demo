package com.concurrency.concurrencydemo.example.commonUnsafe;


import com.concurrency.concurrencydemo.annotations.ThreadSafe;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.text.SimpleDateFormat;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@ThreadSafe
public class DateFormatExample3 {

    //请求总数
    public static int clientTotal = 5000;
    //同时并发执行的线程数
    public static int threadTotal = 200;

    private static DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyyMMdd");

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);
        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(()->{
                try{

                    semaphore.acquire(); //获得许可信号量
                    update();
                    semaphore.release(); //释放许可信号量

                }catch (Exception e){
                    e.printStackTrace();
                }
                countDownLatch.countDown(); //每执行完一次操作，计算器会 - 1
            });
        }
        countDownLatch.await(); //保证所有的请求执行完
        executorService.shutdown();

    }

    private static void update() {
        System.out.println(
                DateTime.parse("20180208",dateTimeFormatter).toDate()
            );
    }

}
