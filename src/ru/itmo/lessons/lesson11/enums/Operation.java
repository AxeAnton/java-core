package ru.itmo.lessons.lesson11.enums;

// каждый элемент перечисления может иметь собственную
// реализацию метода
public enum Operation {
    SUM {
        @Override
        public int action(int a, int b) {
            some();
            return a + b;
        }

        public void some(){
            System.out.println("some");
        }
    },
    MULTI {
        @Override
        public int action(int a, int b) {
            return a * b;
        }
    };

    public abstract int action(int a, int b);
}
