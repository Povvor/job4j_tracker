package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("povvor@yandex.ru", "Vladimir Osipov");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("geyb-nyuell@bk.ru-", "Geyb Nyuell");
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        for (String key : map.keySet()) {
            String value = map.get(key);
            System.out.println("Email: " + key + " Name: " + value);
        }
    }
}