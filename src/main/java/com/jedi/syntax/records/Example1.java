package com.jedi.syntax.records;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

public class Example1 {
    @Getter
    @RequiredArgsConstructor
    @EqualsAndHashCode
    public static class Element {
        private final String name;
        private final int value;
    }

    public static record Element1(String name, int value) {}

    public static void main(String[] args) {
        Element e1 = new Element("Old Plain Java", 8);
        Element e12 = new Element("Old Plain Java", 8);
        Element1 e2 = new Element1("New Plain Java", 14);
        Element1 e21 = new Element1("New Plain Java", 14);
        System.out.println(e1.toString());
        System.out.println(e2.toString());
        System.out.println(e1.equals(e12));
        System.out.println(e2.equals(e21));

        System.out.println("e1 hash code => " + e1.hashCode());
        System.out.println("e12 hash code => " + e12.hashCode());
        System.out.println(e1.hashCode() == e12.hashCode());
    }
}
