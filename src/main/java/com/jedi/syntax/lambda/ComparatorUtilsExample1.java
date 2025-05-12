package com.jedi.syntax.lambda;

import java.util.*;

import static java.util.Comparator.comparing;

public class ComparatorUtilsExample1 {
    public static class Member {

        private String name;
        private int age;

        public Member(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }
    }
    public static void main(String[] args) {
        // Member

        List<Member> members = new ArrayList<>();
        members.add(new Member("가", 2));
        members.add(new Member("다", 2));
        members.add(new Member("라", 2));
        members.add(new Member("나", 2));
        members.add(new Member("다", 20));


        members.sort((m1, m2) ->
            m1.getName().equals(m2.getName()) ?
                m1.getAge() - m2.getAge() :
                m1.getName().compareTo(m2.getName()));


        members.sort(comparing(Member::getName)
            .thenComparing(Member::getAge));

        members.forEach(m -> System.out.println(m.getName() + ":" + m.getAge()));

    }

}
