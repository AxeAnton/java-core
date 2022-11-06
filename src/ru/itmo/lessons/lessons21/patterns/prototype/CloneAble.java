package ru.itmo.lessons.lessons21.patterns.prototype;

interface CloneAble {
    Object clon();
    // 38. В данном случаи у класса Object уже есть метод clon (он просто уже существует в языке).
    // 40. А вот если бы его не было, то необходимо было бы создать его,
}

class A implements CloneAble {

    @Override
    public Object clon() {
        return null;
        // 39. теперь сы просто вызываем его (метод clon).
        // 41. и прописать логику экземпляров классов, как обычно делаем при имплементации интерфейсов.
    }
}
