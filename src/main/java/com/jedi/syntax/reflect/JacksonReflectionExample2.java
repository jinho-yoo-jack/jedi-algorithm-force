package com.jedi.syntax.reflect;

import lombok.ToString;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JacksonReflectionExample2 {
    @ToString
    public static class Greet {
        private String name;  // Setter 없음!

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // 1. 기본 생성자 호출
        Greet greet = new Greet();
        System.out.println("생성 후: " + greet.getName()); // null

        // 2. Reflection으로 name 필드 찾기
        Class<?> clazz = greet.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName());
            String fieldName  = field.getName();
            fieldName = fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
            Method f = clazz.getDeclaredMethod("set" + fieldName, String.class);
            f.invoke(greet, "Jinho");
        }
        System.out.println(greet.toString());
    }
}
