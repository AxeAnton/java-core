package ru.itmo.lessons.lessons20;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ArgsAndProps {
    public static void main(String[] args) {
        // сам метод main вызывается при запуске программы и хранет некий массив строк, если мы при запуски программы эти аргументы передадит то мы их сможем прочесть.
        // Можно передать имя файла, настройки и т,д НО это все будут СТРОКИ, собранные в переменной массива args.

        //зауск программы с аргументами
        // ПКМ - Modify Run Configuration
        // -> Program Argument: перечислить через пробел

        for (String arg : args){ // вывод в строку с файла
            System.out.println(arg);

        }
//Создание папки свойства, хранит парами (ключ. значение) все что передаем это СТРОКИ.
        Properties properties = new Properties(); // объект
        properties.setProperty("key", "знавение");// введение данных
        System.out.println(properties.getProperty("key"));// прочтение значения по ключу.
        //так же можно, очистить, перебрать, заменить и т.д
        properties.clear();

        //Так же в объект properties можно загрузить данные из properties файла в парах!  Загрузка:
        //Вариант 1 - properties.load((InputStream);
        //ТАк же возможен такой вариант загрузчика:
/*        Вариант 2 - try (InputStream inputt = ArgsAndProps.class
            .getClassLoader()
            .getResourceAsStream("lessonse20.properties")) {
            properties.load(inputt); // в load можно так же загрузить данные из properties файла!
            catch (IOException) {
                throw new RuntimeException(e)
            }*/

        // Вариант 3 - properties.forEach((key, value) ->  System.out.println(key + " " + value);


    }
}

//деректория с ресурсами для properties
