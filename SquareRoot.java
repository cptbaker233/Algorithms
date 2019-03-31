package com.igeek.square_root;

/**
 * 仅展示算术平方根部分,计算算术平方根,保留几位小数.
 */

public class SquareRoot {
    public static void main(String[] args) {
        System.out.println(squareRoot(2, 1));
    }
    
    public static double squareRoot(double x, int a) {
        double acc = 1;
        for (int i = 1; i <= a; i ++) {
            acc = acc / 10;
        }
        double accuracy = 1;
        double i = 0;
        while (accuracy >= 0.000000000000001) {
            if (i * i > x) {
                i -= accuracy;
                accuracy /= 10;
            }
            i += accuracy;
        }
        if (i / acc % 1 < 0.5) {
            return (int)(i / acc) * acc;
        } else {
            return (int)(i / acc + 1) * acc;
        }
    }
}
