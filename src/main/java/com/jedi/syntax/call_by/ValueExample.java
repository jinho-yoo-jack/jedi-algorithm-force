package com.jedi.syntax.call_by;

import java.util.Arrays;

public class ValueExample {

    public static void sort(int[] notSortedArray){
        Arrays.sort(notSortedArray);
    }

    public static void print(int a){
        System.out.println(a-99);
    }



    public static void main(String[] args) {
        int[] elements = new int[]{88, 23, 1, 5, 199}; // elements의 메모리 주소와 notSortedArray의 메모리 주소가 동일
        sort(elements);
        System.out.println(Arrays.toString(elements));

        int x = 99;
        print(x);
        System.out.println(x);
    }
}
