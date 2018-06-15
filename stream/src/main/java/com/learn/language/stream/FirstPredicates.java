package com.learn.language.stream;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class FirstPredicates {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("one", "two", "three", "four", "five");

        Predicate<String> predicate = s -> s.length() > 3;
        Predicate<String> predicateEqual2 = Predicate.isEqual("two");
        Predicate<String> predicateEqual3 = Predicate.isEqual("three");

        stringStream
                .filter(predicateEqual2.or(predicateEqual3))
                .forEach(s -> System.out.println(s));

    }

}