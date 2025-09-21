package com.jedi.testing.naver;

import java.util.*;

public class Solution1 {
    public int solution() {
        int[] A = {3, 8, 2, 3, 3};

        // Implement your solution here
        Map<Integer, Integer> e = new HashMap<>();

        for (int i = 0; i < A.length; i++) {
            if (e.containsKey(A[i])) {
                e.put(A[i], e.get(A[i]) + 1);
            } else {
                e.put(A[i], 1);
            }
        }

        if (e.size() == 1) return A[0];
        List<Integer> elements = new ArrayList<>(e.keySet());
        elements.sort((o1, o2) -> e.get(o2) - e.get(o1));
        int firstElement = elements.get(0);
        int secondElement = elements.get(1);
        if (firstElement -1 == secondElement) return elements.get(0);
        else return 0;


    }

}
