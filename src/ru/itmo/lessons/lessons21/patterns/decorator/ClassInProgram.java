package ru.itmo.lessons.lessons21.patterns.decorator;

public class ClassInProgram {
    private LogStrategy strategy;

    public ClassInProgram(LogStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(LogStrategy strategy) {
        this.strategy = strategy;
    }

    public void action(){
        strategy.log("Логирование действия");
    }
}
