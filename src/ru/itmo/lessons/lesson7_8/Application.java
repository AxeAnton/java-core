package ru.itmo.lessons.lesson7_8;

import ru.itmo.lessons.lesson7_8.base.BattleUnit;
import ru.itmo.lessons.lesson7_8.base.Unit;

import java.util.Scanner;

// public class King extends Unit
// public class Knight extends BattleUnit (ext Unit)
// public class Infantry extends BattleUnit (ext Unit)
public class Application {
    public static void main(String[] args) {
        Knight knight1 = new Knight(20, 17); // 1.28 - FIXME создаем объект Knight указываем здоровье и атаку, и что бы потренироваться добавляем в класс battleUnit метод battleUnitVoid + похожий метод в Infantry и в Knight потом возвращаемся назад. Это все делаем, что бы понять КАКИЕ методы можем вызвать, а какие нет.
        knight1.knightVoid(); // 1.32 - FIXME т.к ТД объекта Knight ото мы можем вызвать методы, Knight + Unit + ButtelUnit.
        knight1.runFromField();// 2.3.1 - вызов метода runFromField- бегство с поля

        BattleUnit knight2 = new Knight(20, 17); // 1.33 - FIXME т.к Knight ext. BattleUnit то объекты Knight, могут иметь ТД BattleUnit
        knight2.battleUnitVoid(); // 1.34 - FIXME т.к ТД объекта BattleUnit ото мы можем вызвать методы, Unit + ButtelUnit Но не Knight.

        Unit knight3 = new Knight(20, 17); // 1.34 - аналогичная история 1.28; 1.32; 1.33 и 1.34
        knight3.plusHealth(20); // 1.35 - аналогичная история 1.28; 1.32; 1.33 и 1.34
        // 1.36 - FIXME интерестный момент, объект knight3 с ТД  Unit можем изменить на Knight  + ButtelUnit и тогда появятся методы двнных слассов.
        // 1.37 - FIXME вот в такой массив можем добавить ссылки BattleUnit[] battleUnit = {knight1, knight2} НО не три - knight3!

        Infantry infantry1 = new Infantry(18, 15); // 2.2 создаем пихотинца и вызываем метод runFromField
        infantry1.runFromField(); // 2.3.2 - допустим захотели переопределить метод родителя ->Infantry

        King king1 = new King(100);
        King king2 = new King(100);

        king1.generateArmy();
        king2.generateArmy();

        king1.startBattle(king2);

        System.out.println("king1 " + king1.getBattleUnitsCount());
        System.out.println("king2 " + king2.getBattleUnitsCount());

        // 2.15 FIXME Данный блок, будет перемещен в другой класс, что здесь важно, создаем персонажей, а потом можем пачкой у всех вызвать метод rest!
        // 2.16 FIXME этот блок ПОЛИМОРФИЗМ наследования, то ли рыцарь, то ли пехота, поли король -> AttackAble 2.17
        Scanner in = new Scanner(System.in);
        System.out.println("Введите тип персонажа");
        String type = in.nextLine();
        Unit unit = null;
        if (type.equalsIgnoreCase("knight")) {
            unit = new Knight(23, 56);
        } else if (type.equalsIgnoreCase("infantry")) {
            unit = new Infantry(23, 56);
        } else if (type.equalsIgnoreCase("king")) {
            unit = new King(4);
        }
        unit.rest();

        // 2.25 - FIXME реализация переопределенных методов ИНТЕРФЕЙСА с боевыми юинтами BattleUnit.
        //  2.26 - Вообщем здесь что то накасячели и implements надо убрать у Knight и Infantry (но почему то оставили переопределенные методы!!!) + implements добавляем в BattleUnit (это связано с тем, что в аргументе метода интерфейса указан BattleUnit)  -> Infantry 2.27
        System.out.println("Укажите тип боевого юнита");
        String btype = in.nextLine();
        BattleUnit battleUnit = null;
        if (type.equalsIgnoreCase("knight")) {
            battleUnit = new Knight(23, 56);
        } else {
            battleUnit = new Infantry(23, 56);
        }
        battleUnit.attack(knight1);
        //  2.30 - вообще теперь можем натравить кого то (например knight1), на всех battleUnit

        //  2.31 - FIXME - СТАТИЧЕСКИЕ МЕТОДЫ, это методы которые не требуют вызова ОБЪЕКТА, например в задачи короля не входит необходимость создавать армию (ему нужна уже армия), поэтому создаем статический метод в -> BattleUnit.
        // Math.max();
    }
}
