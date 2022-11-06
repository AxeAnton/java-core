package lesson5;

import java.util.Arrays;
import java.util.Scanner;

public class HomeTask {
    public static void main(String[] args) {
        String name = "Иван";
        String surname = "Петров";
        String fullName1 = name + " " + surname;
        String fullName2 = "Иван" + " " + "Петров";
        System.out.println(fullName1);
        System.out.println(fullName2);

        int a = 10;
        int b = 12;
        int c1 = a + b;
        int c2 = 10 + 12;


        // массив уникальных слов
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите размер массива");
        int arrSize = scanner.nextInt();
        scanner.nextLine();

        String[] words = new String[arrSize];
// 3    [null, null, null]
        for (int i = 0; i < words.length; i += 1) {
            System.out.println("Введите слово");
            String word = scanner.nextLine();
            /* words[i] = word; */
            if ("exit".equals(word)) break;
            for (String fromArr: words) { // [null, null, null]
                if (word.equalsIgnoreCase(fromArr)) {
                    System.out.println("Такое слово уже есть");
                    i -= 1;
                    break;
                }
                if (fromArr == null) words[i] = word;
            }

        }
        System.out.println(Arrays.toString(words));

        // найти самое длинное слово в предложении
        String sentence = "в предложении все слова разной длины";
        String longestWord = "";
        String[] wordsArr = sentence.split(" ");

        for (String word : wordsArr) {
            if (word.length() > longestWord.length()) longestWord = word;
        }
        System.out.println("самое длинное слово в предложении "
                + longestWord);

        // первая буква в верхнем регисте, остальные в нижнем
        String word = "hELlO";
        String result = word.substring(0, 1).toUpperCase()
                      + word.substring(1).toLowerCase();
        System.out.println(result); // Hello

        // палиндром
        String string1 = "А роза упала на лапу Азора";
        string1 = string1.replaceAll(" ", "");
        StringBuilder reverseString = new StringBuilder(string1).reverse();
        System.out.println("reverseString " + reverseString);
        if (string1.equalsIgnoreCase(reverseString.toString())) {
            System.out.println(string1 + " - полиндром");
        } else {
            System.out.println(string1 + " - не полиндром");
        }
    }


}
