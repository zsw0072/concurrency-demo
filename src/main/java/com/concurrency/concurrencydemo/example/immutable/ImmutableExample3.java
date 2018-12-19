package com.concurrency.concurrencydemo.example.immutable;

import com.concurrency.concurrencydemo.annotations.ThreadSafe;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;

import java.util.List;

@ThreadSafe
public class ImmutableExample3 {

    private final  static List<Integer> list = ImmutableList.of(1,2,3);

    private final static ImmutableSet set = ImmutableSet.copyOf(list);

    private final static ImmutableMap<Integer,Integer> map =
            ImmutableMap.of(1,2,3,4);

    private final static ImmutableMap<Integer,Integer> map1 =
            ImmutableMap.<Integer,Integer>builder().put(1,2).put(3,4).build();

    public static void main(String[] args) {
        //list.add(4);
        //set.add(4);
        //map1.put(1,4);
        System.out.println(map.get(1));
    }
}
