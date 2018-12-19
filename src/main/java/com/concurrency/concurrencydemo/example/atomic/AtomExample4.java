package com.concurrency.concurrencydemo.example.atomic;

import com.concurrency.concurrencydemo.annotations.ThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.LongAdder;

/**
 *
 * 优先使用LongAdder，在高并发时，更加适合使用
 * 低并发时优先使用AtomicLong
 */
@ThreadSafe
public class AtomExample4 {

    private static AtomicReference<Integer> count = new AtomicReference<Integer>(0);

    public static void main(String[] args) {

        count.compareAndSet(0,2); // 2
        count.compareAndSet(0,1); // no
        count.compareAndSet(1,3); // no
        count.compareAndSet(2,4); // 4
        count.compareAndSet(3,5); // no

        System.out.printf("count:"+count.get());
    }
}
