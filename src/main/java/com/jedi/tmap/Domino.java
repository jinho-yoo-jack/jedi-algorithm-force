package com.jedi.tmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Domino {
    public static void main(String[] args) {
        int count = 0;
//        int[] A = new int[]{5, 1, 2, 6, 6, 1, 3, 1, 4, 3, 4, 3, 4, 6, 1, 2, 4, 1, 6, 2};
        int[] A = new int[]{2, 4, 1, 3, 4, 6, 2, 4, 1, 6};

        int start = 2;
        for(int i = 1; i < A.length; i+=2){ // 1 3 5 7 9 11 13 15 17 19
            for(int j = start; j < A.length; j+=2){ // 2 4 6 8 9 10 12 14 16 18 20
                if(A[i] == A[j]){
                    count++;
                    start +=2;
                    break;
                }
            }
        }
        System.out.println(count);
        System.out.println(A.length/2-count);


    }
}
