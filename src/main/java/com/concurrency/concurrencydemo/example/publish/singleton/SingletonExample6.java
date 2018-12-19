package com.concurrency.concurrencydemo.example.publish.singleton;
import com.concurrency.concurrencydemo.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类加载时进行创建
 */
@ThreadSafe
public class SingletonExample6 {

    //私有构造函数
    private SingletonExample6(){};
    //单例对象
    private  static SingletonExample6 instance = null;

    static {
        instance = new SingletonExample6();
    }

    //静态工厂方法
    public static SingletonExample6 getInstance(){
        return instance;
    }


    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
