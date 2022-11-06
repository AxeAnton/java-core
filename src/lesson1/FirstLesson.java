package lesson1;

public class FirstLesson {
    // однострочный комментарий
    /*
        многострочный
        комментарий
    */
    /**
     * документирование кода
     * */

    // psvm в IntelliJ IDEA для генерации метода main (точки входа в приложение)
    public static void main(String[] args) {
        // sout в IntelliJ IDEA для генерации System.out.println
        System.out.println("Информация для вывода в консоль"); // вывод данных в консоль

        // объявление переменных:
        // типДанных имяПеременной
        int size; // объявили переменную size типа int
        size = 56; // переменной size присвоили значение 56

        int count = 71899; // объявили переменную count типа int и присвоили значение 71899
        int length = 122, width = 500; // объявили переменные типа int: length со значением 122 и width со значением 500

        count = 800_000; // числа можно разделять _ для удобства чтения
        System.out.println(count); // вывели значение переменной count в консоль

        // byte data = 327; ошибка, тк превышен допустимый диапазон byte

        // если значение переменной типа long превышает диапазон int, нужно явно указывать на работу с типом long,
        // добавляя L или l в конце, в противном случае будет ошибка: integer number too large
        long veryBig = 67_000_000_000L;

        // деление ЦЕЛЫХ чисел на 0 приводит ошибке: java.lang.ArithmeticException: / by zero,
        // программ прерывает свою работу
        // System.out.println(count / 0);

        double price = 56.7;
        // необходимо явно указывать на работу с типом float, добавляя f или F в конце, в противном случае будет ошибка
        float temp = -78.3f;

        // результат деления чисел c ПЛАВАЮЩЕЙ ТОЧКОЙ на 0:  Infinity или -Infinity
        System.out.println(price / 0);// Infinity
        System.out.println(temp / 0); // -Infinity

        count = 8700; // тип данных - int

        // автоматическое приведение типов (возможно только при совместимых типах и расширении контейнера):
        // 1. значение переменной count приводится к типу double (8700.0)
        // 2. приведенное значение присваивается переменной price
        price = count;
        System.out.println(price);

        // явное приведение типов (возможно только при совместимых типах). Может привести к потере точности при уменьшении контейнера
        // 1. значение переменной count приводится к типу byte с потерей точности (тк 8700 выходит за допустимый диапазон byte)
        // 2. приведенное значение присваивается переменной small
        byte small = (byte) count;
        System.out.println(small);

        // Операторы
        int a = 9, b = 4;
        int c1 = a / b; // результат деления целых цисел - целое число
        System.out.println(c1); // 2
        // НО, если один из операндов привести к double или float,
        // в результате получим тип с плавающей точкой
        double c2 = (double) a / b; // значение переменной 'a' привели к типу double, потом разделили на значение переменной 'b',
        // результат присвоили переменной c2
        System.out.println(c2); // 2.25

        byte x = 6, y = 12;
        // результат сложение byte или short дает тип int
        byte z = (byte) (x + y); // к значению переменной 'x' прибавили значение переменной 'y', результат привели к типу byte,
        // и присвоили переменной 'z'

        // Остаток от деления %
        length = 9;
        width = 8;
        System.out.println(length % width); // 1
        // 4.5  4.5
        // 0.5 + 0.5 = 1

        System.out.println(7 % 4); // 3
        System.out.println(8 % 2); // 0
        System.out.println(9 % 2); // 1

        // Операторы присваивания
        int num = 10;
        num += 10; // num = num + 10;
        num -= 10; // num = num - 10;
        num *= 10; // num = num * 10;
        num /= 10; // num = num / 10;
        num %= 10; // num = num % 10;

        // Операторы сравнения и тернарный оператор:

        // Операторы сравления возвращают результат типа boolean
        System.out.println(a > b); // true
        System.out.println(length == width); // false

        System.out.println(40 <= 40); // true
        System.out.println(400 != 40); // true

        // тернарный оператор ?
        int start = 3, end = 5000;
        // если условие (start > end) истинно (true), то тернарный оператор вернет результат после ?
        // если условие (start > end) ложно (false), то тернарный оператор вернет результат после :
        int res = start > end ? end - start : 0;
        System.out.println(res); // 0

    }
}
