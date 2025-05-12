package org.coding.test.algo.kakako;

import java.util.*;

public class Solution1 {
    public static int maxFamilySeats(int N, String S) {
        // 예약된 좌석 저장: Map<Row번호, Set<열 레이블>>
        Map<Integer, Set<Character>> reservedMap = new HashMap<>();

        if (S != null && !S.isEmpty()) {
            for (String seat : S.split(" ")) {
                int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
                char seatLetter = seat.charAt(seat.length() - 1);

                reservedMap
                        .computeIfAbsent(row, k -> new HashSet<>())
                        .add(seatLetter);
            }
        }

        int totalFamilies = 0;
        int totalFamilies1 = 2 * N;

        for (Map.Entry<Integer, Set<Character>> entry : reservedMap.entrySet()) {
            Set<Character> reserved = entry.getValue();

            boolean left = !(reserved.contains('B') || reserved.contains('C') ||
                    reserved.contains('D') || reserved.contains('E'));

            boolean middle = !(reserved.contains('D') || reserved.contains('E') ||
                    reserved.contains('F') || reserved.contains('G'));

            boolean right = !(reserved.contains('F') || reserved.contains('G') ||
                    reserved.contains('H') || reserved.contains('J'));

            if (!left) totalFamilies1-=1;
            if (!right) totalFamilies1-=1;
            if (!middle) totalFamilies1-=1;

        }
        for (int row = 1; row <= N; row++) {
            Set<Character> reserved = reservedMap.getOrDefault(row, new HashSet<>());

            boolean left = !(reserved.contains('B') || reserved.contains('C') ||
                    reserved.contains('D') || reserved.contains('E'));

            boolean middle = !(reserved.contains('D') || reserved.contains('E') ||
                    reserved.contains('F') || reserved.contains('G'));

            boolean right = !(reserved.contains('F') || reserved.contains('G') ||
                    reserved.contains('H') || reserved.contains('J'));

            int familiesInRow = 0;
            if (left) familiesInRow++;
            if (right) familiesInRow++;
            // 가운데 그룹은 왼쪽, 오른쪽 모두 안 될 때만 추가
            if (!left && !right && middle) familiesInRow++;

            totalFamilies += familiesInRow;
        }

        System.out.println(totalFamilies1 + " vs " + totalFamilies);

        return totalFamilies;
    }

    public static void main(String[] args) {
        int N = 20;
        String S = "1A 3C 2B 20G 5A";
        int result = maxFamilySeats(N, S);
        System.out.println("가족이 앉을 수 있는 최대 그룹 수: " + result);
    }
}
