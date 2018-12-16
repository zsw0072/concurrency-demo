package com.concurrency.concurrencydemo.example.publish.singleton;

import com.concurrency.concurrencydemo.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次调用就初始化对象
 * 若是在多线程环境下是不安全的,由于,构造函数同时调用两次以上,
 * 生产的对象不是同一个
 */
@NotThreadSafe
public class SingletonExample1 {

    //私有构造函数
    private SingletonExample1(){};

    //单例对象
    private  static SingletonExample1 instance = null;

    //静态工厂方法
    public static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }

}
