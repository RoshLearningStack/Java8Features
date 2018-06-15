package com.learn.language.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class IntermediaryAndFinal {

    public static void main(String[] args) {

        Stream<String> stringStream = Stream.of("one", "two", "three", "four", "five");
        Predicate<String> predicate1 = Predicate.isEqual("two");
        Predicate<String> predicate2 = Predicate.isEqual("three");
        List<String> result = new ArrayList<String>();

        stringStream.peek(System.out::println)
        .filter(predicate1.or(predicate2))
        .forEach(result::add);

        System.out.println("Done!");
        System.out.println("size = " + result.size());
    }

}