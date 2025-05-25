package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        String[] list = {"one", "two", "three", "four", "five", "six", "seven"};
        BiConsumer<Integer, String> biConsumer = (first, second) -> map.put(first, second);

        int i = 0;
        for (String word : list) {
            biConsumer.accept(i, word);
        }

        BiPredicate<Integer, String> biPredicate = (first, second) -> {
            return first % 2 == 0 || second.length() == 4;
        };
        for (Integer key : map.keySet()) {

            if (biPredicate.test(key, map.get(key))) {
                System.out.println("key: " + key + " value: " + map.get(key));
            }
        }

        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        List<String> strings = supplier.get();

        Consumer<String> consumer  = (string) -> System.out.println(string);
        Function<String, String> function = (string) -> string.toUpperCase();
        for (String string : strings) {
            consumer.accept(function.apply(string));
        }
    }
}