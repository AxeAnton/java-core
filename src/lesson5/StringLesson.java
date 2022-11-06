package lesson5;

import java.util.Arrays;

public class StringLesson {
    public static void main(String[] args) {
        // char (примитивный тип данных) 16 битный символ Unicode
        // от 0 до 65536 / '\u0000' до '\uffff'

        char char1 = 'J'; // сам символ
        char char2 = 74; // номер символа J
        char char3 = '\u0044'; // 16ричное представление символа в escape
         // последовательности
        System.out.print(char1); // J
        System.out.print(char2); // J
        System.out.print(char3); // D

        System.out.println("\nСтроки");

        // Строка - упорядоченная последовательность символов
        // Строка - ссылочный тип, экземпляр класса String
        // Строки задаются:
        // 1. в двойных кавычках
        // 2. new String() - используется, если способ создания строки
        // через "" невозможен
        // Строки неизменны, можно лишь создать новую строку на основе
        // существующей
        System.out.println("Строковой литерал");

        char[] chars = {'\u004A', '\u004A', '\u0044'};
        String jjdString = new String(chars);
        System.out.println(jjdString); // JJD
        System.out.println(jjdString.length()); // 3

        char[] chars1 = {'\uD83D', '\uDC38'}; // суррогатная пара чаров
        String frogString = new String(chars1);
        System.out.println(frogString); // 🐸
        System.out.println(frogString.length()); // 2
        System.out.println(frogString.codePoints().count()); // 1

        // Хранение строк до JAVA 9: массив char[] в кодировке UTF-16
        // каждый чар был представлен двумя байтами

        // Начиная с 9 версии строки (компактные строки)
        // хранятся как массив byte[] + кодировка LATIN1 или UTF-16

        // Пул строк хранит только одну копию строкового литерала
        // Пул строк: "Строка" "Строка4" "Строка44"

        // "Строка" (heap память)
        String string1 = "Строка";
        String string2 = "Строка";

        String string3 = new String("Строка");
        // string3 ссылается на "Строка" вне пула

        System.out.println(string1 == string2); // true
        System.out.println(string1 == string3); // false

        String internString = string3.intern();
        // internString ссылается на "Строка" из пула

        string1 = "Строка";
        string2 = "Строка";

        // Сравнение строк equals
        // для сравнения не используем == , тк == сравнивает ссылки

        System.out.println(string1.equals(string2)); // true
        System.out.println("строка".equals(string2)); // false
        System.out.println("строка".equalsIgnoreCase(string2)); // true

        string2 = null;

        System.out.println("строка".equals(string2));
        // System.out.println(string2.equals("строка")); // NullPointerException

        System.out.println(string2 == null); // true
        System.out.println(string2 != null); // false

        string1 = "Java";
        string2 = "Python";

        // конкатенация строк
        String concatString = string1 + " :: " + string2;
        System.out.println(concatString);

        concatString = string1.concat(" :: ").concat(string2);
        // Java ::
        // Java :: Python

        concatString = String.join(" :: ", string1, string2, string3);

        concatString = "";
        for (int i = 0; i < 10; i += 1) {
            concatString += i + " ";
        }
        System.out.println(concatString);

        // StringBuilder - работает быстрее
        // StringBuffer - потокобезопасный

        string1 = "Java";
        string2 = "Python";
        concatString = "Начало строки ";
        StringBuilder sb = new StringBuilder(concatString);
        sb.append(string1).append(" :: ").append(string2);

        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < 10; i += 1) {
            sb2.append(i).append(" ");
        }
        System.out.println(sb2);

        String sbString = sb2.toString();
        System.out.println(sbString);

        // метод split()
        String langs = "Java, Python, JavaScript";
        String[] langArr = langs.split(", ");
        System.out.println(Arrays.toString(langArr));

        // методы замены // Java, Python, JavaScript
        String newString = langs.replaceAll(", ", " - ");
        System.out.println(newString);

        newString = langs.replaceFirst(", ", " - ");
        System.out.println(newString);

        newString = langs.replace(", ", " - ");
        System.out.println(newString);

        System.out.println(langs.contains("th")); // true
        System.out.println(langs.startsWith("java")); // false
        System.out.println(langs.endsWith("Script")); // true

        System.out.println(langs.startsWith("av", 1)); // true















































    }
}
