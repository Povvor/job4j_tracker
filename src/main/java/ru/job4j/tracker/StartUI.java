package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            System.out.print("Выбрать: ");
            int select = Integer.parseInt(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Создание новой заявки ===");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
                System.out.println();

            } else if (select == 1) {
                System.out.println("=== Вывод всех заявок ===");
                Item[] items = tracker.findAll();
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок ");
                }
                System.out.println();

            } else if (select == 2) {
                System.out.println("=== Редактирование заявки ===");
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("Заявка изменена успешно.");
                } else {
                    System.out.println("Ошибка изменения заявки");
                }
                System.out.println();

            } else if (select == 3) {
                System.out.println("=== Удаление заявки ===");
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                tracker.delete(id);
                System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
                System.out.println();

            } else if (select == 4) {
                System.out.println("=== Отображение заявки по id ===");
                System.out.print("Введите id: ");
                int id = Integer.parseInt(scanner.nextLine());
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Заявка с введенным id: " + id + " не найдена.");
                }
                System.out.println();

            } else if (select == 5) {
                System.out.println("=== Отображение заявок по имени ===");
                System.out.print("Введите имя: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                if (items.length > 0) {
                    for (Item item : items) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Заявки с именем: " + name + " не найдены.");
                }
                System.out.println();

            } else if (select == 6) {
                run = false;

            } else {
                System.out.println("Ошибка при выборе пункта в меню");
                System.out.println();

            }
        }
    }

        private void showMenu() {
            String[] menu = {
                    "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                    "Удалить заявку", "Показать заявку по id", "Показать заявки по имени",
                    "Завершить программу"
            };
            System.out.println("Меню:");
            for (int i = 0; i < menu.length; i++) {
                System.out.println(i + "." + menu[i]);
            }
            System.out.println();
        }

        public static void main(String[]args) {
            Scanner scanner = new Scanner(System.in);
            Tracker tracker = new Tracker();
            new StartUI().init(scanner, tracker);
        }
    }
