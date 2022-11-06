package ru.itmo.lessons.lesson6.books;

import java.util.Objects;

// ru.itmo.lessons.lesson6.books.Book
public class Book {
    // 1.31 - свойства:
    private String title; // 1.32 - название
    private int pageCount; // 1.33 - количество страниц
    private Author author; // 1.34 - автор
    // 1.37 - если МД private, то можно обратоться только из текущего КЛАССА

     // 1.48 FIXME конструктор вызывается в момент создания объекта: new Book(), конструктор без аргумента необходим, что бы не выскакивала ошибка в App, при создании объектв (Book book1 = new Book(ПУСТОЙ КОНСТРУКТОР);).
    public Book(){}

    // 1.48 FIXME тут же можно создать перегруженный конструктор, тогда в аргумент экземпляра, можно вносить значения, а можно не вносить.
    public Book(Author author) {
        Objects.requireNonNull(author, "author не мб null");
        // 1.49 FIXME проверка на NULL, в аргументе пишем ссылку на объект который проверяем + сообщение если произойдет ошибка.
        this.author = author;
        // 1.50 - Можно записать и так: this.author = Objects.requireNonNull(author, "author не мб null");
    }

    public Book(String title, Author author){ // 1.49 конструктор с ссылкой на Author и свойством - имя книги
        this(author); // 1.52 FIXME, аналагичная история и про проверку на NULL из конструктора выше, что ы ее не писать повторно, просто указываем ссылку на конструктор с аргументом Author далее -> Shelf
        setTitle(title);
        // 1.51 FIXME, т.к в сетторе есть то проверку по поводу имени книги, заново писать не надо, а указываем вот так setTitle(title); Получается, что название книги может быть заодно из App через конструктор (и будут сделаны проверки соответствующие), а можно через метод сеттор и так же будут сделаны соотведствующие проверки.
    }

    // // 1.38 - методы, позволяющие установить значения свойств со всеми необходимыми проверками называются - сеттеры
    public void setTitle(String titleValue){ // 1.39 FIXME - аргумент метода (ТД названим) принимает необходимые значения которые ему необходимы для выполнения {инструкции} -> App
        if (titleValue == null || titleValue.length() < 3) { // 1.41 порверка на null и количество букв в названии книги.
            throw new IllegalArgumentException("Значение title от 3 символов");
            // 1.42 FIXME создание экзкмпляра ошибки (new IllegalArgumentException("Значение title от 3 символов");) и вывод в консоль! throw - выбрасывание этого исключения.
        }
        title = titleValue; // 1.43 FIXME - если ошибки нет, то свойству title присваевается значение - titleValue;
    }

    // 1.44 FIXME - методы, которые возвращают значения свойств (return title;)- геттеры -> App
    public String getTitle(){
        return title;
    }

    public void setPageCount(int pageCount){
        if (pageCount < 10) {
            throw new IllegalArgumentException("Значение pageCount дб больше 10");
        }
        // 1.47 FIXME - если имя свойств и имя локальной переменной совпадают, то имени СВОЙСТВА прибавляем "this" - ссылка на текущий объект
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public Author getAuthor() {
        return author;
    }

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", pageCount=" + pageCount +
                ", author=" + author +
                '}';
    }
}

