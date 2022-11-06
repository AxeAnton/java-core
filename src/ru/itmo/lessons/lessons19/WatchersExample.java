package ru.itmo.lessons.lessons19;

import java.io.IOException;
import java.nio.file.*;

public class WatchersExample {
    public static void main(String[] args) throws IOException, InterruptedException {
        // ДЛя инфо - В пакете nio есть класс Falils (S на конце), имеет много методов для работы с файлами.


        // WatchService, в пакети nio есть
        // (будет следить за событиями по указанному в дальнейшем пути)
        WatchService watchService = FileSystems.getDefault().newWatchService();

        // создаем объект типа Path - аналог объекта File в io
        // Paths.get(путь к файлу или директории); //
        Path path = Paths.get(args[0]);

        // регистрируем path в WatchService на события:
        // создание / удаление / изменение
        path.register(watchService,
                StandardWatchEventKinds.ENTRY_CREATE,
                StandardWatchEventKinds.ENTRY_DELETE,
                StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        // получаем ключ
        while ((key = watchService.take()) != null) {
            // получаем список произошедших событий
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println(event.kind() + " : " + event.context());
            }
            key.reset();
        }



    }
}
