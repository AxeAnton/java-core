package ru.itmo.lessons.lesson11.enums;

// enum может создаваться со свойствами, конструктором, методами
// можно не ставить ; поле последнего элемента перечисления,
// если в перечислении больше ничего нет.
public enum Priority {
    HIGH(10), MIDDLE(5), LOW(1);
    private int code;

    Priority(int code) {
        this.code = code;
    }
    // методы доступны всем элементам перечисления согласно модификаторам
    // доступа
    public void setCode(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    @Override
    public String toString() {
        return "Priority{" +
                "code=" + code +
                '}';
    }
}
