package ru.itmo.lessons.lessons36.reflection;


import java.time.LocalDateTime;

public class Message implements Comparable<Message>{ // 1. класс implements Comparable<Message> (для сравнения)
    private String sender;
    private LocalDateTime sent;

    // 6 у Message так же есть конструктор, который принимает на вход отправителя
    public Message(String sender) {
        this.sender = sender;
        setSent();
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public LocalDateTime getSent() {
        return sent;
    }

    public void setSent() {
        this.sent = LocalDateTime.now();
    }

    @Override
    public int compareTo(Message o) {
        return sent.compareTo(o.sent);
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", sent=" + sent +
                '}';
    }
}
