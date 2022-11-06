package ru.itmo.lessons.lessons36.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // 43. аннотировать можно только свойства класса
@Retention(RetentionPolicy.RUNTIME) // 46. когда аннотация будет доступна смотри п. 47
// 41. анатацию будет видно согласно модификаторам доступа public, СОЗДАНИЕ АННОТАЦИИ этот как создание интерфейса, только со знаком (собачка) @interface, имя анатации Required (правила как у классов), далее фигурные скобочки  {}
//42. Что еще нужно добавить при объявлении аннотации, необходимо чекрез существующую аннотацию @Target, добавить к своей аннотации для таго что бы сказать, что можно аннотировать (например: ElementType.FIELD, о стольное смотри п. 44).
public @interface Required { // 43 аннотация может быть пустая или иметь код или иметь свойства/параметры
}
