package com.igeek.absolute;

/**
 * 简单的计算绝对值方法
 */

public class Absolute {
    public static void main(String[] args) {
        int a = 99;
        int b = -56;
        int c = 0;
        double i = 3.14;
        double j = -9.87;
        double k = 0.0;
        System.out.println(abs(a));
        System.out.println(abs(b));
        System.out.println(abs(c));
        System.out.println(abs(i));
        System.out.println(abs(j));
        System.out.println(abs(k));
    }
    
    public static int abs(int x) {
        return (x >= - x) ? x:(-x);
    }
    
    public static double abs(double x) {
        return (x >= - x) ? x:(-x);
    }
}
