package ru.job4j.oop;

public class Error {

    private boolean active;
    private int status;
    private String massage;

    public Error() {
    }

    public Error(boolean active, int status, String massage) {
        this.active = active;
        this.status = status;
        this.massage = massage;
    }

    public void printInfo() {
        System.out.println("Ошибка активна: " + active);
        System.out.println("Код ошибки: " + status);
        System.out.println("Сообщение пользователю: " + massage);
        System.out.println();
    }

    public static void main(String[] args) {
        Error error0 = new Error();
        Error error401 = new Error(true, 401, "Требуется авторизация");
        Error error403 = new Error(true, 403, "Доступ запрещен");
        Error error404 = new Error(true, 404, "Ресурс не найден");
        error0.printInfo();
        error404.printInfo();
        error401.printInfo();
        error403.printInfo();
    }

}
