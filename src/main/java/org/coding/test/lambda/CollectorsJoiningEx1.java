package org.coding.test.lambda;

import java.util.List;
import java.util.stream.Collectors;

public class CollectorsJoiningEx1 {
    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "cherry", "date");

        String allFruits = fruits.stream().collect(Collectors.joining(","));

    }
}
