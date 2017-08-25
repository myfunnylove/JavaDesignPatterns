package com.khasanov.PrototypePattern;

public class PrototypePatternDemo {

    public static void main(String[] args) {

        Student tom  =new Student();
        tom.setAge(14);
        tom.setName("Tom");

        System.out.println(tom);


        Student andrey = (Student) tom;
        andrey.setName("Andrey");
        System.out.println(andrey);

    }
}
