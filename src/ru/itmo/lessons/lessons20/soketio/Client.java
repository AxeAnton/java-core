package ru.itmo.lessons.lessons20.soketio;

import java.io.IOException;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Client implements Command{

    private int port;
    private String ip;
    private Scanner scanner;
    // 1.53 – вот клиентская программа знает порт и Ip сервера.

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }


    public void start() throws Exception { // 1.62 - получается. что когда у клиента вызывается метод start, сканер получает значение из консольки и запускает бесконечный цикл
        System.out.println("Введите имя/команду");
        String name = scanner.nextLine();
        String messageText;

        while (true){
            // exit
            // ping
            System.out.println("Введите сообщение");  // 1.63 - просит ввести сообщение
            messageText = scanner.nextLine();

            sendAndPrintMessage(SimpleMessage.getMessage(name, messageText)); // 1.64 - после ввода сообщения запускается вот этот метод sendAndPrintMessage
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){ // 1.64 - здесь клиенская сторона устанавливает соединение с сервером, по getSocket() соединению, // getSocket Только для того, чтобы посмотреть методы сокета

            LocalDateTime time = null;
            if (message.getText().equalsIgnoreCase("ping")) {
                time = LocalDateTime.now();
            }
            connection.sendMessage(message); // 1.65 - после того как соединение установленно клиенская сторона отправляет сообщение серверу,

            SimpleMessage formServer = connection.readMessage(); // 1.66 - другая программа фармирует собственное сообщение и отправляет его клиенту
            if (formServer.getText().equalsIgnoreCase("ping")) {
                String str = "ping: " + Duration.between(time, LocalDateTime.now()).getNano();
            }


            System.out.println("ответ от сервера: " + formServer);  // 1.67 - и на клиенте получаем то сообщение которое присла сервер. После этого соединение закрывается или другой клиент не сможет подсоединится. -> EchoServer
        }
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }
    // 1.54 – что бы клиенская программа могла установить соединение и воспользоваться tcp протоколом она должна использовать объект типа socket (они для подключения). -> Connection

    public static void main(String[] args) {
        int port = 8090;
        String ip = "127.0.0.1";

        try {
            new Client(port, ip).start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void execute() {

    }
}
