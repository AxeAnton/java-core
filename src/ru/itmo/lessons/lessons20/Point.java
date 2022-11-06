package ru.itmo.lessons.lessons20;

import java.io.*;
import java.util.Objects;

public class Point implements Externalizable /*Serializable*/  { // NB Externalizable метод заставляет реализовать два метода (чтения и запись) + конструктор без параметров. Необходим для записи, чтения, но в отличии от Serializable, необходимо пометить, что необходимо обработать.
    @Serial // анатация подсказка контроля записи serialVersionUID, а она необходима для игнорирования версии файла и его дубликата, при всех нестыковках будет значение по умолчанию, ноль или Null.
    private static final long serialVersionUID = 1L; //обязательно нужен, для Серлиаризации, 1l это его название, может быть любым.
    private int x;
    private int y;

    public Point() {}

    public Point(int x, int y) {
        setX(x);
        setY(y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }


    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override // переопределение для Externalizable
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeInt(x);
        out.writeInt(y);
    }

    @Override // переопределение для Externalizable
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        x = in.readInt();
        y = in.readInt();
    }
}