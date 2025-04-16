package ru.job4j.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = Integer.parseInt(input.askStr("Выбрать: "));
            if (select == 0) {
                createItem(input, tracker);
            } else if (select == 1) {
                showItems(tracker);
            } else if (select == 2) {
                findItem(input, tracker);
            } else if (select == 3) {
                deleteItem(input, tracker);
            } else if (select == 4) {
                findID(input, tracker);
            } else if (select == 5) {
                findByName(input, tracker);
            } else if (select == 6) {
                run = false;
            } else {
                System.out.println("Ошибка при выборе пункта в меню");
                System.out.println();
            }
        }
    }

    public static void showItems(Tracker tracker) {
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
    }

    public static void findByName(Input input, Tracker tracker) {
        System.out.println("=== Отображение заявок по имени ===");
        String name = input.askStr("Введите имя: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Заявки с именем: " + name + " не найдены.");
        }
        System.out.println();
    }

    public static void findID(Input input, Tracker tracker) {
        System.out.println("=== Отображение заявки по id ===");
        int id = Integer.parseInt(input.askStr("Введите id: "));
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Заявка с введенным id: " + id + " не найдена.");
        }
        System.out.println();
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Удаление заявки ===");
        int id = Integer.parseInt(input.askStr("Введите id: "));
        Item item = tracker.findById(id);
        tracker.delete(id);
        System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");
        System.out.println();
    }

    public static void findItem(Input input, Tracker tracker) {
        System.out.println("=== Редактирование заявки ===");
        int id = Integer.parseInt(input.askStr("Введите id: "));
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("Заявка изменена успешно.");
        } else {
            System.out.println("Ошибка изменения заявки");
        }
        System.out.println();
    }

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Создание новой заявки ===");
        String name = input.askStr("Введите имя: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Добавленная заявка: " + item);
        System.out.println();
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

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
