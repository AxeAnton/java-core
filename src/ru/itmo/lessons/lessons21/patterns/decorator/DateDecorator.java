package ru.itmo.lessons.lessons21.patterns.decorator;

import java.time.LocalDateTime;

public class DateDecorator extends BaseDecorator{
    public DateDecorator(LogStrategy logger) {
        super(logger);
    }

    @Override
    public void log(String data) {
        String newData = data + " date: " + LocalDateTime.now();// 14. метод log, данные пришли прибавили дату обратились к родителю (super) и вызвали его метод лог.
        super.log(newData); // log info 0.31058440874503557 date: 2019-12-18T20:11:30.438
    }
}