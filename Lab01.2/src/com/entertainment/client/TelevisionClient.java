package com.entertainment.client;

import com.entertainment.Television;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

class TelevisionClient {
    public static void main(String[] args) {
        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        Television tvC = new Television("Samsung", 32);
        Television tvD = new Television("LG", 12);
        System.out.println(tvA.equals(tvB));
        System.out.println();
        System.out.println(tvA == tvB);

        Set<Television> tvs = new TreeSet<>();
        tvs.add(tvA);
        tvs.add(tvB);
        tvs.add(tvC);
        tvs.add(tvD);

        System.out.println(tvs);
        tvs.add(tvB); // should be rejected as a dupe

        System.out.println("The size of the set is: " + tvs.size());
    }
}