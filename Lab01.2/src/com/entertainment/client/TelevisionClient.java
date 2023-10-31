package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;

class TelevisionClient {
    public static void main(String[] args) {
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        System.out.println(tvA.equals(tvB));
        System.out.println();
        System.out.println(tvA == tvB);

//        System.out.println(tvA.hashCode());
//        System.out.println(tvB.hashCode());

        Set<Television> tvs = new HashSet<>();
        tvs.add(tvA);
        System.out.println(tvs);
        tvs.add(tvB); // should be rejected as a dupe
        System.out.println(tvs.size());
    }
}