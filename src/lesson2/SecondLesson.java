package lesson2;

public class SecondLesson {
    public static void main(String[] args) {
        // логические операторы
        // && оператор и
        int x = 50, y = 100, z = 91;
        boolean res = (x % 2 == 0) && (y % 2 == 0) && (z % 2 == 0);
        //            true && true && false
        //            true && false
        System.out.println(res); // false

        res = (x < z) && (y > z);
        System.out.println(res); // true

        // || оператор или
        int code = 3333, age = 34;
        res = (code == 2222) || (code == 3333) || (code == 4444);
        //    false || true || false
        //             true || false
        System.out.println(res); // true

        res = (code != 3333) || (age < 18);
        //     false || false
        System.out.println(res); // false

        // ! оператор не - меняет значение на противоположное
        System.out.println(!res); // true

        boolean isActive = false, isConnected = true;
        res = !isActive || !isConnected;
        //    true || false
        System.out.println(res); // true
        res = !(code != 3333) || (age < 18);
        res = !((code != 3333) || (age < 18));
        //       false || false
        //          !false
        System.out.println(res); // true

        int state = 1;
        // если state равен 0 вывести в консоль "Закрытие приложения"
        // если state равен 1 вывести в консоль "Открытие приложения"
        // в противном случае вывести в консоль "Ошибка статуса"

        if (state == 0) System.out.println("Закрытие приложения");
        else if (state == 1) System.out.println("Открытие приложения");
        else System.out.println("Ошибка статуса");


        // дан номер месяца, например int month = 5;
        // В зависимости от данного значения вывести
        // в консоль время года

        // 12, 1, 2 - зима
        // 3, 4, 5 - весна
        // 6, 7, 8 - лето
        // 9, 10, 11 - осень
        int month = 5;
        if (month == 12 || month == 1 || month == 2) {
            System.out.println("Зима");
        } else if (month == 3 || month == 4 || month == 5) {
            System.out.println("Весна");
        } else if (month == 6 || month == 7 || month == 8) {
            System.out.println("Лето");
        } else if (month == 9 || month == 10 || month == 11) {
            System.out.println("Осень");
        } else {
            System.out.println("Ошибка");
        }

        if (month > 0 && month < 3 || month == 12) {
            System.out.println("Зима");
        } else if (month > 2 && month < 6) {
            System.out.println("Весна");
        } else if (month > 5 && month < 9){
            System.out.println("Лето");
        } else if (month > 8 && month < 11) {
            System.out.println("Осень");
        } else {
            System.out.println("Ошибка");
        }


        month = 2;
        switch (month) { // month == 12 || month == 1 || month == 2
            case 1:
            case 2:
            case 12:
                System.out.println("Зима");
                break;
            case 3:
            case 4:
            case 5:
                System.out.println("Весна");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Лето");
                break;
            default:
                System.out.println("Ошибка");
        }

        int sum = 1000, saleCode = 7647;
        // 4525 - вывести сумму с учетом скидки 30%
        // 6424, 7012 - вывести сумму с учетом скидки 20%
        // 7647, 9011, 6612 - вывести сумму с учетом скидки 10%
        // в остальных случаях скидка не предусмотрена



    }
}
