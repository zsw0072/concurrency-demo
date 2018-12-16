package com.concurrency.concurrencydemo.example.singleton.singleton;
import com.concurrency.concurrencydemo.annotations.ThreadSafe;

/**
 * 懒汉模式 -> 双重同步锁单例模式
 * 单例实例在第一次调用就初始化对象
 * 若是在多线程环境下是不安全的,由于,构造函数同时调用两次以上,
 * 生产的对象不是同一个
 */


@ThreadSafe
public class SingletonExample5 {

    //私有构造函数
    private SingletonExample5(){};

    //单线程下指令重排序不会有影响
    // 1.memory = allocate() 分配对象的内存空间
    // 2.ctorInstance() 初始化对象
    // 3. instance = memory 设置instance对象指向刚分配的内存

    //多线程下的情况
    //JVM 和 CPU 优化, 发生了 指令重排序
    // 1.memory = allocate() 分配对象的内存空间
    // 3. instance = memory 设置instance对象指向刚分配的内存
    // 2.ctorInstance() 初始化对象

    //单例对象 加入volatile volatile+双重同步检查机制 -> 限制指令重排序
    private volatile  static SingletonExample5 instance = null;

    //静态工厂方法
    public static SingletonExample5 getInstance(){
        if (instance == null){ //双重检查机制  //B - 2, 发现已经初始化对象就直接返回
            synchronized (SingletonExample5.class){ //同步锁
                if (instance == null){
                    instance = new SingletonExample5();  // A - 3
                }
            }
        }
        return instance;
    }

}
