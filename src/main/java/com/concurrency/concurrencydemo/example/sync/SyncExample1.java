package com.concurrency.concurrencydemo.example.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SyncExample1 {

    //修饰一个代码块
    public void test1(int j){
        synchronized (this){
            for (int i = 0; i < 10; i++) {
                System.out.println("test1: "+i+"  "+j);
            }
        }
    }

    //修饰一个方法的使用
    public synchronized void test2(int j){
        for (int i = 0; i < 10; i++) {
            System.out.println("test1: "+i+"  "+j);
        }
    }

    public static void main(String[] args) {

        SyncExample1 syncExample1 = new SyncExample1();
        SyncExample1 syncExample2 = new SyncExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(()->{
            syncExample1.test2(1);
        });
        executorService.execute(()->{
            syncExample2.test2(2);
        });
    }
}
