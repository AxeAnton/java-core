package ru.itmo.lessons.lessons21.patterns.singleton;

public class Application {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.getInstance(); // 38. у первой переменной будет ссылка на один объект, а все другие переменные, так же будут ссылаться на один объект, используется в генеральных настройках.

        Singleton singleton2 = Singleton.getInstance();
    }

}