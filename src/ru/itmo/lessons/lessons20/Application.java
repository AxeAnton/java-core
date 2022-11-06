package ru.itmo.lessons.lessons20;

import java.io.File;

public class Application {
    public static void main(String[] args) {
        Point a = new Point(45, 67); // создали свойства
        Point b = new Point(67, 12);
        Point c = new Point(89, -8);

        // ≈ще нюанс, что передоватьс€ на чтение или запись должно колекци€ или общий класс.

        BinHandler binHandler = new BinHandler(new File("dsds.bin")); // создали экземпл€р и передали в аргумент пуль нового файла, куда будет происходить запись
        binHandler.writeToFile(a); // вызвали метод записи.

        Point aFromFile = binHandler.readFromFile(); // прочли методом из файла
        System.out.println(aFromFile); // показали в консоли

        Figure figure = new Figure(3); // создали объект из Point  на три значени€, закинули значение
        figure.addPoint(a);
        figure.addPoint(b);
        figure.addPoint(c);

        binHandler.writeToFile(figure); // записали в файл

        Figure figureFromFile = binHandler.readFromFile(); // прочли из файла
        System.out.println(figureFromFile); // вывели в консоль
    }
}
