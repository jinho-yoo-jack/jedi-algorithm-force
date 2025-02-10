package org.coding.test.data.structure.delivery.value;

public class Example1 {
    static void addByValue(int a){
        a += 100;
    }
    static void addByReference(int[] a){
        a[0] += 100;
    }
    public static void main(String[] args) {
        int x = 10;
        int[] y = {1};

        addByValue(x);
        System.out.println("Add By Value - Output ::: " + x);

        addByReference(y);
        System.out.println("Add By Reference - Output ::: " + y[0]);
    }
}
