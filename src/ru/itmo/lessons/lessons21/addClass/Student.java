package ru.itmo.lessons.lessons21.addClass;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private  String name;
    private List<Exam> examList = new ArrayList<>(); // 24 студенту зададим имя и список экзаменов

    public Student(String name) {
        this.name = name;
    }

    public void addExam(Exam exam){
        examList.add(exam); // 28. метод необходимо что бы вызвать у студента связь с типами экзаменов.
    }

    public void printExamInfo(){
        examList.forEach(System.out::println); // 25. пройдемся по списку и выведем все экзамены
    }

    public static class Exam {
        // 19. вложенные классы (static), объект вложенного класса можно создать без объекта внешнего класса.
        // 21. внешний класс не может быть статическим
        // 22. область видимости, согласно модификаторам
        // NB 23. нет доступа к НЕ статическим свойствам и методам внешнего класс
        private String title;

        public Exam(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        @Override
        public String toString() {
            return "Exam{" +
                    "title='" + title + '\'' +
                    '}';
        }
    }
}
