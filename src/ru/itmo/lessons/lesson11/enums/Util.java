package ru.itmo.lessons.lesson11.enums;

public class Util {
    public  static int max;
    public  static int min;
    public final static double PI;

    // статический блок, инструкции исполняются один раз при загруске класса.
    static {
        PI = 3.14;
    }
    public  static int random(int min, int max) {
        return (int) (min + Math.random()*(max-min));
    }


}
