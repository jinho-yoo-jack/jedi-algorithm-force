package com.jedi.syntax.call_by;

public class Example1 {
    public static class Node{
        public int value;
    }

    public static int add(int x) {
        return x + 1;
    }

    public static void main(String[] args) {
        int a = 1;
        System.out.println("a ::: " + a);
        System.out.println("add ::: " + add(a));
        String y = "hello";
        System.out.println("y ::: " + y);

        Node n = new Node();

        System.out.println("Node ::: " + n);

    }
}
