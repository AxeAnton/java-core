package ru.itmo.lessons.lessons36.reflection;

import java.lang.reflect.*;
import java.util.Arrays;

public class ReflectionLesson {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {
/*
        // 1. Reflection API - Это набор МЕТОДОВ который есть в языке они позволяют работать с классами свойствами, методами и конструкторами как с ОБЪЕКТАМИ.
        Если мы говорим про Reflection API, то мы предполагаем, сама конструкция класс в языке это ОБЪЕКТ (экземпляр ТИПА class)!!!, и на основе этого класса мы создаем все наши ЭКЗЕМПЛЯРЫ классы.
        Все свойства внутри класса являются объектами типа Field, все методы, геттоды, сетторы, переопределенные, не переопределенные, перегруженные полностью с модификаторами и типами возвращаемых значений принимаемыми аргументами и именем они являются экземплярами класса Field.
        Все метды являются экземплярами типа Method
        Все конструкторы являются объектами типа Constructor
        В связи с тем что все ОБЪЕКТЫ, следовательно, у них есть одинаковый набор методов и свойства.
*/

 /*
        // 2. Рефлексия в Java — это механизм, с помощью которого можно вносить изменения
        и получать информацию о классах, интерфейсах, полях и методах
        во время выполнения, при этом не зная имен этих классов, методов и полей.
        Кроме того, Reflection API дает возможность создавать новые экземпляры классов,
        вызывать методы, а также получать или устанавливать значения полей.
        Так же необходимо отметить, что весь сегодняшний синтез используется в runTime, то есть все действия предполагают действия на моменте выполнения. На моменте выполнения, что-то определяется, создается, динамически вызывается и т.д. И на этом принципе основано кучу библиотек включая ORM.
 */

/*        // 3. Что бы получить метод у класса нужно получить ссылку на класс, ее можно получить двумя способами:
         NB - ПЕРВЫЙ обратиться к классу по названию String поставить точку и написать слово class.  По факту String.class - ссылка на класс String не на экземпляр. Ссылка на класс присваивается переменной stringClass.
         Ссылка на класс позволяет обратиться к нему и узнать его свойства методы и т.д.
*/
        Class<String> stringClass = String.class;
        System.out.println("stringClass: " + stringClass);
        // 4. Причем ссылки можно получать и на класс int и на будые классы.
        Class<Integer> intClass = int.class;
        System.out.println("intClass: " + intClass);

        TextMessage textMessage = new TextMessage("qwerty"); // ссылка на класс int........
        textMessage.setText("Все классы в языке являются объектами");

        Class<TextMessage> textMessageClass = TextMessage.class;
        System.out.println("textMessageClass: " + textMessageClass);
        //5 NB - Второй вариант получить ссылку на класс, взять ссылку через объект, у каждого объекта есть метод getClass, метод getClass возвращает ссылку на класс ОБЪЕКТ, и это отличие от ПЕРВОГО варианта, так как там ссылка непосредственно на класс класса, но в итоге класс один и тот же!
        //6.  Class<? extends TextMessage> textMessageClass02 - класс textMessageClass02, может быть либо TextMessage либо любым из его наследников, почему? Потому что вот в этой строчке TextMessage textMessage = new TextMessage("qwerty");, вот этот new TextMessage, может иметь ТД TextMessage, а может быть и его наследник, Message или какойто другой (это как с ArryLisy, LinkList, вообщем какой то из List). по этому в джинереке знак ?
        Class<? extends TextMessage> textMessageClass02 = textMessage.getClass();
        System.out.println("textMessageClass02: " + textMessageClass02);

        // 7. После получения ссылки на класс (textMessageClass), можно получить: это имя пакета(getPackageName), имя пакета + имя класса (getName) и коротенькое имя класса (getSimpleName)
        System.out.println("имя пакета: " + textMessageClass.getPackageName());
        System.out.println("имя пакета + имя класса: " + textMessageClass.getName());
        System.out.println("имя класса: " + textMessageClass.getSimpleName());

        // 8. Так же имея ссылку на класс мы можем получить ссылки на интерфейсы класса, которые реализует класс (но не родителя) + имея ссылку на класс мы можем получить ссылку на родительский класс, затем на его родителя и так до Objecta. Т.к у класса может быть много интерфейсов, все интерфейсы собираются в массив [], ссылки на интерфейсы мы получаем по методу getInterfaces, методы родителя туда не входят и получить их нельзя.
        Class<?>[] interfaces = textMessageClass.getInterfaces();
        System.out.println("интерфейсы класса, без учета интерфейсов родителя: " + Arrays.toString(interfaces));

        // 9. Получение ссылки на родительский класс. У каждого класса может быть только один родитель, следовательно когда мы получаем ссылку на родителя это уже не мосив, а просто единственный экземпляр.
        // 10. Что бы получить ссылку мы обращаемся к ссылке на класс textMessageClass и вызываем метод getSuperclass и получим ссылку на его родителя.
        System.out.println("родительский класс [1]: " + textMessageClass.getSuperclass());
        System.out.println("родительский класс [2]: " + textMessageClass.getSuperclass().getSuperclass()); // 11. здесь запросили ссылку на класс родитеял родителя и получили - Object
        System.out.println("родительский класс [3]: " + textMessageClass.getSuperclass().getSuperclass().getSuperclass()); // 12. а если запросить ссылку на родителя Object получим - null, т.к у Object нет родителя

        // 13. Ну если надо получить ссылку на интерфейсы родительского класса, по получаем сначала интерфейс родительского класса textMessageClass.getSuperclass()., а затем вызываем метод получения интерфейса getInterfaces.
        System.out.println("интерфейсы родительского класса: " + Arrays.toString(textMessageClass.getSuperclass().getInterfaces()));

        // 14 просто, что бы был перед глазами переменной textMessageClass присваиваем ссылку на класс TextMessage.
        textMessageClass = TextMessage.class;

        // 15. В jave свойства так же называют методами и реже дистрибутивами.

/*
        // 16. Два варианта, получения ссылок всех полей поля класса. В любом случаи мы получаем массив типа Field:
         ПЕРВОЕ, получить поля класса с помощью getFields, возвращает ссылки на поля/свойства класса текущего и родительских классов имеющие модификатор доступа public!
         ВТОРОЕ, получить поля класса с помощью getDeclaredFields мы получаем массив со всеми полями и с любым модификатором (включая public, private, protected и packageprivate), но только текущего класса (если нужны свойства родителя то надо сначало получить ссылку на радителя, а потом вызывать метод, вроде как через цикл).
*/
        Field[] fields = textMessageClass.getFields();
        System.out.println("ссылки на public поля класса: " + Arrays.toString(fields));

        Field[] declaredFields = textMessageClass.getDeclaredFields();
        System.out.println("ссылки на поля класса: " + Arrays.toString(declaredFields));

        // 17. при переборе можно узнать имя, тип, модификаторы и значение каждого поля
        for (Field field : fields) { // 18 Перебирать можно не только fields, но и DeclaredFiel, для этого цикл необходимо подредактировать, что бы не упал с ошибкой (assessable). Необходимо добавить - fields.setAccessible(true);), в п. 21 тогда будет все ок.
            System.out.println("имя поля: " + field.getName());
            System.out.println("тип поля: " + field.getType());
            // 19 Можем проверить на наличие модификатора final (да и вообще любого) обращаемся к методу класс Modifier (возвращает true(есть модификатор) и false(нет модификатор) и в метод передаем все модификаторы поля, например если запросим Final - через данный метод .isFinal(field.getModifiers(), то получим true так, как он там есть.
            System.out.println("наличие модификатора final: " + Modifier.isFinal(field.getModifiers()));

            field.setAccessible(true);
            // 20. Получение значения свойства через рефлексию. Если свойство не статическое, то что бы узнать значение свойства нужен объект. fields.setAccessible(true);
            // 21 Получается, что сейчас мы работаем с filed (и его свойством code)если у поля field вызовем метод .get(textMessage) и передадим в него ОБЪЕКТ (теперь это объект) то получим ......, если у поля модификатор privet не позволяет то получим exeption, если перед эти мы вызовим fields.setAccessible(true); то можно получить значение поля для текущего объекта. Это тоже самое, что написать textMessage.code. Это не работает с privet модификаторам, упадет с ошибкой setAccessible, но если перед запросом написать field.setAccessible(true);, то получим и privet поля.
            System.out.println("значение поля для конкретного объекта: " + field.get(textMessage));
        }

        // 22 получение ссылок на методы - аналогично полям/свойствам
        // 23 возвращает ссылки на все публичные методы класса (включая родительские)
        Method[] methods = textMessageClass.getMethods();
        System.out.println("ссылки на public методы класса: " + Arrays.toString(methods));

        // 24 возвращает ссылки на все методы класса (включая private и protected, но не родителя)
        Method[] declaredMethods = textMessageClass.getDeclaredMethods();
        System.out.println("ссылки на методы класса: " + Arrays.toString(declaredMethods));

        // 25 при переборе (можно и declaredMethods или methods) по каждому методу можно узнать какие у него параметры, модификатор, тип возвращаемого значения и тд
        for (Method method : methods) {
            System.out.println("---имя метода: " + method.getName());
            System.out.println("тип возвращаемого значения: " + method.getReturnType());
            System.out.println("наличие модификатора final: " + Modifier.isFinal(method.getModifiers()));
            System.out.println("наличие модификатора synchronized: " + Modifier.isSynchronized(method.getModifiers()));
            System.out.println("количество параметров/аргументов: " + method.getParameterCount());
            System.out.println("типы параметров/аргументов: " + Arrays.toString(method.getParameterTypes()));
            System.out.println("выбрасываемые исключения: " + Arrays.toString(method.getExceptionTypes()));
        }

        // 26 получение ссылок на конструкторы (getDeclaredConstructors - включая приватные, но без родительских)
        Constructor<?>[] declaredConstructors = textMessageClass.getDeclaredConstructors();
        System.out.println("ссылки на конструкторы: " + Arrays.toString(declaredConstructors));

        // 25 при переборе по каждому конструктору можно узнать много чего, но самые важные это количество и типы аргументов, т.к они необходимы для создания объекта (какое количество параметров передовать в конструктор объекта).
        for (Constructor<?> constructor: declaredConstructors) {
            System.out.println("---количество параметров/аргументов: " + constructor.getParameterCount());
             System.out.println("--типы параметров/аргументов: " + Arrays.toString(constructor.getParameterTypes()));
             System.out.println("---выбрасываемые исключения: " + constructor.getExceptionTypes());
        }

        // 26. создание экземпляров с использованием рефлексии (без new)

        // 28. тоже самое, что и п. 14
        textMessageClass = TextMessage.class;

        // 27. в первую очередь необходимо получить ССЫЛКУ на КОНСТРУКТОР - tmConstructor, необходимо знать, последовательность аргументов выбранного конструктора и их типы - getDeclaredConstructor
        // 28. Выглядит так, у ссылки на класс textMessageClass вызываем метод getDeclaredConstructor и передаем ему типы параметров которые он принимает String.class (интересный момент, перед написанием аргумента необходимо, проверить на наличие аргументов и их пипы п.25, но БИБЛИОТЕКИ этого не делают, по этому необходимо всегда писать пустой конструктор иначе программа упадет с ошибкой).
        Constructor<TextMessage> tmConstructor = textMessageClass.getDeclaredConstructor(String.class);

        // 29. после получения ссылки на конструктор можно создавать экземпляр объекта
        // 30. у ссылки на конструктор tmConstructor вызываем метод newInstance и передаем экземпляры, передаваемые в конструктор (последние три слова не понял, но наверно, имеется ввиду аргументы обычного конструктора, куда передаются физические значения (что-то в цифрах, строчках и т.д.) причем типы данных должны идти через запятую так же как и в конструкторе, например сначала string затем int и тд.) Так же аргумент может быть пустым
        TextMessage reflectMessage = tmConstructor.newInstance("Reflect Message");
        System.out.println("рефлексивный экземпляр: " + reflectMessage);

        // 31. у созданного экземпляра можно вызывать методы (getXXXXXXX/getDeclaredField/....) и обращаться к свойствам через РЕФЛЕКСИЮ

        // 32. получение ссылки на поле по его имени ("text") в классе
        Field textField = textMessageClass.getDeclaredField("text");
        // 33. установить возможность работать с private и protected полями, как с public
        textField.setAccessible(true);

        // 34. возвращает ЗНАЧЕНИЕ поля для конкретного объекта, если позволяет модификатор доступа, в противном случае - IllegalAccessException
        // 35. У ссылки на поле/свойство textField вызываем метод get и передаем в аргумент экземпляра объекта reflectMessage
        System.out.println("значение свойства text для объекта reflectMessage: " + textField.get(reflectMessage));

        // 36. устанавливает ЗНАЧЕНИЕ поля (работает как сеттор) для конкретного объекта, если позволяет модификатор доступа, в противном случае - IllegalAccessException
        // 37. у ссылки на поле textField вызываем метод set и передаем в аргумент ссылку на экземпляр объекта reflectMessage и устанавливаемое ЗНАЧЕНИЕ поля/свойства "xxxxxx"
        textField.set(reflectMessage, "Значение поля объекта reflectMessage установлено через рефлексию");


        // с рефлексивными объектами можно работать, как с обычными и наоборот (я так понял это пример получения значения свойства text??)
        System.out.println(reflectMessage.getText());


        // 38. У объекта можно вызвать любой метод используя рефлексию, для этого необходимо получить ссылку на этот метод, а также типы и последовательность аргументов.
        // 39. Например, получение ссылки на метод - setTextMethod по его имени - "setText" в классе - textMessageClass, для этого необходимо знать, последовательность аргументов выбранного метода и их типы - String.class
        Method setTextMethod = textMessageClass.getDeclaredMethod("setText", String.class);
        // 40. вызов метода конкретного объекта, передача необходимых аргументов, пояснение мы вызываем(invoke). вот этот метод setTextMethod у конкретного объекта reflectMessage и передаем в метод вот эту строчку "НОВЫЙ ТЕКСТ".
        setTextMethod.invoke(reflectMessage, "НОВЫЙ ТЕКСТ");
        System.out.println(reflectMessage.getText());

        Method printInfoMethod = textMessageClass.getDeclaredMethod("printInfo");
        printInfoMethod.setAccessible(true);
        printInfoMethod.invoke(reflectMessage);

        // TODO: реализовать рефлексивный метод public static String toString(Object o){ }
        //  который выводит имя свойства и значения свойства для объекта 'obj' если свойство отмечено аннотацией (@Exclude не выводить в консоль информацию по данному полю. Ананотацию объявить самостоятельно . ДЛя теста можно использовать любой объектю


    }
    public  static void toString(Object obj){

    }
}
