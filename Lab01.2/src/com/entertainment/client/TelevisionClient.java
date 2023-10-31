package com.entertainment.client;

import com.entertainment.Television;

class TelevisionClient {
    public static void main(String[] args) {
        Television tv1 = new Television();
        Television tv2 = new Television("RCA", 10);

        System.out.println(tv1);
        System.out.println(tv2);

        tv2.changeChannel(9);
        System.out.println(tv2);
        System.out.println();

        Television tvA = new Television("Sony", 50);
        Television tvB = new Television("Sony", 50);
        System.out.println(tvA.equals(tvB));
        System.out.println();
        System.out.println(tvA == tvB);
    }
}