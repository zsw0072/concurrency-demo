package com.concurrency.concurrencydemo.example.singleton.singleton;
import com.concurrency.concurrencydemo.annotations.NotRecommend;
import com.concurrency.concurrencydemo.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次调用就初始化对象
 * 若是在多线程环境下是不安全的,由于,构造函数同时调用两次以上,
 * 生产的对象不是同一个
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {

    //私有构造函数
    private SingletonExample3(){};

    //单例对象
    private  static SingletonExample3 instance = null;

    //静态工厂方法
    public synchronized static SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }

}
