package com.concurrency.concurrencydemo.example.singleton.singleton;
import com.concurrency.concurrencydemo.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类加载时进行创建
 */
@ThreadSafe
public class SingletonExample2 {

    //私有构造函数
    private SingletonExample2(){};

    //单例对象
    private  static SingletonExample2 instance = new SingletonExample2();

    //静态工厂方法
    public static SingletonExample2 getInstance(){
        return instance;
    }

}
