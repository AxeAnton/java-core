package ru.itmo.lessons.lessons21.patterns.observer;

import java.util.Scanner;


public class TstListener {
    public static void main(String[] args) {

        EventListener firstListener = new EventListener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("реакция firstListener на " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("реакция firstListener на " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("реакция firstListener на " + code);
            }

        };

        EventListener secondListener = new EventListener() {
            @Override
            public void greenEvent(int code) {
                System.out.println("реакция secondListener на " + code);
            }

            @Override
            public void yellowEvent(int code) {
                System.out.println("реакция secondListener на " + code);
            }

            @Override
            public void redEvent(int code) {
                System.out.println("реакция secondListener на " + code);
            }
        };

        StateClass stateClass = new StateClass();
        stateClass.addListener(firstListener);
        stateClass.addListener(secondListener);

        Scanner scanner = new Scanner(System.in);
        String s;
        while (true){
            System.out.println("Введите статус");
            s = scanner.nextLine();
            if ("exit".equals(s)) break;
            stateClass.changeState(s);
        }
    }
}
