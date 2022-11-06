package ru.itmo.lessons.lessons21.patterns.decorator;

public class ConsoleLogging implements LogStrategy {
    @Override
    public void log(String data) {
        System.out.println(data);
    }
}
