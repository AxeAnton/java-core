package ru.itmo.lessons.lesson7_8;

import ru.itmo.lessons.lesson7_8.base.AttackAble;
import ru.itmo.lessons.lesson7_8.base.BattleUnit;
import ru.itmo.lessons.lesson7_8.base.Unit;
/* ... extends King */


public final class King extends Unit {
    // 1.24 - наследование extends от Unit
    private int gold = 500; // 1.26 - золото короля
    private BattleUnit[] army;
    // 1.27 - FIXME армия боевых юнитов это массив и имеет ТИП ДАННЫ BattleUnit, т.к армия короля состоит из пехоты и рыцарей, которые входят в BattleUnit. потренируемся с объектами -> Application

    public King(int healthScore){
        super(healthScore);
    } // 1.25 - конструктор от Unit

    // увеличивает золото на count, нет ограничений по максимуму
    public void plusGold(int count){
        gold += count;
    }

    // уменьшает золото на count
    public void minusGold(int count) {
        if (gold < count) return; // если золота у короля меньше count, уменьшения не происходит
        gold -= count;
    }

    // заменяет погибших юнитов новыми

    // 2.39 - FIXME Генерация армии
    public void generateArmy(){ // 250
        if (gold < 250) {
            System.out.println("Стоимость армии 250. У короля " + gold);
            return;
        }
        gold -= 250;
        army = BattleUnit.getBattleUnits(20); // 2.40 - "20" - количество юнитов
    }
    public void changeUnits(){   // 2.40 - FIXME  заменяет погибших юнитов
        /*if (gold < 20) {
            System.out.println("Стоимость одного юнита 20. У короля" + gold);
            return;
        }*/
        for (int i = 0; i < army.length; i++) {
            if (gold < 20) { // 2.40 - проверяем есть ли золото хотя бы на одного юнита
                System.out.println("Стоимость одного юнита 20. У короля" + gold);
                return;
            }
            // 2.41 - идем по армии, элемент масива не null и он не жив, заменяем на юнита.
            if (army[i] != null && !army[i].isAlive()) {
                gold -= 20;
                army[i] = BattleUnit.getBattleUnit();
            }
        }
    }

    public void startBattle(King enemy){  // 2.41 - метод битв армий короля
        // iter
        /* for (BattleUnit battleUnit : army) { } */
        for (int i = 0; i < army.length; i++) {
            int unitIndex = (int) (Math.random() * army.length);
            int enemyUnitIndex = (int) (Math.random() * enemy.army.length);
            army[unitIndex].attack(enemy.army[enemyUnitIndex]); // 2.42 - атака рандомного юнита на юнит из армии врага, затем отдых
            army[unitIndex].rest();
            enemy.army[enemyUnitIndex].rest();
        }
    }

    // 2.43 - проверяет количество живых юнитов в армии возвращает количество - return count; (ВСЕ!)
    public int getBattleUnitsCount() {
        int count = 0;
        for (BattleUnit battleUnit : army) {
            if (battleUnit.isAlive()) count += 1;
        }
        return count;
    }
    // 2.12 - FIXME реализация абстрактного метода, так же можно @Override -> Knight 2.13
    @Override
    public void rest(){
        // minusGold(50);
        gold -= 50;
        plusHealth(5);
        System.out.println("Отдых короля");
    }
}

