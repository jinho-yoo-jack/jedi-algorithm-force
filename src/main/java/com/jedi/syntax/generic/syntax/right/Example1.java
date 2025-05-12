package com.jedi.syntax.generic.syntax.right;

import com.jedi.syntax.generic.syntax.Banana;
import com.jedi.syntax.generic.syntax.Fruit;
import com.jedi.syntax.generic.syntax.Strawberry;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    public static void main(String[] args) {
        List<? super Fruit> fruits = new ArrayList<>();
        fruits.add(new Banana("delmonte", "yellow"));
        fruits.add(new Strawberry("strawberry", "red"));
    }
}
