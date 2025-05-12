package com.jedi.testing.tmap;
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");
import java.util.Arrays;

public class MinSum {
    public static int getSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int twoTimeSum(int[] elements, int first, int second) {
        int size = elements.length;
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == first) {
                result[first] = getSum(elements[first]);
            } else if (i == second) {
                result[second] = getSum(elements[second]);
            } else {
                result[i] = elements[i];
            }
        }
        return Arrays.stream(result).sum();
    }

    public static int oneTimeSum(int[] elements, int first) {
        int size = elements.length;
        int result[] = new int[size];
        for (int i = 0; i < size; i++) {
            if (i == first) {
                result[first] = getSum(elements[first]);
                result[first] = getSum(result[first]);
            }else{
                result[i] = elements[i];
            }
        }
        return Arrays.stream(result).sum();
    }

    public int solution(int[] A) {
        // Implement your solution here
        int[] elements = A;
        Arrays.sort(elements);

        int size = elements.length;
        int avg = Arrays.stream(elements).sum() / size;

        int totalSum = 0;
        int oneTimeValue;
        int twoTimeValue;
        if (avg >= 100) {
            oneTimeValue = oneTimeSum(elements, 0);
            twoTimeValue = twoTimeSum(elements, 0, 1);
            totalSum = Math.min(oneTimeValue, twoTimeValue);
        } else {
            oneTimeValue = oneTimeSum(elements, size-1);
            twoTimeValue = twoTimeSum(elements, size-2, size-1);
            totalSum = Math.min(oneTimeValue, twoTimeValue);
        }
        return totalSum;
    }
}
