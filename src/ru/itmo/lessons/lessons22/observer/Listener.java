package ru.itmo.lessons.lessons22.observer;

public interface Listener { // 1. Если нужен интерфейс паттерна НАБЛЮДАТЕЛЬ то организуем данный нтерфейс. РЕАЛИЗОВЫВАТЬ данный класс будут ПОДПИСЧИКИ!
    void tempChanged(int temp); // 2. Реакция подписчиков, tempChanged - методы реакции
}

