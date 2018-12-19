package com.concurrency.concurrencydemo.example.singleton.singleton;

import com.concurrency.concurrencydemo.annotations.Recommend;
import com.concurrency.concurrencydemo.annotations.ThreadSafe;

//枚举模式: 最安全的
@ThreadSafe
@Recommend
public class SingletonExample7 {

    //私有构造函数
    private SingletonExample7(){ }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    public enum Singleton{
        INSTANCE;
        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton(){
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton(){
            return singleton;
        }
    }

}
