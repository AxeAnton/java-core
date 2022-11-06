package ru.itmo.lessons.lessons22.observer;

import java.util.HashSet;
import java.util.Set;

public class Sensor { // 3. Слушатели
    private Set<Listener> listeners = new HashSet<>(); //4. Список слушатилей.
    private int temp;

    public void addListener(Listener listener) { // 5. добавить слушателя.
        listeners.add(listener);
    }

    public void removeListener(Listener listener) { // 6. удалить слушателя.
        listeners.remove(listener);
    }

    private void notifyListeners(int temp){
        listeners.forEach(listener -> listener.tempChanged(temp));
        // 8. температура изменилась, обходим подписчиков listeners и вызываем их метод реакции - tempChanged(temp).
    }   // 9. Важно, что сенсор заставляет подписчиков отреагировать на его измменение, а не наоборот

    public void changeState(){ // 7. дачик и изменение температуры, делаем рандомно.
        if (Math.random() < 0.5) temp -= 40;
        else temp += 40;
        System.out.println(temp);
        notifyListeners(temp);
    }
}
