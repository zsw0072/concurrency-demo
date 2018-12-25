package com.concurrency.concurrencydemo.example.syncContainer;


import java.util.Iterator;
import java.util.List;
import java.util.Vector;


//单线程时操作使用foreach或是迭代器操作同步容器的移除操作时，会出现ConcurrentModificationException
//若希望移除某个远程则先做个标记，再在遍历完成后再删除
public class VectorExample3 {

    //java.util.ConcurrentModificationException
    private static void test1(Vector<Integer> v1){
        for (Integer i : v1) {
            if (.equals(3)){
                v1.remove(i);
            }
        }
    }

    //java.util.ConcurrentModificationException
    private static void test2(Vector<Integer> v1){
        Iterator<Integer> iterator = v1.iterator();
        while (iterator.hasNext()){
            Integer i = iterator.next();
            if (i ==3){i
                v1.remove(i);
            }
        }
    }

    //成功的
    private static void test3(Vector<Integer> v1){
        for (int i = 0; i < v1.size(); i++) {
            if (v1.get(i).equals(3)){
                v1.remove(i);
            }
        }
    }

    public static void main(String[] args) {

            Vector<Integer> vector = new Vector<Integer>();

            vector.add(1);
            vector.add(2);
            vector.add(3);
            test1(vector);

        }


    }

