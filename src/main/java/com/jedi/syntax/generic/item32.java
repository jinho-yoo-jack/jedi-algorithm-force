package com.jedi.syntax.generic;

import java.util.concurrent.ThreadLocalRandom;

public class item32 {
    static <T> T[] toArray(T... args) {
        return args;
    }

    static <T> T[] pickTwo(T a, T b, T c) {
        return switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0 -> toArray(a, b);
            case 1 -> toArray(a, c);
            case 2 -> toArray(b, c);
            default -> throw new IllegalStateException("Unreachable");
        };
    }

    public static void main(String[] args) {
        String[] attributes = pickTwo("a", "b", "c");
    }
}
