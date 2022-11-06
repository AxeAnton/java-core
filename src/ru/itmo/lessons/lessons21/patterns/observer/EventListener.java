package ru.itmo.lessons.lessons21.patterns.observer;

// 1. интерфейс, который реализуют слушатели/наблюдатели, вообщем если у них что »«ћ≈Ќ»Ћќ—№.
public interface EventListener {
    void greenEvent(int code); // 2. ћетоды, реакци€ на событие
    void yellowEvent(int code);
    void redEvent(int code);
}
