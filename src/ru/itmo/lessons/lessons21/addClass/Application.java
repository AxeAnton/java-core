package ru.itmo.lessons.lessons21.addClass;

public class Application {

    public static void main(String[] args) {
        User user = new User(User.Level.LOW, "qwe");// 14. объект юзер (внешний класс), передаем ему логин и левел, до левала надо достучасться через внешний класс.

        // 15. экземпляр внутреннего класса
        User.Account account = user.new Account(20); //16. Прописываем вот такую вложенность User.Account, далее берем перемееную внешнего класса из 6й строки user.new и вызвать конструктор акаунта или 17.
        System.out.println(account.getUser());

        User.Account account2 = new User(User.Level.HIGH, "asd")// 17. создаем экземпляр внешнего класса, а у него вызываем экземпляр вложенного класса.
                .new Account(200);

        System.out.println(account2.getUser()); // 18. получается на первый взгляд не понятная хрень, но по факту все связано, у accaunta2 нет доступа к объекту внешнего класса ЮЗЕР(может не к объекту а к методу?), но к ниму есть доступ через объект внутреннего класса account2.getUser().

        // 26. создание экземпляра вложенного класса
        Student.Exam math = new Student.Exam("math");

        Student student1 = new Student("Tom");
        student1.addExam(math); //27. что бы вызвать у студента связь с типами экзаменов делаем метод у студента 28.

        // 31. анонимные классы
        SomeInterface object = new SomeInterface() { // 32. и класс напишем и объект создадим, причем при его создании автоматом развернется вот такие методы строчка 26,28,30.
            @Override
            public void void1() {System.out.println("void1");} // 33. описываем класс который имплементирует интерфейсSome Interface. В аргументне нет имени класса но физически он есть и методы этот именно этого нивидимого класса.
            @Override
            public void void2() {System.out.println("void2");}
            @Override
            public void void3() {System.out.println("void3");}
        };
        System.out.println(object);
        object.void2();
        object.void1();



    }
}
