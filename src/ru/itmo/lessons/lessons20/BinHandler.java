package ru.itmo.lessons.lessons20;

import java.io.*;

public class BinHandler {
    private File file = new File("lesson20.bin"); // создаем файл в который будет приходить информация

    public BinHandler() {} // конструктоор дл язаписи в файлик по умолчанию, я так понимаю, что вот в этот "lesson20.bin"

    public BinHandler(File file) { // если необходимо записать в другой файлик, будем использовать дланный конструктор
        this.file = file;
    }

    public <T> boolean writeToFile(T object){ // метод записи в файлик. ТД выбираем, как если хотим point, то указываем Point, еслит хотим Figure, то указываем Figure, а если обстрактный то джинерик. ТАк же необходимо не только в аргументе указать ждинерик но и посте модификатора доступа, что мол наш метод будет использовать джинерик тип.
        boolean result = false; // результат работы метода
        try (FileOutputStream fileOutput = new FileOutputStream(file); // второй аргумент если не написан то по умолчанию false = Перезапись.
             ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput)) { // Переводит object в последовательность БАЙТ, полностью, передача информаци, происходит двумя строчками ниже.
            objectOutput.writeObject(object);
            result = true;
            // объект (object) превращается в последовательность байт (objectOutput)
            // последовательность байт записывается в файл (fileOutput) или просто в файл
        } catch (IOException e) { // Ловля исключений
            System.out.println(e.getMessage()); // .getMess - подробное описание почему программа прервалась, вызывается переменно ошибки"e".
        }
        return result;
    }

    public <T> T readFromFile(){// метод читает из файлика. Не забываем про джинерики <T>, это ТД который будет использовать метод, а вторая - T - это ТД возвращаемого значения.
        Object result = null; // в result записываем тот объект который реализуем просле прочтения файлика (не очень понял смысл строчки) //Почему Object,
        try (FileInputStream fileInput = new FileInputStream(file);
             ObjectInputStream objectInput = new ObjectInputStream(fileInput)) {
            // работает так, последовательность байт в objectInput поступает из fileInput который в аргументе имеет FILE.
            // а затем последовательность байт читается readObject(), фактически происходит сборка объекта.
            result = objectInput.readObject(); // Вообщем какая то херня и запутка, но смысл такой что получаем ТД Object который потом строчка 37 можно преобразовать в ТД <Т>, видимо для этого и нужна переменная result.
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return (T) result;
    }


}
