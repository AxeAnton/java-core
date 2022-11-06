package ru.itmo.lessons.lessons36.annotation;

@ClassConfig(prefix = "cat")
public class Cat {
    @Required // 55. если в классе есть свойство с аннотацией @Required - для данных полей необходимо установить значение этого поля, данные для имени и возраста необходимо взять из configFile() п. 56
    private String name;

    @Required // 45. пример аннотирования полей класса
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
