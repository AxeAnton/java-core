package ru.itmo.lessons.lesson13.methods;

public class UtilsApp {
    public static void main(String[] args) {
        String[] strings = {"qwe", "asd", "zxc"};
        String string = "qwe";
        System.out.println(CustomUtils.inArray(strings, string));
        /* public static <T> boolean inArray() */
        System.out.println(CustomUtils.<String>inArray(strings, string));
        // System.out.println(CustomUtils.<String>inArray(strings, 1));

        Integer[] integers = {2, 4, 6};
        Integer integer = 34;
        System.out.println(CustomUtils.<Integer>inArray(integers, integer));

        System.out.println(CustomUtils.compareHashCode(12, "12"));
        System.out.println(CustomUtils.<Integer, String>compareHashCode(12, "12"));


    }
}