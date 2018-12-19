package com.concurrency.concurrencydemo.example.immutable;

import com.concurrency.concurrencydemo.annotations.NotThreadSafe;
import com.concurrency.concurrencydemo.annotations.ThreadSafe;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer,Integer> map = Maps.newHashMap();

    static {
        map.put(1,2);
        map.put(3,4);
        map.put(5,6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1,3);
        System.out.println(map.get(1));
    }

}
