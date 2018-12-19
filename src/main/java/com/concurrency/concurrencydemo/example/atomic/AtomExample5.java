package com.concurrency.concurrencydemo.example.atomic;

import com.concurrency.concurrencydemo.annotations.ThreadSafe;
import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 AtomicIntegerFieldUpdater是更新某个类的对象的某个值，
 这个值必须是用volatile修饰的
 *
 */
@ThreadSafe
public class AtomExample5 {

    private static AtomicIntegerFieldUpdater<AtomExample5> updateData
            = AtomicIntegerFieldUpdater.newUpdater(AtomExample5.class,"count");


    public volatile int count = 100;

    private static AtomExample5 example5 = new AtomExample5();

    public static void main(String[] args) {

        if(updateData.compareAndSet(example5,100,120)){
            System.out.println("update success 1, {}"+example5.getCount());
        }

        if(updateData.compareAndSet(example5,100,120)){
            System.out.println("update success 2, {}"+example5.getCount());
        }else{
            System.out.println("update failed , {}"+example5.getCount());
        }
    }

    public int getCount() {
        return count;
    }
}
