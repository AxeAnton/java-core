package ru.itmo.lessons.lessons36.reflection;

public class TextMessage extends Message{ // 2. класс наследуется от класса Message его свойства и методы и сам имеет свои свойства

    private String text;
    public final String code = "ТЕКСТОВОЕ СООБЩЕНИЕ"; // 3. Класс имеет свойство final code со значением "ТЕКСТОВОЕ СООБЩЕНИЕ"

    // 5. Так же у TextMessage есть конструктор, который принимает на вход отправителя и у Message п. 6 есть конструктор, который принимает на вход отправителя.
    public TextMessage(String sender) {
        super(sender);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    // 4. Так же свойство code имеет приватный метод printInfo, который выводит какую то инфо.
    private void printInfo(){
        System.out.println("Экземпляр типа TextMessage. Свойства и значения: sender(" + getSender() + "), " +
                "text(" + text + "), " +
                "code(" + code + ") ");
    }


    @Override
    public String toString() {
        return "TextMessage{" +
                "text='" + text + '\'' +
                "} " + super.toString();
    }
}
