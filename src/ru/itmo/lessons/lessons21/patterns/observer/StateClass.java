package ru.itmo.lessons.lessons21.patterns.observer;

import java.util.ArrayList;

public class StateClass { // 3. за которы будут следить подписчики.
    // 4. класса есть коллекция слушателей/наблюдателей
    private ArrayList<EventListener> eventListeners = new ArrayList<>();
    public void addListener(EventListener eventListener) { // 4. метод добавления в коллекцию, то есть если слушатель хочет подписаться на опровещение/рассылку
        eventListeners.add(eventListener);
    }
    public void removeListener(EventListener eventListener) { // 5. для удаления из рассылки
        eventListeners.remove(eventListener);
    }
    private void lowNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.greenEvent(code));
    }
    private void mediumNotify(int code) {
        eventListeners.forEach(someInterface -> someInterface.yellowEvent(code));
    }
    private void highNotify(int code) { // 7. ОН может пройти по коллекции подписчиков entListeners и вызвать у него один или несколько методов redEvent, аналогично и двух методов вышеye llowEvent greenEvent
        eventListeners.forEach(someInterface -> someInterface.redEvent(code));
    }
    public void changeState(String newValue) { //6. допустим с объектом данного типа changeState, точ то происходит,
        if ("ok".equals(newValue)) lowNotify(1);
        if ("warn".equals(newValue)) mediumNotify(5);
        if ("error".equals(newValue)) highNotify(10);
    }
}
