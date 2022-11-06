package ru.itmo.lessons.lesson7_8.base;


import ru.itmo.lessons.lesson7_8.Infantry;
import ru.itmo.lessons.lesson7_8.Knight;

// 2.29 - добавляем implements AttackAble -> App 2.30
abstract public class BattleUnit extends Unit implements AttackAble {
    //  1.12 - FIXME class BattleUnit - наследуется от класса Unit, то есть BattleUnit получил все методы и свойства класса Unit, а доступ согласно модификаторам доступа (МД), privet не катит все остальное ок.
    //  1.13 -Unit - родительский класс или супер класс
    //  1.14 -BattleUnit - дочерний класс
    //  1.15 -BattleUnit наследуется от класса Unit

    protected int attackScore; // 1.16 - свойство атаки.

    public BattleUnit(int healthScore, int attackScore) { // 1.18 - а еще в аргументе необходимо передать свойство родителя + текущее всвойство класса.
        super(healthScore);
        // 1.17 - FIXME В конструкторе BattleUnit ОБЯЗАТЕЛЬНО необходимо вызвать конструктор родителя через super и передать ему его свойство - healthScore
        if (attackScore < 1) {
            throw new IllegalArgumentException(" The attack must be positive \n Атака дб положительной");
        }
        this.attackScore = attackScore;
    }

    public int getAttackScore() {
        return attackScore;
    } // 1.19 - геттер -> knight

    //  FIXME 2.9 - ПЕРЕОПРЕДЕЛЯТЬ final метод нельзя -> Infantry
    public final void battleUnitVoid() {
        System.out.println("Метод Method BattleUnit");
    } // 1.29 - создаем метод  battleUnit + создаем аналогичный метод в пихоте -> infantry

    // 2.1 Метод - все BattleUnit могут сбежат с поля боя и потеряет 1 ед. здоровья. -> App
    public boolean runFromField() {
        if (!isAlive()) { // а) если умер то все
            System.out.println("Юнит не может сбежать / The unit cannot leave");
            return false;
        }
        healthScore -= 1; // б) если живой отнимает ед. здоровья
        if (!isAlive()) { // в) и еще раз проверяем на живость
            System.out.println("Юнит не смог сбежать");
            return false;
        } else { // г) если живой в консоль инфо
            System.out.println("После бегства здоровье уменьшена на 1 / After leaving the health is reduced by 1");
            return true;
        }

    }

    // 2.32 - FIXME фабричные методы - создает экземпляры BattleUnit
    public static BattleUnit getBattleUnit() {
        String[] types = {"knight", "infantry"}; // 2.33 - массив типов BattleUnit
        BattleUnit unit = null; // 2.34 - проверка на null, будущих экземпляров
        int randomIndex = (int) (Math.random() * types.length); // 2.35 - рандомный выбор типов BattleUnit
        switch (types[randomIndex]) {
            case "knight": // 2.36 - если knight создаем knight
                unit = new Knight(30, 18);
                break;
            case "infantry": // 2.37 - если Infantry создаем Infantry
                unit = new Infantry(35, 20);
                break;
        }
        return unit;  // 2.37 - возвращаем ссылку на объект
    }

    public static BattleUnit[] getBattleUnits(int count) { // 2.38 - загоняем ссылки на объекты BattleUnit в массив. В статических методах можно обратиться, только к статическим методам или свойствам - King 2.39
        BattleUnit[] units = new BattleUnit[count];
        for (int i = 0; i < units.length; i++) {

            units[i] = getBattleUnit();
        }
        return units;
    }
}

