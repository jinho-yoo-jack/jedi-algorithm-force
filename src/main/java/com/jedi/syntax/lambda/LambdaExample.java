package com.jedi.syntax.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 9, 3, 8, 5, 10, 7, 4, 2, 6);

        numbers.sort(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o1 - o2; // 오름 차순
//                return o1 - o2; // 내림 차순
            }
        });

        System.out.println(Arrays.toString(numbers.toArray()));
    }


}
