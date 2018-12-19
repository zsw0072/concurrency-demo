package com.concurrency.concurrencydemo.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncExample2 {

    //修饰一个代码块
    public static void test1(int j){
        synchronized (SyncExample2.class){
            for (int i = 0; i < 10; i++) {
                System.out.println("test1: "+i+"  "+j);
            }
        }
    }

    //修饰一个静态方法的使用
    public static synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println("test1: "+i+"  "+j);
        }
    }

    public static void main(String[] args) {

        SyncExample2 syncExample1 = new SyncExample2();
        SyncExample2 syncExample2 = new SyncExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            syncExample1.test1(1);
        });
        executorService.execute(()->{
            syncExample2.test1(2);
        });
    }
}
