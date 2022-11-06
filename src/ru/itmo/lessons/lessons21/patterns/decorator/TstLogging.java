package ru.itmo.lessons.lessons21.patterns.decorator;

public class TstLogging {
    public static void main(String[] args) {
        ClassInProgram inProgram = new ClassInProgram(new ConsoleLogging());
        inProgram.action();

        inProgram.setStrategy(new DateDecorator(new FileLogging()));
        inProgram.action();

        inProgram.setStrategy(new DateDecorator(new CodeDecorator(new ConsoleLogging())));
        inProgram.action();

        //11. это расписали то что 8й строке написано, только здесь вместо FileLogging - ConsoleLogging.
        LogStrategy consol = new FileLogging(); //13. основной функционал выводит в консоль
        LogStrategy code = new CodeDecorator(consol); //12.  CodeDecorator декарирует(прибовляет номер) затем передаются, через аргумент в основной функционал - consol.
        LogStrategy log = new DateDecorator(code);// 11.  декарируются DateDecorator (прибовляет дату), затем передаются CodeDecorator, через аргумент.
        log.log("данные"); // 10. сначала данные которые необходимо поместить в файл


    }
}

