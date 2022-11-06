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
        try (ServerSocket serverSocket = new ServerSocket(port)){     // 1.68 - ��������� ���������, ���: ��� ������� ��������� ��������� ������ ServerSocket, �� ��������� ��������� �� ��������� ����� (port) � ���� �����������,
            System.out.println("Server started...");
            while (true){  // 1.69 - � ����������� ����� ��������� ������� �������� ����� �������,
                Socket socket = serverSocket.accept(); // 1.70 - ��� ������ �������� ������, ��������������� ���������� (�����) ����� �������� � ��������,
                connection = new Connection(socket); // 1.71 - ��������� ������� ������ ��������� ������� ������ �� �������,
               printMessage(connection.readMessage()); // ��, ���� � readMessage, ������ ������� �� ���������� ��������������� �����.
               connection.sendMessage(SimpleMessage.getMessage("server", "���������")); // 1.72 - ��������� ���� ��������� � ���������� ������� �������
                // count += 1;

                //SimpleMessage message = connection.readMessage();

            }
        }
    }

    // 1.73 - ������, ������� run ��� �������, ����� ��� �������. ����� ���������� ��������� ��������, ��� ����� ���������� ��� � ���� ������� ������� Modify Run Configuratio -> modify options -> ��� ��� ������� (��������� ������������� ������). -> ��� ����� ��

    private void printMessage(SimpleMessage message){
        System.out.println("�������� ���������: " + message);
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
