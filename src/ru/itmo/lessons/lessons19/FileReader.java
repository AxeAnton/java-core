package ru.itmo.lessons.lessons19;


import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Properties;
import java.util.Scanner;


public class FileReader {

    // java.io
    // java.nio
    // new File(файл или директория)


    // программа        источник
    // InputStream (байты) получение потока байт в программу // По отношению к программе, проще заполнить.
    // OutputStream (байты) отправка данных из программы. // По отношению к программе, проще заполнить.

    // Reader (char) получение потока чар в программу
    // Writer (char) отправка данных из программы


    // FileInputStream / FileOutputStream - физически работают с файлами, добавляют и читают, только байты.
    // Уже работают по отнашению к ФАЙЛУ.
    // ObjectInputStream / ObjectOutputStream - представляют объект в виде последовательности байт.

    // FileInputStream(CustomStream(ObjectInputStream((объект))))
    // Пример реализации, берем объект, представляем в виде последовательности байт, далее какие то инструкции(могут идти и с объектом) клиента а затем, все передается в ФАЙЛ.

    public static boolean writeToFile(byte[] data, File file) /*throws FileNotFoundException*/ { // При написани данного метода, а конкретно сточки 47, подчеркивается красным FileOutputStream, она требует определения охибки - ее можно переложить на кого то еще - /*throws FileNotFoundException*/ или обработать блоком Catch строчка 65.
        // Properties
        // как хранит данные
        // как добавить данные
        // как получить данные

        // имя-файла.properties

        // как прочитать данные из properties файла в экземпляр Properties


        boolean result = false;
        try (FileOutputStream fileOutput = new FileOutputStream(file, true)) { //Флаг true - дозапись, falce - перезапись
            // открытие канала (возможность передовать данные) посути это создание объекта. Но автоматическое закрытие канала требует реализации метода CLOSE (любые инструкции).

            // true - дозапись в файл - new FileOutputStream(file, true)
            // false - перезапись new - FileOutputStream(file)

            // // try with resources (java 7):
            // Если прописываем открытие ресурса (видимо пути передачи информации) в круглых скобки try то закрытие КАНАЛА произойдет автоматически ПОСЛЕ передачи информации.
            // 1. все инструкции блока try выполнены без ошибок
            // 2. в блоке try произошла ошибка. // Ресурсы будут закрыты ДО перхвата ИСКЛЮЧЕНИЯ блоком catch, сначало закрытие. а потом блок catch.

            // Если класс, объект которого создается в try with resources, реализует  AutoCloseable интерфейс и его абстрактынй метод void close()


            // если try with resources не используется(в круглые скобки ни чего не записывается) , закрывать ресурсы нужно в блоке finally (я так понял это после первых внутренних фигурных скобок, используем метод close или еще какой...)
            // Важно при такой реализациии ЗАКРЫТИЕ канала происходит после выбрасывания ИСКЛЮЧЕНИЯ.
            fileOutput.write(data);
            result = true;
        } catch (FileNotFoundException e) { // необходимо обработать две ошибки.
            System.out.println("Не удалось использовать файл");
        } catch (IOException e) { // FileNotFoundException - наследник IOException поэтому если его записать  первым то второй писать не надо.
            System.out.println("Не удалось записать данные в файл");
        }
        return result;
        //важный момент, что result небходимо задать до блока try, строчка 46, иначе его видно не будет
    }

    public static byte[] readFromFile(File file) { // данные из файла метод будет читать
        byte[] result = null; // присваеваем значение переменной, что либо вернем null если данные не будут прочитаны, иливернем массив с байтами с данными которые будут проситаны.
        try (FileInputStream fileInput = new FileInputStream(file)) { //создали объект передали на вход ссылку на файлик
            result = fileInput.readAllBytes(); // это метод для чтения
        } catch (FileNotFoundException e) { // т.к есть(new FileInputStream) метод close, необходимо обработать ошибки ALT+ENTER
            // throw new RuntimeException(e); // эти комментарии выводятся автоматически, что бы программа упала, иногда это правильно
            System.out.println("Не удалось использовать файл");
        } catch (IOException e) {
            // throw new RuntimeException(e);
            System.out.println("Не удалось прочитать данные из файла");
        }
        return result;
    }

    public static boolean writeFromConsole(File file) {
        boolean result = false;
        // основной функционал
        try (FileOutputStream fileOutput = new FileOutputStream(file, true);
             // декоратор и их может быть несколько
             BufferedOutputStream buffer = new BufferedOutputStream(fileOutput)) { // в круглых скобках Try можно создать несколько объектов через запятую.
    // buffer принимает в себя какой то объем, а потом передает fileOutput для записи в файл, не забываем в аргумент buffer прописать ссылку на fileOutput.

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Введите данные или stop для выхода");
                String userInput = scanner.nextLine();
                if ("stop".equalsIgnoreCase(userInput)) break;
                buffer.write(userInput.getBytes()); //
                // ДекораторOutputStream, в данном случаи buffered, вызывает метод write у OutputStream (в нашем случаиFileOutputStream), сылка которого есть в его аргументе (fileOutput - строчка 93).
                // NB записываем методом write в файл, но для записи необходимо представить строчку, как getBytes.
            }
            result = true;
        } catch (IOException e) {
            System.out.println("Проблемы с записью в файл");
        }
        return result;
    }

    public static String readWithBuffer(File file) {
        String result = null;
        try (FileInputStream fileInput = new FileInputStream(file);
             BufferedInputStream bufferedInput = new BufferedInputStream(fileInput); //1.bufferedInput - берет из файла FileInputStream fileInput - первую порцию
             ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[300]; // маленький буффер,  // 4 если последнее копирование в маленький буфер полностью массив не заполнен, получится, что часть будет новых, а часть старых, что бы это не допустить и нужно считать количество переданных байт в 122 строке.
            int count;

            while ((count = bufferedInput.read(buffer)) != -1) { // 2. чтение происходит из буффера (bufferedInput) в МАЛЕНЬКИЙ БУФЕР //NB метод read возвращает или количество прочитанных бый или "-1" если нечего читать
                byteArray.write(buffer, 0, count); // 3 обращаемя в byteArray с 116 строки вызываем метод запись write в и передаем в byteArray. Аргумент, buffer - откудо читаем и помещаем в byteArray, off 0 - смещение, количество - сколько записали).
            }

            result = byteArray.toString(); // new String(byteArray.toString());

        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }

        return result;
    }

    // методы для преобразования изображений в байты, но т.к есть фрэйм оррки, то ими обычно не пользуются
    public static boolean byteArrayToImage(File file, byte[] bytes) throws IOException { // массив бат byte[] bytes будет записываться в файлик File file //throws IOException выкинули наружу ошибки, что бы их не переопределять
        try (ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes)) { //создается ByteArrayInputStream byteArray (в аргументе (bytes)), т.к BufferedImage image не может читать напрямую, затем
            BufferedImage image = ImageIO.read(byteArray); // далее буфер читает из byteArray
            return ImageIO.write(image, "png", file); // из буфера читаем изображение image используя метод write из класса ImageIO, и помещаем изображение в file с расширением png
        }
    }


    // наоборот из изображения в массив.
    public static byte[] imageToBytes(File file) throws IOException {
        BufferedImage image = ImageIO.read(file); // 1. в буфер прочитали из файлика (File file) - ImageIO.read(file)
        ByteArrayOutputStream arrayOutput = new ByteArrayOutputStream(); //2. созжаем экземпляр массива куда будет помещено изображение
        ImageIO.write(image, "png", arrayOutput); //3. из буфера (imege) перелажили в ByteArrayOutputStream arrayOutput c расширением png
        return arrayOutput.toByteArray(); // с помощью вот этого метода получаем массив с байтами toByteArray()
    }

}