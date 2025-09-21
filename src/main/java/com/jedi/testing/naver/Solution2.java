package com.jedi.testing.naver;

import java.util.*;

public class Solution2 {
    public int solution() {
        String S = "WWWRRWWR";
        List<String> elements = List.of(S.split(""));
        if (!elements.contains("R")) return 0;
        if (elements.size() > 10000) return -1;

        // 1. 첫 번재 R의 위치를 찾는다.
        int first = elements.indexOf("R");
        int second = 0;
        int last = 0;
        String firstRightElement = elements.get(first + 1);
        // 2. 두 번째 R의 위치가 첫 번째 R의 index + 1 인가?
        if ("R".equals(firstRightElement)) {
            // 이거는 현재 R이 최소 2개 이상 붙어 있는 경우
            second = first + 1;
            for (int i = second + 1; i < elements.size(); i++) {
                if (elements.get(i).equals("R")) {
                    last = i;
                }
            }
            return last - second - 1;

        } else {
            for (int i = first; i < elements.size(); i++) {
                if (elements.get(i).equals("R")) second = i;
            }
            for (int i = second; i < elements.size(); i++) {
                if (elements.get(i).equals("R")) last = i;
            }
            return (last - second - 1) + (second - first - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().solution());
    }
}
