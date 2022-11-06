package ru.itmo.lessons.lesson6.books;

// 1.8 -  ru.itmo.lessons.lesson6.books.Author
public class Author {
    // 1.9 - свойства, характеристики, поля, атрибуты
    public String name; // 1.17 - если не указали, то по умолчанию null
    public String surname; // 1.20 - если МОДИФИКАТОР ДОСТУПА (МД) - public, то к свойству можно обратиться из любого участка программы.

    // 1.21 - объявление методов
    // 1.22 - FIXME если МЕТОД ни чего НЕ возвращает, то используем ТД - void!
    public void printFullName() {
        // 1.23 - FIXME можно использовать 'return;', чтобы прервать работу метода
        System.out.println(name + " " + surname);
    }

    public String getFullName() { // 1.27 - возвращает результат работы метода, поэтому необходим ТД есть
        // 1.28 FIXME - return - так же возвращает результат работы метода и прерывает работу метода, инструкции после return не будут выполнены
        return name + " " + surname; // 1.29 - странно, но контаминация строк будет выполнена см. 1.30.
    }

    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
