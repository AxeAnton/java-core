package ru.itmo.lessons.lesson13.methods;

import ru.itmo.lessons.lesson7.King;

public class CustomUtils {

    // типизированные методы (generic methods)
    // метод, который проверяет наличие элемента массиве
    public static <T> boolean inArray(T[] arr, T element){
        if (arr == null || element == null) {
            throw new IllegalArgumentException("arr и element" +
                    "не могут быть null");
        }
        for (T t : arr) {
            if (element.equals(t)) return true;
        }
        return false;
    }
    /* <T, K, S, P> */
    // System.out.println(CustomUtils.<Integer, String>compareHashCode(12, "12"));
    public static <T extends Number, K extends String>
    int compareHashCode(T first, K second){
        // у first можно вызвать методы Number и его родителей
        // у second можно вызвать методы String и его родителей
        return Integer.compare(first.hashCode(), second.hashCode());
    }


}
