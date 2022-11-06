package ru.itmo.lessons.lesson7_8;

import ru.itmo.lessons.lesson7_8.base.AttackAble;
import ru.itmo.lessons.lesson7_8.base.BattleUnit;
// 1.20 - FIXME т.к Knight в другом пакете, то для имплементации необходимо импортировать BattleUnit
// Рыцарь
// здоровье
// очкиАтаки ++
// дополнительноеЗдоровье
// 2.21 - FIXME реализация ИНТЕРФЕЙСА, добавляем (имплементирует) implements BattleUnit в класс Knight, можно реализовывать несколько интерфейсов implements Int1, Int2, Int3

// 2.28 - implements AttackAble - переносим в BattleUnit (но почему то оставляем переопределенный метод!) -> BattleUnit 2.29
public final class Knight extends BattleUnit implements AttackAble { // FIXME 2.8 - если есть жесткое требование, что от класса нельзя иметь наследников, то можно добавить final и тогда наследование будет НЕ ВОЗМОЖНО! -> BattleUnit
    private final int additionalHealth = 10; // 1.21 - доп.здоровье 10 для рыцарей.

    public Knight(int healthScore, int attackScore) {
        super(healthScore, attackScore); // 1.22 - FIXME в конструктор передаем свойства от родительского BattleUnit и бабушкиного Unit -> Infantry
    }

    public void knightVoid() {
        System.out.println("Метод Method knightVoid");
    } // 1.31 - метод рыцаря, зачем смотри App. пункт 1.28. -> App.

    // 2.13 - FIXME Так же можно переопределить метод пкм и выбираем @Override method и далее выбираем метод который хотим переопределить.-> Infantry 2.14
    @Override
    public void rest() {
        plusHealth(3);
        System.out.println("Отдых рыцаря");
    }

    // 2.22 - FIXME пкм @Override => выбрали метод и реализовали -> Infantry
    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive() && this.isAlive()) enemy.minusHealth(attackScore);
        if (enemy.isAlive()) this.minusHealth(enemy.getAttackScore());
        if (this.isAlive()) this.plusHealth((int) (Math.random() * additionalHealth));
    }
}
