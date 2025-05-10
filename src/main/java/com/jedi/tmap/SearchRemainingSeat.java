package com.jedi.tmap;

import java.util.*;

public class SearchRemainingSeat {
    // disable = false;
    // enable = true;
    public static Map<Integer, HashMap<Character, Boolean>> makeSeatInfo(int n, String[] reserved) {
        List<String> reservationSeat = Arrays.asList(reserved);
        Map<Integer, HashMap<Character, Boolean>> seats = new HashMap<>();
        for (int i = 1; i < n + 1; i++) {
            HashMap<Character, Boolean> seat = new HashMap<>();
            for (int j = 0; j < 12; j++) {
                String currentSeat = String.valueOf(i) + (char) (65 + j);
                if (reservationSeat.contains(currentSeat)) {
                    seat.put((char) (65 + j), false);
                    continue;
                }
                if (j == 3 || j == 8) {
                    seat.put((char) (65 + j), false);
                } else {
                    seat.put((char) (65 + j), true);
                }
                seats.put(i, seat);
            }
        }
        return seats;
    }

    public static boolean findSequenceSeats(HashMap<Character, Boolean> seats) {
        List<Boolean> values = new ArrayList<>(seats.values());
        boolean isReserved = false;
        for (int i = 4; i < 8; i++) {
            if (!values.get(i)) {
                isReserved = false;
                break;
            }
            isReserved = true;
        }
        return isReserved;
    }

    public static boolean findTwoTwoSeats(HashMap<Character, Boolean> seats, int skip, int first, int last) {
        List<Boolean> values = new ArrayList<>(seats.values());
        boolean isReserved = false;
        for (int i = first; i < last; i++) {
            if (i == skip) continue;
            if (!values.get(i)) {
                isReserved = false;
                break;
            }
            isReserved = true;
        }
        return isReserved;
    }

    public static boolean isAllReservation(HashMap<Character, Boolean> seats) {
        List<Boolean> values = new ArrayList<>(seats.values());
        boolean isReserved = false;
        for (int i = 0; i < 12; i++) {
            if(i == 0 || i == 3|| i == 8|| i == 11) continue;
            if (!values.get(i)) {
                isReserved = false;
                break;
            }
            isReserved = true;
        }
        return isReserved;
    }

    public static void main(String[] args) {
        String S = "1A 3C 2B 20G 5A";
        int cnt = 0;
        String[] reserved = S.split(" ");
        Arrays.sort(reserved);
        Map<Integer, HashMap<Character, Boolean>> seats = makeSeatInfo(22, reserved);
        for (int row : seats.keySet()) {
            HashMap<Character, Boolean> row_seats = seats.get(row);
            boolean isAllReserve = isAllReservation(row_seats);
            if (isAllReserve){
                cnt += 2;
                continue;
            }
            boolean isEnable = findSequenceSeats(row_seats);
            if (isEnable) {
                cnt++;
                continue;
            }
            isEnable = findTwoTwoSeats(row_seats, 3, 1, 6);
            if (isEnable) cnt++;
            isEnable = findTwoTwoSeats(row_seats, 8, 6, 11);
            if (isEnable) cnt++;
        }
        System.out.println(cnt);
    }
}
