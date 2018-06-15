package com.learn.language.stream;

import com.learn.language.stream.model.Person;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExample {

    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                CollectorsExample.class.getClassLoader().getResourceAsStream("people.txt")));
        Stream<String> stringStream = reader.lines();

        try {
            stringStream.map(line -> {
                String[] s = line.split(" ");
                Person person = new Person(s[0].trim(), Integer.parseInt(s[1]));
                personList.add(person);
                return person;
            }).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println(e);
        }

        Optional<Person> personOptional =
                personList.stream().filter(person -> person.getAge() > 20).min(Comparator.comparing(Person::getAge));
        System.out.println(personOptional);

        Optional<Person> personOptional1 =
                personList.stream().max(Comparator.comparing(Person::getAge));
        System.out.println(personOptional1);

        Map<Integer, Set<String>> map =
        personList.stream().collect(
                Collectors.groupingBy(
                        Person::getAge,
                        Collectors.mapping(
                                Person::getName,
                                Collectors.toCollection(TreeSet::new)
                        )
                )
        );
        System.out.println(map);
    }

}