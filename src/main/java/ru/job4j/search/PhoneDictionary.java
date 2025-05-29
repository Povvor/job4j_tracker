package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> checkName = (name) -> key.equals(name.getName());
        Predicate<Person> checkSurname = (name) -> key.equals(name.getSurname());
        Predicate<Person> checkPhone = (name) -> key.equals(name.getPhone());
        Predicate<Person> checkAddress = (name) -> key.equals(name.getAddress());
        Predicate<Person> combine = checkName.or(checkSurname).or(checkAddress).or(checkPhone);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}