package com.jedi.algo.recursive;

public class EuclideanReciprocal {

    public static double euclidean(double a, double b) {
        double c = a % b;
        if (c == 0) {
            return b;
        }
        return euclidean(b, c);
    }

    public static void main(String[] args) {
        System.out.println(euclidean(192, 162));
    }
}
