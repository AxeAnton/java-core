package ru.itmo.lessons.lessons22.observer;

public class Application {
    public static void main(String[] args) { // �����������:
        // ����������� �����������, ����������� �� ��������� �����������.

        // ����� Sensor ��������/�������� ����������� �� 40, � �� ������
        // ��������� ����������� ��������� ���������� (�����������):
        // - ������ ���������� (green) ��������� �� ����������� 100 � ����;
        // - ������ ���������� (yellow) ��������� �� ����������� 300 � ����;
        // - ������ ���������� (red) ��������� �� ����������� 600 � ����.

        // ������� ����������� - ����� � ������� ����������� �
        // �������� �����������.

        // ���� ���������� ��������, �� ��������� �� ����������� ���
        // ���������� ��������� ����������. �� ���� �����������
        // ��������� ���� ���������� ������ ����������� � �����
        // ������ �����������, ���������� ����� ������ �������������.

        Controller green = new Controller("green", 100); //17. ������� ������� ������������
        Controller yellow = new Controller("yellow", 300);
        Controller red = new Controller("red", 600);

        Sensor sensor = new Sensor();//18. ������� ������
        sensor.addListener(green); //19. ��������� �����������
        sensor.addListener(yellow);
        sensor.addListener(red);

        for (int i = 0; i < 700; i++) { //20. ����������� ��� �������
            sensor.changeState();
        }
    }
}