package ru.itmo.lessons.lessons20.soketio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class EchoServer {


    private int port;
    private Connection connection;
    private int count;

    public EchoServer(int port){
        this.port = port;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void start() throws IOException, ClassNotFoundException {
        try (ServerSocket serverSocket = new ServerSocket(port)){     // 1.68 - серверная программа, так: для запуска программы необходим объект ServerSocket, он запускает программу на указанном порту (port) и ждет подключения,
            System.out.println("Server started...");
            while (true){  // 1.69 - в бесконечном цикле серверная сторона начинает ждать клиента,
                Socket socket = serverSocket.accept(); // 1.70 - как только приходит клиент, устанавливается соединение (сокет) между клиентом и сервером,
                connection = new Connection(socket); // 1.71 - серверная сторона читает сообщение которое пришло от клиента,
               printMessage(connection.readMessage()); // ДЗ, если в readMessage, нужная команда то происходит соответствующий ответ.
               connection.sendMessage(SimpleMessage.getMessage("server", "сообщение")); // 1.72 - формирует свое сообщение и отправляет обратно клиенту
                // count += 1;

                //SimpleMessage message = connection.readMessage();

            }
        }
    }

    // 1.73 - Запуск, сначала run для сервера, затем для клиента. Можно подключить несколько клиентов, для этого необходимо пкн в поле КЛИЕНТА выбрать Modify Run Configuratio -> modify options -> вот эта вкладка (разрешает множественный запуск). -> все далее ДЗ

    private void printMessage(SimpleMessage message){
        System.out.println("получено сообщение: " + message);
    }

    public static void main(String[] args) {
        int port = 8090;
        EchoServer messageServer = new EchoServer(port);
        try {
            messageServer.start();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
