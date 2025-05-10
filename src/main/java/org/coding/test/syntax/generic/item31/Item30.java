package org.coding.test.syntax.generic.item31;

import java.util.function.UnaryOperator;

public class Item30 {
    private static UnaryOperator<Object> IDENTITY_FN = (t) -> t;

//    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        String[] strings = {"삼베", "대마", "나일론"};
        UnaryOperator<String> sameString = identityFunction();
        for (String string : strings) {
            System.out.println(sameString.apply(string));
        }

   }


}
