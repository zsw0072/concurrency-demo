package com.concurrency.concurrencydemo.example.immutable;

import com.concurrency.concurrencydemo.annotations.NotThreadSafe;
import com.google.common.collect.Maps;

import java.util.Map;

@NotThreadSafe
public class ImmutableExample1 {

    private final static Integer a = 1;
    private final static String b ="b";
    private final static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
    }

    public static void main(String[] args) {
      //  a = 2;
      //  b = "3";
      //  map = Maps.newHashMap();
        map.put(1,3);
        System.out.println(map.get(1));
    }

    private void test(final int a){
      //  a =1;
    }
}
