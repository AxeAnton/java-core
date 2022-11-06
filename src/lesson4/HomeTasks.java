package lesson4;

import java.util.Arrays;

public class HomeTasks {
    public static void main(String[] args) {
        // TODO:: Задача 1. Заполните массив на N элементов
        //  случайным целыми числами
        //  выведите максимальное, минимальное и среднее значение

        int len = (int) (4 + Math.random() * 30);
        int[] arr1 = new int[len];

        double avg = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = (int) (Math.random() * 100);
            avg += (double) arr1[i]/arr1.length;
        }
        System.out.println(Arrays.toString(arr1));

        Arrays.sort(arr1);
        System.out.println("Минимальное " + arr1[0]);
        System.out.println("Максимальное " + arr1[arr1.length - 1]);
        System.out.println("Среднее " + avg);

        // TODO:: Задача 2. Создайте массив из чётных чисел [2;20] и
        //  выведите элементы массива в консоль в обратном порядке
        //  (20 18 16 ... 4 2)

        int[] arr2 = new int[20 / 2];
        for (int i = 0, element = 2; i < arr2.length; i++, element += 2) {
            arr2[i] = element;
        }

        System.out.println(Arrays.toString(arr2));

        for (int i = arr2.length - 1; i >= 0; i -= 1) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();

        // TODO:: Задача 3. Создайте массив из 11 случайных целых
        //  чисел из отрезка [-1;1]
        int[] arr3 = {-1, 0, -1, -1, 0, 1, 1, 0, 0, 0, 1, -1};
        int[] counts = new int[3]; // [0] для -1, [1] для 0, [2] для 1
        int countPos = 0;
        int countZero = 0;
        int countNeg = 0;
        for (int element : arr3) {
            if (element == -1) counts[0] += 1;
            else if (element == 0) counts[1] += 1;
            else counts[2] += 1;
        }

        if (counts[2] > counts[0] && counts[2] > counts[1]) {
            System.out.println("1 встречается " + counts[2] + " раз(а)");
        } else if (counts[0] > counts[1] && counts[0] > counts[2]) {
            System.out.println("-1 встречается " + counts[0] + " раз(а)");
        } else if (counts[1] > counts[0] && counts[1] > counts[2]) {
            System.out.println("0 встречается " + counts[1] + " раз(а)");
        }

        // TODO:: Задача 4. Задан одномерный массив целых чисел.
        //  Образуйте из него два отсортированных по возрастанию массива,
        //  содержащих четные и нечетные числа.

        int[] arr4 = {56, 21, 29, 36, 77, 13, 78, 30, 4, 1, 90, 11};

        int evenCount = 0; // четные
        int oddCount = 0; // нечетные

        for (int element : arr4) {
            if (element % 2 == 0) evenCount += 1;
            else oddCount += 1;
        }

        int[] evenArr = new int[evenCount];
        int[] oddArr = new int[oddCount];

        int evenIndex = 0; // четные
        int oddIndex = 0; // нечетные

        for (int element : arr4) {
            if (element % 2 == 0) {
                evenArr[evenIndex] = element;
                evenIndex += 1;
            } else {
                oddArr[oddIndex] = element;
                oddIndex += 1;
            }
        }
        Arrays.sort(evenArr);
        Arrays.sort(oddArr);

        System.out.println(Arrays.toString(evenArr));
        System.out.println(Arrays.toString(oddArr));

        // TODO:: Задача 5. Задать массив.
        //  Отрицательные элементы массива перенести в новый массив.
        //  Размер массива должен быть равен количеству отрицательных элементов.

        int[] arr5 = {-7, 11, 3, -56, 0, -32, 101, 5, -5, 19};

        int negCount = 0;
        for (int element : arr5) {
            if (element < 0) negCount += 1;
        }
        int[] negArr = new int[negCount];
        int negIndex = 0;
        for (int element : arr5) {
            if (element < 0) {
                negArr[negIndex] = element;
                negIndex += 1;
            }
        }
        System.out.println(Arrays.toString(negArr));


    }

}
