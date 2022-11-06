package ru.itmo.lessons.lesson7_8;

import ru.itmo.lessons.lesson7_8.base.AttackAble;
import ru.itmo.lessons.lesson7_8.base.BattleUnit;

// 2.23 - аналогично Knight имплементируем интерфейс AttackAble и переопределяем метод
/* 2.27 - implements AttackAble - переносим в BattleUnit (но почемуто оставляем переопределенный метод!) - > Knight 2.28  */
public final class Infantry extends BattleUnit /*implements AttackAble */{ // 1.23 - аналогично Knight
    // FIXME 2.10 - final свойсва нельзя изменить, значение можно задать только при объявлении или через конструктор, но не в сеттерах и тп -> Unit 2.11
    private final int additionalAttack = 5;

    public Infantry(int healthScore, int attackScore) {
        super(healthScore, attackScore);
    } // 1.24 - аналогично Knight -> King

    public void infantryVoid(){
        System.out.println("Метод Method infantryVoid");
    } // 1.30 - метод пехотинца, зачем смотри App. пункт 1.28. -> Knight

    // 2.4 - FIXME При переопределении или при собственной реализации родительского метода имя, ТД и аргумент, как у родитемя, модификатор доступа может быть выше НО НЕ ниже!
    @Override // FIXME 2.6 - Возможно использовать анатацию @Override - помогает с написанием метода!
    public boolean runFromField() { // FIXME 2.7 - еще о родительским методах, их можно вызвать везде добавив слова super.имяМетода -> Knight
        if (super.runFromField()) { // FIXME 2.5 -  полное выполнение инструкций родителя (super.runFromField()) + ниже добавляем то то свое.
            attackScore -= 3;
            System.out.println("После бегства атака уменьшена на 3");
            return true;
        }
        return false;
    }

    // 2.14 - аналогично прописываем абстрактный класс ->  App 2.15
    @Override
    public void rest() {
        plusHealth(1);
        System.out.println("Отдых пехотинца");
    }

    // 2.24 - реализация метода -> App 2.25
    @Override
    public void attack(BattleUnit enemy) {
        if (enemy.isAlive() && this.isAlive())enemy.minusHealth(attackScore);
        if (enemy.isAlive()) this.minusHealth(enemy.getAttackScore());
        if (this.isAlive()) enemy.minusHealth(additionalAttack);
    }
}
