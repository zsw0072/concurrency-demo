package com.concurrency.concurrencydemo.example.publish;

import com.concurrency.concurrencydemo.annotations.NotRecommend;
import com.concurrency.concurrencydemo.annotations.NotThreadSafe;

@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape(){
        new InnerClass();
    }

    private class InnerClass{
        public  InnerClass(){
            System.out.println("{} "+Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
