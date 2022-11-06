package ru.itmo.lessons.lessons17;

import ru.itmo.lessons.lesson16.education.Course;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {
    public static void main(String[] args) {
        // FIXME NB Создание потока

        // 1: Создать поток целых чисел (-560, 312, 12, -1, 45, 0, 0, 23, -2, 221)

        //  FIXME NB "filter" - оставить в потоке только отрицательные элементы. В методе filter,
        //   реализован метод test, следовательно мы в аргументе должны его реализовать -
        //   передать один аргумент (num -> num < 0), т.к он возвращает True или False

        //  FIXME NB "limit", поможет выбрать 5 первых элементов

        //  FIXME NB "map" возвести каждый элемент в квадрат

        //  FIXME NB  "forEach" вывести каждый элемент в консоль

        Stream<Integer> integerStream =
                Stream.of(-560, 312, 12, -1, 45, 0, 0, 23, -2, 221);
        integerStream.filter(num -> num < 0)
                .limit(5)
                .map(num -> num * num)
                .forEach(System.out::println);
        //.forEach(elem -> System.out.println(elem));

        // TODO 2: Создать поток целых чисел (-6, 45, 12, -77, 77, 45, 6, -6, 0, 0, 12)

        // FIXME NB "distinct" оставить в потоке только уникальные элементы

        //  FIXME NB "sorted" отсортировать в натуральном порядке (по возрастанию)

        //  - вывести каждый элемент в консоль
        integerStream =
                Stream.of(-6, 45, 12, -77, 77, 45, 6, -6, 0, 0, 12);
        integerStream.distinct()
                .sorted()
                .forEach(System.out::println);


        // TODO 3:
        //  FIXME NB "anyMatch, allMatch, noneMatch"
        //   "anyMatch" каккой либо из элементов потока удовлетворяет условию, затем не проверяет
        //   "allMatch" все элементы потока удовлетворяет условию
        //   "noneMatch" не один элемент потока НЕ удовлетворяет условию
        //   Они все возаращают true или false принимают на вход метод test.

        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, есть ли в потеке элемент со значением 0
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, состоит ли поток из только положительных элементов
        //  - создать поток целых чисел (411, 7, 90, -1000, 0, 2, 71) и
        //    проверить, что в потоке нет значений больше 10_000
        integerStream = Stream.of(411, 7, 90, -1000, 0, 2, 0, 71, 0);
        System.out.println(integerStream.anyMatch(num -> num == 0));

        integerStream = Stream.of(411, 7, 90, -1000, 0, 2, 0, 71, 0);
        System.out.println(integerStream.allMatch(num -> num > 0));

        integerStream = Stream.of(411, 7, 90, -1000, 0, 2, 0, 71, 0);
        System.out.println(integerStream.noneMatch(num -> num > 10_000));


        String[] colors = {"white", "black", "red", "yellow", "yellowgreen"};
        // TODO 4:
        //  FIXME NB "findFirst" и "findAny"
        //   findFirst - взять первый | findAny - взять произвольный
        //   важно, что они возвращают (содержит) Экземпляр типа Optional<T> -
        //   null safe container (контейнер обезапасывающий разработчика от Null),
        //   если добавить точку то откроется много методов, что можно сделать с данным значением
        //   например вытащить через "get" или получить True - если в контейнере НЕ NuLL метод "isPresent", если False то в контейнере нет элементов).
        //   FIXME NB матернинский методы "get: и "isPresent"
        //    String color = Stream.of(colors) - В потоке один элемент и он массив.
        //    String color = Arrays.stream(colors) - В потоке каждый элемент массива это элемент потока

        // Optional<T> - null safe container
        String color = Arrays.stream(colors).findFirst().get();
        color = Arrays.stream(colors).findAny().orElse("yellow");
        boolean isPresent = Arrays.stream(colors).findFirst().isPresent();


        // TODO 5: Создать поток из элементов массива colors

        // FIXME NB ".skip" используется для пропуска 2 первых элементов

        // FIXME NB ".startsWith" начинается с,
        //  например - оставить в потоке только цвета, начинающиеся на 'y'

        //  - вывести каждый элемент в консоль
        Arrays.stream(colors)
                .skip(2)
                .filter(elem -> elem.startsWith("y"))
                .forEach(System.out::println);

        ArrayList<Course> courses = new ArrayList<>();
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());
        courses.add(Course.getInstance());

        // FIXME NB "имя списка.stream()" Поток из элементов списка

        // TODO 6: Создать поток из элементов списка course
        //  и выбрать минимальный по стоимости курс,

        // FIXME NB "orElse" - выводит полученное значение
        //  (например предыдущим методом) или то, что зададим в аргумент
        //  вывести курс в консоль

        Course minByPrice = courses.stream()
                .min((c1, c2) -> (int) (c1.getPrice() - c2.getPrice())) // 1й вариант реализации компаратора - int compare(T o1, T o2);
                .orElse(Course.getInstance());
        System.out.println(minByPrice);

        // TODO 7: Создать поток из элементов списка course
        //  и выбрать максимальный по продолжительности курс,
        //  вывести курс в консоль
        Course maxByDuration = courses.stream()
                .max(Comparator.comparing(Course::getDuration)) // 2й вариант реализации компаратора -int compare(T o1, T o2); ссылка на сравнивание getDuration
                .orElse(Course.getInstance());
        System.out.println(maxByDuration);

        // FIXME NB Из ПОТОКА получить МАССИВ - ".toArray(Course[]::new/.toArray(); Object[]"
        // TODO 7: на основе списка курсов получить
        //  массив курсов дороже 20000
        //  В итоге должен получиться массив Course[]
        Course[] coursesArr = courses.stream()
                .filter(course -> course.getPrice() > 20000)
                .toArray(Course[]::new); // если необходим определенный ТД в массиве, помещаем в аргумент ссылку на конструктор массива Course[]
        // .toArray(); Object[]- при использовании данной инструкции ТД будут Object, а нам нужен Course



        // TODO 8: увеличить стоимость
        //  каждого курса с продолжительностью более
        //  3х месяцев на 5000 (из списка course)
        //  В итоге должен получиться List<Course>
        //  map(function) - peek(consumer)

        // FIXME NB "peek" изменяет элементы потока (возврат ТД String),
        //  данный метод изменяет текущие элементы и не создает новый объект!

        // FIXME NB "map" изменяет элементы потока,
        //  данный метод СОЗДАЕТ новый объект и потом текущемму объекту передается значения нового! То есть в аргументе необхожимо создать new Объект.

        List<Course> courseList = courses.stream()
                .filter(course -> course.getDuration() > 3)
                .peek(course -> course.setPrice(course.getPrice() + 5000))
        // FIXME NB Из ПОТОКА получить Список (List)  - collect(Collectors.toList())
                .collect(Collectors.toList()); // List<Course>
        // множество Set:
        // FIXME NB Из ПОТОКА получить множество (Set)
        // .collect(Collectors.toSet()); // Set<Course>
        // конкретная коллекция:
        // FIXME NB Из ПОТОКА получить Конкретную КОЛЕКЦИЮ
        //  (имя колекции в аргумент пишем)
        // .collect(Collectors.toCollection(ArrayList::new));

        // FIXME NB Из ПОТОКА в МАПУ  - .collect(Collectors.toMap(
        //  дальше смотри пример ниже срт 177-180

        colors = new String[]{"blue", "orange", "brown", "white"};
        // TODO 11:  на основе массива colors создать
        //  мапу Map<String, Integer>,
        //  где ключи - элементы массива,
        //  значения - размер элемента массива
        Map<String, Integer> map = Arrays.stream(colors)
                .collect(Collectors.toMap(
                        // elem -> elem // ключ можно так
                        Function.identity(), // ключи
                        elem -> elem.length(), // значения
                        (elem1, elem2) -> elem1 // как формировать значения,
                        // если ключи одиноковые
                ));
        System.out.println(map);


        // FIXME NB 2х мерная МАПА в СТРИМЕ


                String[][] strings = {
                {"45", "78", "-90", "0", "1", "1"},
                {"441", "14", "14", "28"},
                {"122", "-6", "10", "50"},
        };
        // map - flatMap
        // TODO 12: В каждом вложенном массиве оставить
        //  только уникальные элементы,
        //  отсортировать каждый вложенный массив.
        //  В итоге должен получиться массив String[][]
        // {"45", "78", "-90", "0", "1", "1"}
        // {"441", "14", "14", "28"},
        // {"122", "-6", "10", "50"}
        // FIXME NB метод map работает как ЦИКЛ!
        String[][] strings1 = Arrays.stream(strings) // помещаем 2х мерный массив в поток
                .map(elem -> Arrays.stream(elem)// т.к элемент (elem) первого массива это под массив, то помещаем и его в стрим
                        .distinct() // оставляем уникальные
                        .sorted() // сортируем
                        .toArray(String[]::new)) // из потока снова собираем массив подмассивов
                .toArray(String[][]::new); // все под массивы запихиваем в массив внешний
        System.out.println(Arrays.deepToString(strings1));

        // FIXME NB ".flatMap" из 2х мерной МАПЫ создать СТРИМЕ

        // TODO 13: На основе массива strings создать
        //  одномерный массив уникальных элементов,
        //  массив отсортировать.
        //  В итоге должен получиться массив String[]
        String[] strings2 = Arrays.stream(strings)
                .flatMap(elem -> Arrays.stream(elem) // .flatMap- фактически перебрал эллементы (подмассивы)
                        .distinct()
                        .sorted())
                .toArray(String[]::new); // и засунул их всех в ОДИН массив.
        System.out.println(Arrays.toString(strings2));
    }
}
