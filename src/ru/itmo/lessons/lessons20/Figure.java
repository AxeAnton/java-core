package ru.itmo.lessons.lessons20;


import java.io.Serializable;
import java.util.Arrays;

public class Figure implements Serializable {
    private final Point[] points;
    // transient исключения которые не нужны
    // transient свойства не участвуют в процессе сериализации
    transient public final String description = "Фигура, состоящая из точек";

    public Figure(int pointCount) {
        if (pointCount < 2) {
            throw new IllegalArgumentException("Фигура должна состоять," +
                    "минимум из 2 точек");
        }
        this.points = new Point[pointCount];
    }

    public Point[] getPoints() {
        return points;
    }

    public void addPoint(Point point){
        for (int i = 0; i < points.length; i++) {
            if (points[i] != null && points[i].equals(point)) {
                System.out.println("Точка " + point + "не была добавлена." +
                        "Можно добавлять только разные точки");
                return;
            }
            if (points[i] == null) {
                points[i] = point;
                System.out.println("Точка " + point + " была добавлена.");
                return;
            }
        }
        System.out.println("Точка " + point + "не была добавлена. " +
                "У фигуры достаточное количество точек.");
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Figure)) return false;
        Figure figure = (Figure) o;
        return Arrays.equals(points, figure.points);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(points);
    }

    @Override
    public String toString() {
        return "Figure{" +
                "points=" + Arrays.toString(points) +
                '}';
    }
}
