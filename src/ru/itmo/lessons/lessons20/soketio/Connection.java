package ru.itmo.lessons.lessons20.soketio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable {
// 1.55 - все соединение, как с одной, так и с другой стороны обусловлено вот этим классом. AutoCloseable,говорит о том что можно использовать try с ресурсами.
    private Socket socket; // 1.56 - есть socket, он необходим, как с одной, так и с другой стороны.
    private ObjectInputStream input; // 1.57 - необходим, что бы отдать данные другой программе
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream()); // 1.58 - получается, что после того как соединение устанавливается (this.socket..., данные начинают уходить не в файл, а в это tOutputStream() поток. Ну и соотведственно ObjectOutputStream будет сериализовать байты.
        input = new ObjectInputStream(this.socket.getInputStream()); // 1.61 - есть еще входящий поток, он тоже берется из соеденения (this.socket), т.е у сокета, мы получаем входящий поток .getInputStream()
    }
    // 1.62 - важно при создании соединения соблюдать последовательность: сначало канал - сокет, затем исходящий поток - ObjectOutputStream и в конце входящий поток - ObjectInputStream. -> Client

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message); // 1.59 - соответственно getOutputStream(... сначала сериализует SimpleMessage.java которая передается в последовательность байт и потом эта последовательность уйдет по tOutputStream(). Тоесть из одной программы уйдет в другую программу, будут исходящие данные.
        output.flush(); // 1.60 - далее если данные передаются не в файлике, а из программы в программу, то метод flush должен быть вызван обязательно или данные застрянут в канале и не дойдут.
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }
    // 1.61 - полученные данные ObjectInputStream преобразует в наш SimpleMessage и мы получаем то сообщение которое пришло.

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
