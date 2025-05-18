package com.jedi.testing.kakao;

import java.util.HashSet;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
//        int[] T = {0,0,0,0,2,3,3};
//        int[] A = {2,5,6};

//        int[] T = {0,0,1,2};
//        int[] A = {1,2};

        int[] T = {0, 3, 0, 0, 5, 0, 5};
        int[] A = {4, 2, 6, 1};

        Set<Integer> list = new HashSet<>();
        for (int j = 0; j < A.length; j++) {
            list.add(A[j]);
        }

        for (int i = 0; i < A.length; i++) {
            int wantedSkill = A[i];
            int prevSkill = T[wantedSkill]; // 2-> 0
            if (!list.contains(prevSkill)) {
                list.add(prevSkill);
            }
        }

        System.out.println(list);
        System.out.println(list.size());


    }
}
