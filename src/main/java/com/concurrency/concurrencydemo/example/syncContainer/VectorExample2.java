package com.concurrency.concurrencydemo.example.syncContainer;

import com.concurrency.concurrencydemo.annotations.NotThreadSafe;

import java.util.Vector;

@NotThreadSafe
public class VectorExample2 {

    private  static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {
            for (int i= 0 ; i < 10; i++) {
                vector.add(i);
            }

            Thread thread = new Thread() {
                public void run() {
                    for (int i=0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i=0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            thread.start();
            thread2.start();
        }
    }
}
