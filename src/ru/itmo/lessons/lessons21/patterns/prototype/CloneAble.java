package ru.itmo.lessons.lessons21.patterns.prototype;

interface CloneAble {
    Object clon();
    // 38. � ������ ������ � ������ Object ��� ���� ����� clon (�� ������ ��� ���������� � �����).
    // 40. � ��� ���� �� ��� �� ����, �� ���������� ���� �� ������� ���,
}

class A implements CloneAble {

    @Override
    public Object clon() {
        return null;
        // 39. ������ �� ������ �������� ��� (����� clon).
        // 41. � ��������� ������ ����������� �������, ��� ������ ������ ��� ������������� �����������.
    }
}
