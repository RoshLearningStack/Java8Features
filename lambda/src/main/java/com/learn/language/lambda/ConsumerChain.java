package com.learn.language.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerChain {

    public static void main(String[] args) {

        // iterate
        List<String> data = Arrays.asList("one", "two", "three", "four", "five");
        Consumer<String> consumer = s -> System.out.println(s);
        data.forEach(consumer);

        List<String> numericData = Arrays.asList("1", "2", "3", "4", "5");
        List<String> result = new ArrayList<String>();
        Consumer<String> consumer1 = System.out::println;
        Consumer<String> consumer2 = result::add;
        numericData.forEach(consumer1.andThen(consumer2));

        System.out.println("Size fo the result list is " + result.size());

    }

}