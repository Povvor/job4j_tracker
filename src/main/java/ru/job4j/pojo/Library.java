package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book fantasy = new Book("Ведьмак", 252);
        Book scienceFiction = new Book("Марсианин", 354);
        Book detective = new Book("Шерлок Холмс", 122);
        Book cleanCode = new Book("Clean code", 200);
        Book[] books = new Book[4];
        books[0] = fantasy;
        books[1] = scienceFiction;
        books[2] = detective;
        books[3] = cleanCode;

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Книга: " + book.getName() + ". Количесвто страниц: " + book.getPages());
        }

        Book j = books[0];
        books[0] = books[3];
        books[3] = j;
        System.out.println("Поменяли 3 и 0 элементы:");

        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            System.out.println("Книга: " + book.getName() + ". Количесвто страниц: " + book.getPages());
        }

        System.out.println("Вывод книг с именем \"Clean code\".");
        for (int index = 0; index < books.length; index++) {
            Book book = books[index];
            String target = "Clean code";
            if (book.getName().equals(target)) {
                System.out.println(("Книга: " + book.getName() + ". Количесвто страниц: " + book.getPages()));
            }
        }
    }
}
