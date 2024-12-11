package org.coding.test.generic.syntax.right;

import org.coding.test.generic.syntax.Banana;
import org.coding.test.generic.syntax.Fruit;
import org.coding.test.generic.syntax.Strawberry;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<? super Fruit> fruits = new ArrayList<>();
        fruits.add(new Banana("delmonte", "yellow"));
        fruits.add(new Strawberry("strawberry", "red"));
    }
}
