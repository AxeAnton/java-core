package ru.itmo.lessons.lesson7_8.base;

// ru.itmo.lessons.lesson7.base.Unit
// 1.1 - FIXME родительский класс всех персонажей, он abstract, то есть нельзя создать экземпляр класса!
// нельзя создать экземпляр
// может содержать абстрактные методы
abstract public class Unit {
    /* 1.2 - доступ к свойству из текущего класса + дочерних классов */
    protected int healthScore;
    private int maxHealthScore; //1.7 - переменная для максимального здоровья!
    // 1.3 - конструктор
    public Unit(int healthScore){
        if (healthScore < 1) {
            throw new IllegalArgumentException("Здоровье дб положительным");
        }
        this.healthScore = healthScore;  // 1.4 - для текущего объекта - this.healthScore значение healthScore должно быть равно значению переданого в конструктора
        maxHealthScore = healthScore; //1.8 - органичение по максимальному здоровью!
    }
    // 1.11 - геттор -> BattleUnit
    public int getHealthScore(){
        return healthScore;
    }

    // 1.9 - увеличить здоровье на healthScore, но не больше изначального, если персонаж жив
    public void plusHealth(int healthScore){
        if (!isAlive()) return; // 1.9 - не жив значит прерываем метод.
        this.healthScore =
                Math.min(this.healthScore + healthScore, maxHealthScore);
        // 1.10 -  FIXME МЕетод - Math.min - объяснение присваиваем персонажу текущее здоровье this.healthScore + переданое в аргумент healthScore и если оно больше максимального maxHealthScore, то метод Math.min - возвращает maxHealthScore.
    }
    // 1.6 - уменьшить здоровье на healthScore, если персонаж жив, если не жив - !isAlive(), то прерываем метод.
    public void minusHealth(int healthScore){
        if (!isAlive()) return;
        this.healthScore -= healthScore;
    }
    //  1.5 - проверка жив или нет. Метод вернет true, если здоровье больше 0, false, если нет
    public boolean isAlive() {
        return healthScore > 0;
    }

    // 2.11 - FIXME "АБСТРАКТНЫЙ метод". У всех юнитов должен быть метод rest но реализован он должен быть по разному. Для этого неодходимо исполтзовать АБСТРАКТНЫЙ метод, абстрактный метод - метод без реализации (без {}) -> King 2.12
    public abstract void rest();
}
