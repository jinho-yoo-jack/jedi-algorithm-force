package com.jedi.syntax.reflect;

import java.lang.reflect.Field;

public class JacksonReflectionExample1 {
    public static class Greet {
        private String name;  // Setter 없음!

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 1. 기본 생성자 호출
        Greet greet = new Greet();
        System.out.println("생성 후: " + greet.getName()); // null

        // 2. Reflection으로 name 필드 찾기
        Class<?> clazz = greet.getClass();
        Field nameField = Greet.class.getDeclaredField("name");

        // 3. setAccessible(true) 호출
        nameField.setAccessible(true);

        // 4. field.set()으로 직접 값 할당
        nameField.set(greet, "홍길동");

        System.out.println("할당 후: " + greet.getName()); // 홍길동
        System.out.println("✅ Setter 없이도 성공!");
    }
}
