package ru.itmo.lessons.lesson6.books;

import java.util.Arrays;

public class Shelf {
    private String color = "белый"; // 1.53 - цвет полки
    private Book[] books = new Book[4]; // 1.54 - FIXME книги, указываем сразу ОБЪЕКТ МАССИВА!

    public Book[] getBooks() {
        return books;
    }


    public void setColor(String color) {
        if (color == null || color.length() < 4) {
            throw new IllegalArgumentException("В названии цвета должно быть не менее 4 символов");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // 1.55 - метод добавления одной книги на полку
    public void addBook(Book book){
        for (int i = 0; i < books.length; i += 1) {
            if (books[i] == null) {
                books[i] = book;
                return; // return
                // 1.56 - FIXME  return- заканчивает целиком метод, а break - ТОЛЬКО цикл!
            }
        }
        System.out.println("Книге '" + book.getTitle() + "' автора " + book.getAuthor().getFullName() + " не хватило места на полке ");
    }
    // 1.57 - FIXME метод добавления нескольких книг (Book... books), три точки! на полку. FIXME перегруженный метод -> App
    public void addBook(Book... books){
        System.out.println(Arrays.toString(books));
        for (Book book : books) {
            addBook(book); // вызов метода addBook(Book book)
        }
    }

}
