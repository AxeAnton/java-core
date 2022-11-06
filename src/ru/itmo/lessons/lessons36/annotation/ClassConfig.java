package ru.itmo.lessons.lessons36.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // аннотировать можно только классы
@Retention(RetentionPolicy.RUNTIME)
// 48. аннотации могут быть без параметров п 48.1 и с параметрами (круглые скобки) п. 48.2
public @interface ClassConfig { // 54. Если у класса есть аннотация СlassConfig, значит экземпляр этого класса должен быть создан через рефлексию (1. создать объект класса, 2х установить значения каких то свойств, 3е п.55
    // 49. Перечисление параметров аннотации - в качестве параметров можно использовать: строки, примитивы, enum (перечисления), другие ТД нельзя.
    String prefix(); // 50. обязательно указать ТД при использовании параметра
    // 51. Если значение параметра по умолчанию - default "config.properties";, то его можно не указывать в круглых скобках (т.е в параметрах(аргументе аннотации)) п.48.3 или 48.5
    String configFile() default "config.properties"; // 56. configFile() у меня отсутствует почему то, но вообще он выглядит как то так - test.name = some date /n, cat.name = Tome /n, cat.age = 1 /n, mouse.colore = white /n, mause.name = Jarry /n, необходимая инфо выбирается по классу.прификсу (например: cat.name = Tome и cat.Age = 1), что с ними дальше делать, пока,  не понял.
    long version() default 1; // 52. так же можно менять значение параметра по умолчанию п. 48.2 и 48.3

}
// 48.0-5
// 48.1 @Entity - без параметров
// 48.2 @Table(prefix = "имя", configFile = "file.text", version = 2) - с параметрами т.к. кругллые скобки
// 48.3 @Table(prefix = "имя", version = 2)
// 48.4 @Table(prefix = "имя", configFile = "file.text")
// 48.5 @Table(prefix = "имя")