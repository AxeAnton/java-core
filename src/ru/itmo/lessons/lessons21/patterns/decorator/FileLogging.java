package ru.itmo.lessons.lessons21.patterns.decorator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
// 17. основной функционал, т.к может использоваться независимо, а декараторо один не может, отсюдо и название - основной функционал.
public class FileLogging implements LogStrategy {
    @Override
    public void log(String data) { //16. и уже метод FileLogging записывает в файл.
        try {
            Files.writeString(Path.of("log.txt"), data + "\r\n", StandardOpenOption.APPEND);
        } catch (IOException ignored) { }
    }
}