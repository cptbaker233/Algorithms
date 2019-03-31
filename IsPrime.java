package com.igeek.prime;

/**
 * 找质数方法
 */

public class IsPrime {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i ++) {
            if (isPrime(i)) {
                System.out.println(i + "是质数.");
            }
        }
        isPrime(16);
    }
    
    public static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i * i <= x; i ++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }
}
