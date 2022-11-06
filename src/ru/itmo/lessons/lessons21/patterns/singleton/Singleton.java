package ru.itmo.lessons.lessons21.patterns.singleton;

//  ленива€ (отложенна€) инициализаци€
public class Singleton { // 34. Singleton на всю программу один, оаботает так -
    // все необходимые методы и свойства

    private static Singleton instance; /* new Singleton()*/ // 36. создаем статитеское свойство instance, возвращает ссылку на экземпл€р данного класса

    // 35. закрываем возможность создани€ объекта вне класса через “ƒ private, нельз€ вызвать вне класса конструктор
    private Singleton() {}

    public static Singleton getInstance(){ // 37. создаем статический метод, так же на экземпл€р данного класса, далее смотриа ‘зздшсфешщт
        if (instance == null) { // проверка был ли создан объект
            // создание объекта (если он не был создан ранее)
            instance = new Singleton();
        }
        return instance;
    }
}
