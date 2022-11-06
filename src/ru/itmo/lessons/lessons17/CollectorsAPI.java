package ru.itmo.lessons.lessons17;

import ru.itmo.lessons.lesson16.education.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsAPI {
    public static void main(String[] args) {
        ArrayList<Course> courses = new ArrayList<>(Course.getInstances(20));
        // Создаем список на 20 элементов.
        // TODO 1: Создать мапу,
        //  где ключи - названия курсов,
        //  значения - списки курсов с указанным в ключе названием

        // FIXME NB Метод "Collectors.groupingBy"
        // работа его описана ниже строка 21
        Map<String, List<Course>> map1 = courses.stream() // Здесь интерстно, что ЗНАЧЕНИЕ это Список курс с указанным названием
                .collect(Collectors.groupingBy(Course::getName)); // Этот метод создает МАПУ, где ключи(аргумент), а значения автоматически становятся сгруппированными списками (c NL List).


        // FIXME NB Метод toCollection
        // если необходимо, что бы в значении был не List, а что то другое, то необходимо вторым аргументом прописоть метод toCollection, а в аргументе указать необходитый тип списка. строчка 33
        // TODO 2: Создать мапу,
        //  где ключи - продолжительность курсов,
        //  значения - списки курсов с указанной
        //  в ключе продолжительностью
        Map<Integer, ArrayList<Course>> map2 = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getDuration,
                        Collectors.toCollection(ArrayList::new)));


        // FIXME NB Метод Collectors.counting
        // необходим, что бы при повторе ключа ЗНАЧЕНИЕ увеличилось на 1 ед. строчка 44

        // TODO 3: Создать мапу, где ключи - названия курсов,
        //  значения - количество курсов с указанным в ключе названием
        Map<String, Long> map3 = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getName,
                        Collectors.counting()));


        // FIXME NB Метод averagingDouble
        // необходим, что бы при повторе ключа ЗНАЧЕНИЕ увеличилось на среднее количество (указываем в аргументе, чье среднее зачение необходимо получить)строчка 57


        // TODO 3: Создать мапу, где ключи - названия курсов,
        //  значения - средняя стоимость курсов
        //  с указанным в ключе названием
        Map<String, Double> map4 = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getName,
                        Collectors.averagingDouble(Course::getPrice)
                ));

        // FIXME NB Метод groupingBy
        // строка 70 формирует ЗНАЧЕНИЕ автоматом с ТД List, а аргумент продолжительность. Если необходимо другой ТД то в аргументе необходимо добавить.

        // TODO 4: Создать мапу, где ключи - названия курсов,
        //  значения - мапа,
        //  в которой  ключи - продолжительность курса,
        //  а значения - списки курсов с указанной в ключе продолжительностью
        Map<String, Map<Integer, List<Course>>> map5 = courses.stream()
                .collect(Collectors.groupingBy(
                        Course::getName,
                        Collectors.groupingBy(Course::getDuration)
                ));

    }
}