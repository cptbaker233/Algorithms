package com.igeek.prime;

/**
 * ����������
 */

public class IsPrime {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i ++) {
            if (isPrime(i)) {
                System.out.println(i + "������.");
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
