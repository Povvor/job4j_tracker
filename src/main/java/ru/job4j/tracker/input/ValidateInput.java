package ru.job4j.tracker.input;


import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        Output output = new ConsoleOutput();
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                output.println("Пожалуйста, введите корректные данные");
            }
        } while (invalid);
        return value;
    }
}