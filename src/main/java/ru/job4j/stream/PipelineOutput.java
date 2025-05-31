package ru.job4j.stream;

import java.util.stream.Stream;

public class PipelineOutput {
    public static void main(String[] args) {
        Stream.of("one", "two", "three")
                .filter(x -> {
                    System.out.print(x);
                    return x.length() <= 3;
                })
                .map(x -> {
                    System.out.println(x);
                    return x.toUpperCase();
                })
                .sorted()
                .forEach(System.out::println);
    }
}