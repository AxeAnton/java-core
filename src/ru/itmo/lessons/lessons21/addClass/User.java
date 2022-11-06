package ru.itmo.lessons.lessons21.addClass;

public class User { // 1. паблик класс один в его имя = названию класса

    private Level level; //2. Если Level нужен только этому классу то можно enum Level расположить внутри класса. Если Level из разных классов одно и тоже то enum Level выносим из класса.
    protected String login;

    @Override
    public String toString() {
        return "User{" +
                "level=" + level +
                ", login='" + login + '\'' +
                '}';
    }

/*
    public Level getLevel() {
        return level;
    }

    public String getLogin() {
        return login;
    }


*/


    public User(Level level, String login) {
        this.level = level;
        this.login = login;
    }

    // 5. внутренний класс и вложенииый класс это классы физически неходящиеся внутри другого класса.
    // NB 6. ВЛОЖЕНННЫЙ класс это тот перед который стоит STATIC.
    // NB 7. ВНУТРЕННИЙ класс, это тот перед которым нет слова STATIC.
    // 1. 8. область видимости - согласно модификаторам доступа.
    // NB 2. 9. нельзя создать объект внутреннего класса без  оздания объекта внешнего класса.
    public class Account{
        private  float balance;


        public Account(float balance) {
            // 1. область видимости таких классов согласно модификаторам доступа
            // 2. нельзя создать объект внутреннего класса без создания объекета внешнего класса.
            // 3. 10. ВНУТРЕННИЙ класс не может содержать статических методов и свойств, только если статическое свойство с модификаторам final ex. privet static finel int MAX_BALANCE = 500;
            this.balance = balance + User.this.level.getCount(); // 13. Из ВНУТРЕННЕГО класса возможен доступ к приватным методам и свойствам внешнего класса. По ыакту мы вызываем свойство Вложенного класса  level из ВРУТРЕННЕГО класса.
        }
    public User getUser(){
            // 11. Внутри ВНУТРЕННЕГО класса, можно получить доступ к экземпляру внешнего класса, обращаю внимание, что getor внешнего класса User, находится внутри ВЛОЖЕННОГО класса!
        return User.this; // 12. ссылка на экземпляр внешнего класса
    }

}



    public enum Level { // 3. вложенный класс (static класс). Логично создавать перечесление в существующем классе если перечесление относится к свойствам основного класса, если оно относится еще и к другим классам то лучше указать отдельно.

        HIGH(10), MEDIUN(5), LOW(0);
        // 4. доступ к перечеслению вне класса - согласно модификатору доступа: User.Level.элемент

        private int count;

        Level(int count) {
            this.count = count;
        }

        public int getCount() {
            return count;
        }



    }


}


