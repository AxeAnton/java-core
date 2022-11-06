package ru.itmo.lessons.lessons21.patterns.decorator;

public abstract class BaseDecorator implements LogStrategy { //4.родительский декоратор
    private LogStrategy logger; //5. свойство должно быть - интерфейс

    public BaseDecorator(LogStrategy logger) {
        this.logger = logger; // 3. Декораторы в конструктор принимают ТД ИНТЕРФЕЙСА (LogStrategy).
    }

    @Override
    public void log(String data) { //15. его метод log берет данные и передает  logger, который передовался в конструктор. А так как (как пример) передовался loger FileLogging (см. 11 пункт) соотведственно метод log будет вызываться у FileLogging.
        logger.log(data);
    }
}


// 1. Все декараторы наследуются от базового декаратора!
// 2. Базовый декоратор и класс с основным функционалом должны имплементировать один и тот ж