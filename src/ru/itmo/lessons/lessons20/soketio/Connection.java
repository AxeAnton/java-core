package ru.itmo.lessons.lessons20.soketio;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Connection implements AutoCloseable {
// 1.55 - ��� ����������, ��� � �����, ��� � � ������ ������� ����������� ��� ���� �������. AutoCloseable,������� � ��� ��� ����� ������������ try � ���������.
    private Socket socket; // 1.56 - ���� socket, �� ���������, ��� � �����, ��� � � ������ �������.
    private ObjectInputStream input; // 1.57 - ���������, ��� �� ������ ������ ������ ���������
    private ObjectOutputStream output;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        output = new ObjectOutputStream(this.socket.getOutputStream()); // 1.58 - ����������, ��� ����� ���� ��� ���������� ��������������� (this.socket..., ������ �������� ������� �� � ����, � � ��� tOutputStream() �����. �� � �������������� ObjectOutputStream ����� ������������� �����.
        input = new ObjectInputStream(this.socket.getInputStream()); // 1.61 - ���� ��� �������� �����, �� ���� ������� �� ���������� (this.socket), �.� � ������, �� �������� �������� ����� .getInputStream()
    }
    // 1.62 - ����� ��� �������� ���������� ��������� ������������������: ������� ����� - �����, ����� ��������� ����� - ObjectOutputStream � � ����� �������� ����� - ObjectInputStream. -> Client

    public void sendMessage(SimpleMessage message) throws IOException {
        message.setDateTime();
        output.writeObject(message); // 1.59 - �������������� getOutputStream(... ������� ����������� SimpleMessage.java ������� ���������� � ������������������ ���� � ����� ��� ������������������ ����� �� tOutputStream(). ������ �� ����� ��������� ����� � ������ ���������, ����� ��������� ������.
        output.flush(); // 1.60 - ����� ���� ������ ���������� �� � �������, � �� ��������� � ���������, �� ����� flush ������ ���� ������ ����������� ��� ������ ��������� � ������ � �� ������.
    }

    public SimpleMessage readMessage() throws IOException, ClassNotFoundException {
        return (SimpleMessage) input.readObject();
    }
    // 1.61 - ���������� ������ ObjectInputStream ����������� � ��� SimpleMessage � �� �������� �� ��������� ������� ������.

    @Override
    public void close() throws Exception {
        input.close();
        output.close();
        socket.close();
    }
}
