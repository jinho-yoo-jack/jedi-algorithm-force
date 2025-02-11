package org.coding.test.lambda;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CollectorsMinEx1 {
    public static void main(String[] args) {
        List<Integer> elements = List.of(3, 5, 1, 9, 7, 2);
        Optional<Integer> min = elements.stream().min(Comparator.naturalOrder());
        min.ifPresent(value -> System.out.println("최소값: " + value)); // 1
    }
}
