package ru.itmo.lessons.lesson16;

import java.util.function.Function;
import java.util.function.Predicate;

public class Lambda {
    //FIXME 2.  В данном методе необходимо указать в аргументе ТД operation и имя
    // переменной some (оно будет или sum или div при реализации)
    // + остальные аргумениты.
    private static void run(Operation some, double x, double y){
        double res = some.execute(x, y);
        //FIXME, теперь у переменной some вызываем метод execute
        // и все это присваеваем res, идем стр.49 ниже.
        System.out.println("Результат: " + res);
    }

    public static void main(String[] args) {
        // TODO:: объявить интерфейс Operation с одним
        //  абстрактным методом execute,
        //  который принимает на вход два числа с плавающей точкой и
        //  возвращает число с плавающей точкой

//        public interface Operation {
//            /* public */ double execute(double a, double b);
//        }

        // TODO:: написать несколько реализаций абстрактного метода
        // если метод принимает на вход 1 аргумент, круглые скобки
        // можно не ставить
        // тип данных можно не указывать, они берутся из контекста,
        // из интерфейса
        // если тело метода состоит из одной инструкции, { }
        // можно не ставить
        // FIXME 1. Operation - это ТД (взятый из функционального интерфейса)
        //  количество аргументов (first, second)  = количеству аргументов в интерфейсе.
        Operation plus = (first, second) ->
                    /* return - подразумевается но не пишется*/ first + second;
        Operation div = (first, second) -> {
            if (second == 0) return 0;
            return first / second; /* return - пишится так как нет фигурных скобок*/
        };
        //FIXME что еще интерестно, т.к pluse и div фактически являются ОБЪЕКТАМИ,
        // то их можно передать в отдельный метод, далее сточка 7 выше - private static void run.
        System.out.println(plus);
        System.out.println(plus.execute(34, 78));
            // plus.execute(34, 78) - реализация метода, тоесть и задаем здесь и реалезуем метод, ТД писать не надо.
        System.out.println(div.execute(45, 0));
        System.out.println(div.execute(45, 1));
//FIXME 3.
        run(plus, 5.7, 5.2);
        run(div, 5.7, 5.2);


        // Predicate - ФУНКЦИОНАЛЬНЫЙ интерфейс, стандартный.
        // TODO:: написать реализации метода test:
        //  - проверка на положительное число
        //  - проверка на отрицательное число
        //  - проверка на четное число
        // Predicate - реализачия - boolean test(T t);
        Predicate<Integer> isPos = x -> x > 0;
        Predicate<Integer> isNeg = x -> x < 0;
        Predicate<Integer> isEven = x -> x % 2 == 0;

        System.out.println(isPos.test(-67)); // false FIXME test - булевый метод в Predicate,
        //FIXME не понял для чего нужен, вроде просто для проверки, так же есть еще несколько (end_negate_negate_not и or)
        System.out.println(isEven.test(34)); // true

        System.out.println(isPos.and(isEven).test(68)); // &&
        //FIXME - метод end позволяет объеденить методы проверки,
        // в данном случаи проверка и на положительность и на четность.
        System.out.println(isNeg.or(isPos).test(0)); // ||
        //FIXME - метод or позволяет получить ТРУ если ТРУ один или второй метод.

        // Function<T, R> - ФУНКЦИОНАЛЬНЫЙ интерфейс, стандартный.
        //FIXME тип Т - принимает на вход. Тип R - возвращает
        // R apply(T t); - apply - существует
        // TODO:: написать реализации метода apply:
        //  - уменьшение целого числа на 20%
        //  - увеличение целого числа в два раза
        //  - добавление к положительному числу символов " p."
        Function<Integer, Double> minus20 = x -> x * 0.8;
        Function<Integer, Integer> doubled = x -> x * 2;
        Function<Integer, String> str = x -> x + " p.";
        System.out.println(doubled.andThen(str).apply(45));
        // apply (45), это то как выводится строчка 76.
        //FIXME метод andThen используется для объеденения данных
    }
}