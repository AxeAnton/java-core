package ru.itmo.lessons.lesson6;

//import ru.itmo.lessons.lesson6.books.Author;

import ru.itmo.lessons.lesson6.books.Author; // 1.12 - если классы в разных ПАКЕТАХ, то для использования класса необходимо его импортировать
import ru.itmo.lessons.lesson6.books.Book;
import ru.itmo.lessons.lesson6.books.Shelf;

// полное имя класса: имя пакета + имя класса, например
// ru.itmo.lessons.lesson6.Application
public class Application {
    public static void main(String[] args) {
        //  1.10 - объект, экземпляр класса Author
        // 1.11 - типДанных имяПеременной = new вызовКонструктора();
        Author author1 = new Author();
        // 1.14 - обращение к свойствам осуществляется через "."
        // но при таком подходе в значение свойства можно записать все, что угодно.
        // Это может навредить программе
        // Например, author1.name = ""; или author1.surname = null; и тд
        // поэтому лучше ограничить свободный доступ к свойствам и
        // использовать методы, в которых можно будет реализовать проверку входящих данных
        author1.name = "Tom"; // 1.15 - свойству name объекта author1 присвоили значение Tom
        author1.surname = "Crowed"; // 1.16 -  свойству surname объекта author1 присвоили значение Crowed

        Author author2 = new Author(); // 1.13 - второй экземпляр
        author2.name = "Mike"; // 1.18 - свойству name объекта author2 присвоили значение Mike
        author2.surname = "Thompson"; // 1.19 - свойству surname объекта author2 присвоили значение Thompson

        // 1.24 - вызов методов
        author1.printFullName(); // 1.25 - вызвали метод printFullName объекта author1
        author2.printFullName(); // 1.26 - вызвали метод printFullName объекта author2

        // 1.30 - вызвали метод getFullName объекта author1, результат работы метода присвоили переменной fullName
        String fullName = author1.getFullName();
        System.out.println(fullName);

        // 1.35 - Создаем объект книги - типДанных имяПеременной = new вызовКонструктора(аргументы);
        Book book1 = new Book(author2);
        // 1.36 - в конструктор передали ссылку на экземпляр класса Author -> Book 1.37
        book1.setTitle("Книга");
        // 1.40 - Т.к есть сеттор, то можно вызвать метод setTitle объекта book1, + метод проверит валидность данных, установит значение свойства title -> Book
        System.out.println(book1.getTitle());
        // 1.45 -  Т.к есть геттор, то метод getTitle вернет значение свойства title объекта book1

        book1.setPageCount(22);
        // 1.46 - аналогично для количество страниц, вызвали метод setPageCount объекта book1, метод проверит валидность данных, установит значение свойства pageCount -> Book

        Book book2 = new Book(author2);
        book2.setTitle("Java 17");
        book2.setPageCount(3700);

        Book book3 = new Book(author1);
        book3.setTitle("Строки в Java");
        book3.setPageCount(1200);

        Book book4 = new Book(author1);
        book4.setTitle("Коллекции в Java");
        book4.setPageCount(300);

        Book book5 = new Book(author2);
        book5.setTitle("Многопоточность в Java");
        book5.setPageCount(2600);

        // 1.58 - типДанных имяПеременной = new вызовКонструктора();
        Shelf shelf = new Shelf();
        // 1.59 - метод addBook перегружен
        shelf.addBook(book1); // 1.60 - вызов метода addBook(Book book) {} для чниги1
        shelf.addBook(book5); // 1.61 - вызов метода addBook(Book book) {} для чниги1
        shelf.addBook(book2, book3, book4); // 1.62 - FIXME вызов метода addBook(Book... books) {} и передача в аргумент МНОЖЕСТВО книг


        // 1.63 - FIXME вывод имени автора первой книги на полке
        System.out.println(shelf.getBooks()[0].getAuthor().name);
        // 1. shelf - экземпляр класса Shelf
        // 2. shelf.getBooks() метод вернет ссылку на значение свойства books объекта shelf - массив книг
        // 3. shelf.getBooks()[0] обратились к элементу массива с индексом 0 - экземпляр класса Book
        // 4. shelf.getBooks()[0].getAuthor() метод вернет ссылку на значение свойства author книги
        // 5. shelf.getBooks()[0].getAuthor().name получили значение свойства name автора

        // 1.1 - класс - способ описания сущности,
        // 1.2 - определяющий ее состояние и поведение
        //  1.3 - класс - набор свойств и методов будущих объектов

        // 1.4 - На основе класса создаются объекты
        // 1.5 - (экземпляры данного класса) - представители
        // 1.6 - данного класса, имеющие конкретное состояние и
        // 1.7 - поведение, определенное в классе

    }
}
