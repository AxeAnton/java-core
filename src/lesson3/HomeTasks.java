package lesson3;

import java.util.Scanner;

public class HomeTasks {
    public static void main(String[] args) {


        // Создайте программу, выводящую на экран первые
        // 55 элементов последовательности 1 3 5 7 9 11 13 15 17 ….

        for (int i = 0, num = 1; i < 55; i += 1, num += 2) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Для введённого пользователем с клавиатуры целого
        // положительного числа посчитайте сумму всех его цифр
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите положительное число");
        int number = scanner.nextInt();
        int sum = 0;
        while (number != 0) {
            sum = sum + number % 10;
            number /= 10;
        }
        System.out.println(sum);

        int numProgram = (int) (1 + Math.random() * 9);
        int numUser = 20;
        Scanner in = new Scanner(System.in);
        System.out.println(numProgram);
        while (numUser != 0){
            System.out.println("Угадайте число [1;9] ");
            numUser = in.nextInt(); // 0

            if (numUser == numProgram) {
                System.out.println("Вы угадали");
                break;
            }
            if (numUser > numProgram) {
                System.out.println("Загаданное число меньше");
                continue;
            }
            if (numUser < numProgram){
                System.out.println("Загаданное число больше");
            }
        }

        int randomNumber = 1 + (int) (Math.random() * 8);
        //Scanner in = new Scanner(System.in);
        System.out.println("Введите целое число");
        int userNum = in.nextInt();
        while (userNum != randomNumber) {
            System.out.println("Введите целое число");
            userNum = in.nextInt();
            if (userNum == 0) {
                System.out.println("Выход из программы");
                break;
            }
            if (userNum > randomNumber) {
                System.out.println("Загаданное число больше");
            } else {
                System.out.println("Загаданное число меньше");
            }
            if (userNum == randomNumber) {
                System.out.println("Вы угадали");
                break;
            }

        }

        int a=1,b=9;
        int c = a + (int) (Math.random() * b);
        System.out.println(c);
        Scanner s = new Scanner(System.in);
        while (true){
            int x = s.nextInt();
            if (x==0) {
                System.out.println("Выход");
                break;
            }
            if (x==c) {
                System.out.println("Угадал");
                break;
            }
            else if (x<c) System.out.println("Число больше");
            else System.out.println("Число меньше");
        }

       /*  Пользователь загадывает число в диапазоне от [2 до 100]
           Программа пытается его угадать (используйте метод бинарного поиска - деление отрезка на 2).
           Программа может задавать пользователю вопросы:
           Число равно ...? / Число больше ...? / Число меньше ...? и в зависимоти от ответа пользователя принимать решения.
           Вместо текстовых ответов ДА/НЕТ, используйте числа 0 - НЕТ и 1 - ДА
       */

        int start = 2;
        int end = 100;
        int middle;

        while (true) {
            middle = (start + end) / 2;
            System.out.println("Это число равно " + middle + "?");
            int answer = scanner.nextInt();
            if (answer == 1) break;
            System.out.println("Это число больше " + middle + "?");
            answer = scanner.nextInt();
            if (answer == 1) start = middle;
            else if (answer == 0) end = middle;
        }



        int age = 22;
        if (age > 18) {
            int code = 123;
            System.out.println("Вам " + age);
            System.out.println("Доступ разрешен. Ваш код " + code);
        }
        // System.out.println(code);

        for (int i = 0; i < 5; i++) {
            int res = i;
            System.out.println(res);
        }
        for (int i = 0; i < 5; i++) {
            int res = i;
            System.out.println(res);
        }
        int res = 56;
        System.out.println(res);



    }
}
