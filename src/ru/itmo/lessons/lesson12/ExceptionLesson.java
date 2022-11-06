package ru.itmo.lessons.lesson12;

import java.io.IOException;

public class ExceptionLesson {
    public static void main(String[] args) {
        // Error - ошибки, связанные с проблемами уровня JVM
        // Например, нехватка памяти
        // Ошибки (все Error) обрабатывать нет смысла

        // Exception - исключения
        // 1. Исключения времени выполнения (наследники RuntimeException)
        // unchecked, необрабатываемые, неотслеживаемые, неконтролируемые
        // разработчики могут (по своему усмотрению) обработать данный
        // тип исключений
        // 2. Исключения времени компиляции (все остальные наследники Exception)
        // checked, обрабатываемые, отслеживаемые, контролируемые
        // разработчики обязаны обработать данный тип исключений

        // RuntimeException
        int a = 1;
        int b = 0;
        int res;
        // res = a / b; java.lang.ArithmeticException

        int[] ints = new int[3];
        // ints[100] = 90; // java.lang.ArrayIndexOutOfBoundsException

        String s = null;
        // s.equals("data"); // java.lang.NullPointerException

        Object obj = "123";
        String s1 = (String) obj;
        System.out.println(s1.toUpperCase());
        // Integer integer = (Integer) obj; // java.lang.ClassCastException


        // обработка исключений (unchecked / checked)
        try { // в блок try помещается потенциально опасный код,
            // который может привести к исключению
            res = a / b; // new ArithmeticException
        } catch (ArithmeticException e){ /* должен присутствовать, может быть несколько
         блоков catch после одного блока try */
            System.out.println(e.getMessage());
            res = a;
        }
        System.out.println(res);

        // Объединение блоков catch
        // 1. несколько блоков catch - позволяет разные исключения обработать
        // разными способами
        Integer integer = null;
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) obj;
            else ints[90] = 100;
        } catch (ClassCastException e){ // перехватит ClassCastException
            // и всех его потомков
            System.out.println("Проблемы с приведением типов " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за пределы массива " + e.getMessage());
        }
        // закончилась первая половина лекции
        // 2. несколько исключений обрабатываются одинаковым способом
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) obj;
            else ints[90] = 100;
        } catch (ClassCastException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Проблема с приведением или " +
                    "выход за пределы массива " + e.getMessage());
        } finally { // необязательный блок finally
            // инструкции выполнятся в случае любого исключения в
            // блоке try
            // инструкции, связанные с закрытием ресурсов
            System.out.println("finally");
        }

        // 3. через общего родителя - несколько исключений обрабатываются одинаковым способом
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) obj;
            else ints[90] = 100;
        } catch (RuntimeException e) { // перехватит всех наследников RuntimeException
            System.out.println("Исключение времени выполнения " + e.getMessage());
        }

        // 4. через общего родителя - несколько исключений обрабатываются
        // одинаковым способом, некоторые из них обрабатываются другим способом
        try {
            if (System.currentTimeMillis() % 2 == 0) integer = (Integer) obj;
            else ints[90] = 100;
        } catch (ClassCastException e) {
            System.out.println("Исключение приведения типов " + e.getMessage());
        } catch (RuntimeException e) { // перехватит всех наследников RuntimeException
            System.out.println("Исключение времени выполнения " + e.getMessage());
        }


        try {
            readFromJsonFile("file.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(random(3, 89));

        Object o = null;
        try {
            o = new Object();
        } catch (RuntimeException e) {
            System.out.println("Проблема времени выполнения");
        }
        o.equals("123");
    }

    public static int random(int a, int b){
        try {
            return Calculate.random(a, b);
        } catch (CalcException e) {
            return 0;
        }
    }

    public static void readFromJsonFile(String fileName) throws IOException {
        if (!fileName.endsWith(".json")) {
            // исключение времени компиляции
            throw new IOException("Проблема с файлом");
        }
        System.out.println("Чтение из json файла");
    }




}

