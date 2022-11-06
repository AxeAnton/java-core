package ru.itmo.lessons.lessons21.patterns.decorator;

public interface LogStrategy {
    void log(String data);
}

// 1. Все декараторы наследуются от базового декаратора!
// 2. Базовый декоратор и класс с основным функционалом должны имплементировать один и тот же интерфейс.