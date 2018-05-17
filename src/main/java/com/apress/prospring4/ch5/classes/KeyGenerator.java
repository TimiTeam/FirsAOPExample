package com.apress.prospring4.ch5.classes;

import java.util.Random;


public class KeyGenerator {
    public static final long WEAK_KEY = 0xFFFFFFF0000000L;
    public static final long STRONG_KEY = 0xABCDF03F590AE56L;
    private Random random = new Random();

    public long getKey(){
//        Generate the weak key
        int x = random.nextInt(3);
        if(x == 1){
            return WEAK_KEY;
        }
        return STRONG_KEY;
    }
}
