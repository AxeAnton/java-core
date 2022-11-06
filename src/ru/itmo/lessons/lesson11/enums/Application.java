package ru.itmo.lessons.lesson11.enums;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        Article article1 = new Article("Путешествие по Австралии");
        article1.setCountry(Country.AUSTRALIA);
        System.out.println(article1.getCountry()); // AUSTRALIA

        Article article2 = new Article("Путешествие по Британии");
        article2.setCountry(Country.UK);
        System.out.println(article2.getCountry()); // UK

        // методы перечислений
        // получение массива констант
        Country[] countries = Country.values();
        System.out.println(Arrays.toString(countries));
        // [AUSTRALIA, UK, FRANCE]
        // индекс элемента перечисления в массиве
        System.out.println(Country.FRANCE.ordinal()); // 2

        for (Country country : countries) {
            System.out.println("country " + country.name());
        }

        // IllegalArgumentException, если элемент не будет найден
        Country country = Country.valueOf("UK"); // UK
        System.out.println(country); // UK

        Priority low = Priority.LOW;
        System.out.println(low.getCode()); // 1

        low.setCode(2);
        System.out.println(low.getCode()); // 2

        Priority[] priorities = Priority.values();
        for (Priority value : priorities) {
            System.out.println(value.getCode());
        }

        // по умолчанию name() и toString()
        // возвращают одно значение, НО
        // name() переопределить нельзя (он final)
        // toString() переопределить можно
        System.out.println(Priority.LOW.name());
        System.out.println(Priority.LOW.toString());

        int sumRes = Operation.SUM.action(2, 3);
        System.out.println(sumRes);

        int multiRes = Operation.MULTI.action(2, 3);
        System.out.println(multiRes);

//        Operation.SUM.some();

        // создать enum, перечисляющий 3 любые планеты солнечной системы
        // в методе main перебрать массив с элементами
        // перечисления, вывести массу, радиус и название
        // каждой планеты
        // значения всех свойств изначально задаются через конструктор
        // должна быть возможность изменить массу и радиус планет


    }
}
