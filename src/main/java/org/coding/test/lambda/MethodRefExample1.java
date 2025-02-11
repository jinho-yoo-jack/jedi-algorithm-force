package org.coding.test.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MethodRefExample1 {
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(3, 1, 4, 2, 5);

//        arr.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 > o1 ? o2 : o1;
//            }
//        });

//        arr.sort((arr1, arr2) -> arr1 < arr2 ? arr1 - arr2 : arr1 == arr2 ? 0 : 1);
//        arr.sort((o1, o2) -> o2 > o1 ? o2 : o1);
        arr.sort(Math::min);
        arr.sort(Integer::compare);

//        arr.sort(Comparator.naturalOrder());

        System.out.println(arr.toString());

    }
}
