package com.learn.language.lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Features {

    public static void main(String[] args) {

        // method refrence
        Consumer<String> consumer = s -> System.out.println("Hello world!");
        consumer.accept(null);

        // collection
        List<String> list = new ArrayList<String>();
        list.add("user1");
        list.add("user2");
        list.add("user3");

        list.forEach(System.out::println);

    }

}