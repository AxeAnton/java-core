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
    // 1.53 � ��� ���������� ��������� ����� ���� � Ip �������.

    public Client(int port, String ip) {
        this.port = port;
        this.ip = ip;
        scanner = new Scanner(System.in);
    }


    public void start() throws Exception { // 1.62 - ����������. ��� ����� � ������� ���������� ����� start, ������ �������� �������� �� ��������� � ��������� ����������� ����
        System.out.println("������� ���/�������");
        String name = scanner.nextLine();
        String messageText;

        while (true){
            // exit
            // ping
            System.out.println("������� ���������");  // 1.63 - ������ ������ ���������
            messageText = scanner.nextLine();

            sendAndPrintMessage(SimpleMessage.getMessage(name, messageText)); // 1.64 - ����� ����� ��������� ����������� ��� ���� ����� sendAndPrintMessage
        }
    }

    private void sendAndPrintMessage(SimpleMessage message) throws Exception {
        try (Connection connection = new Connection(getSocket())){ // 1.64 - ����� ��������� ������� ������������� ���������� � ��������, �� getSocket() ����������, // getSocket ������ ��� ����, ����� ���������� ������ ������

            LocalDateTime time = null;
            if (message.getText().equalsIgnoreCase("ping")) {
                time = LocalDateTime.now();
            }
            connection.sendMessage(message); // 1.65 - ����� ���� ��� ���������� ������������ ��������� ������� ���������� ��������� �������,

            SimpleMessage formServer = connection.readMessage(); // 1.66 - ������ ��������� ��������� ����������� ��������� � ���������� ��� �������
            if (formServer.getText().equalsIgnoreCase("ping")) {
                String str = "ping: " + Duration.between(time, LocalDateTime.now()).getNano();
            }


            System.out.println("����� �� �������: " + formServer);  // 1.67 - � �� ������� �������� �� ��������� ������� ������ ������. ����� ����� ���������� ����������� ��� ������ ������ �� ������ �������������. -> EchoServer
        }
    }

    private Socket getSocket() throws IOException {
        Socket socket = new Socket(ip, port);
        return socket;
    }
    // 1.54 � ��� �� ��������� ��������� ����� ���������� ���������� � ��������������� tcp ���������� ��� ������ ������������ ������ ���� socket (��� ��� �����������). -> Connection

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
