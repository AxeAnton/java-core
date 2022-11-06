package lesson4;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysLesson {
    public static void main(String[] args) {
        // примитивные типы данных
        // ссылочные типы данных
        /*
        int a = 78; // [100] a
        int b = a;  // [78] b
        a = 100;

        Scanner scanner = new Scanner(System.in); // in [scanner] scanner
        Scanner in = scanner;
        */
        int[] ints1 /* int ints2[] */ = new int[7]; // массив на 7 элементов
        System.out.println(ints1);
        System.out.println(Arrays.toString(ints1));

        int[] ints2 = {6, -90, 56, 12, 0, -44}; // 6
        System.out.println(Arrays.toString(ints2));

        ints2 = new int[3];  // [000]
        System.out.println(Arrays.toString(ints2));

        // ints2 = {34, 78, 12};
        ints2 = new int[]{34, 78, 12, 78, 90};
        System.out.println(Arrays.toString(ints2));

        // длина массива - положительное значение типа int
        int len = 10;
        int[] ints3 = new int[len];
        int[] ints4 = new int[len + 2]; // 12
        System.out.println(Arrays.toString(ints4));

        System.out.println(ints4.length); // 12

        // доступ к элементам массива
        System.out.println(ints4[3]); // 0
        ints4[2] = 56;
        System.out.println(Arrays.toString(ints4));

        // ArrayIndexOutOfBoundsException
        // System.out.println(ints4[100]);

        // многомерный массив
        // [ [0,0,0,0], [0,0,0,0], [0,0,0,0] ]
        int[][] ints5 = new int[3][4];
        // вывод многомерного массива в консоль
        System.out.println(Arrays.deepToString(ints5));

        // [ [0, 0], [0, 0, 36], [0, 90, 0, 0] ]
        int[][] ints6 = new int[3][]; // [null, null, null]
        ints6[0] = new int[2]; // [[0,0], null, null]
        ints6[1] = new int[3]; // [[0,0], [0,0,0], null]
        ints6[2] = new int[4]; // [[0,0], [0,0,0], [0,0,0,0]]
        System.out.println(Arrays.deepToString(ints6));
        ints6[2][1] = 90;
        ints6[1][2] = 36;

        int[] ints7 = {3, -6, 12, 0, 4};
        // for позволяет изменить значение элемента массива
        //  0   1   2  3  4
        // [3, -6, 12, 0, 4]
        int summ = 0;
        for (int index = 0; index < ints7.length; index += 1) {
            ints7[index] *= ints7[index];
            summ += ints7[index];
        }
        // найти сумму значений элементов массива ints7
        System.out.println(summ);

        summ = 0;
        // не предоставляет доступа к индексам,
        // не дает возможность изменить значения элементов массива
        // element - значения элементов массива
        for (int element: ints7) {
            System.out.println(element);
            summ += element;
        }
        // найти и вывести в консоль
        // минимальное значение элемента массива ints8
        double[] ints8 = {3.7, -6.2, 12.9, 0.4, 4.1};
        double minValue = ints8[0];
        for (double elem: ints8) {
            if (minValue > elem) minValue = elem;
        }
        System.out.println(minValue);
        // вывесли в консоль случайный элемент массива ints8
        // использовть Math.random()
        System.out.println(ints8[(int)(Math.random() * ints8.length)]);

        Arrays.sort(ints8);
        // {3.7, -6.2, 12.9, 0.4, 4.1};
        System.out.println(Arrays.toString(ints8));
        // [-6.2, 0.4, 3.7, 4.1, 12.9]
        int element = Arrays.binarySearch(ints8, 3.7);
        System.out.println(element); // 2

        // [-6.2, 0.4, 3.7, 4.1, 12.9]
        element = Arrays.binarySearch(ints8, 4); // 3 + 1
        System.out.println(element); // -4
        element = Arrays.binarySearch(ints8, 13); // 5 + 1
        System.out.println(element); // -6

        // копирование массива
        double[] ints9 = {3.7, -6.2, 12.9, 0.4, 4.1};
        // double[] ints10 = ints9;
        double[] cloneInts9 = ints9.clone();

        // Arrays.copyOf()
        double[] copyInts9 = Arrays.copyOf(ints9, 3);
        System.out.println(Arrays.toString(copyInts9));

        double[] newDoubles = new double[10];
        System.arraycopy(ints9, 1, newDoubles, 3, 2);
        // [0.0, 0.0, 0.0, -6.2, 12.9, 0.0, 0.0, 0.0, 0.0, 0.0]
        System.out.println(Arrays.toString(newDoubles));

        // алгоритм быстрой сортировки

    }
}
