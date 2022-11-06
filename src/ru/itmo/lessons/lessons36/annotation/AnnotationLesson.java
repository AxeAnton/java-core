package ru.itmo.lessons.lessons36.annotation;
// 53. Пример того как мы можем собрать аннотацию, как ее найти и как можем что-то получить (параметры.....)

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Arrays;


public class  AnnotationLesson {
    public static void main(String[] args) {
        Class<Cat> catClass = Cat.class;

        // 57. у каждого класса, у каждого класса свойства конструктора или свойства метода и аргумента объекта можно получить список аннотаций, для этого мы обращаемся к ссылке на класс, к ссылке на свойства метода или аргументы метода и вызываем метод - getAnnotations который вернет массив со всеми аннотациями.
        Annotation[] annotations = catClass.getAnnotations();
        System.out.println("ссылки на аннотации класса: " + Arrays.toString(annotations));

        // 58. проверить на наличие конкретной аннотации
        //59. реализация, обращаемся к классу - catClass, вызываем метод - isAnnotationPresent (вызывает true если аннотация есть и false если нет), в аргумент метода помещаем (искомую аннотацию - ClassConfig.class)
        if (catClass.isAnnotationPresent(ClassConfig.class)){
            System.out.println("ClassConfig");
            //60. Если аннотация присутствует, то можно получить ссылку на нее (что бы потом получить параметры аннотации)
            ClassConfig classConfig = catClass.getDeclaredAnnotation(ClassConfig.class);
            // 61 получение параметров. Реализация: обращаемся к аннотации по ссылке - classConfig и вызываем искомые свойства: prefix, version и file. Случаем ссылку на configFile() и имя и возраст кота.
            System.out.println("prefix: " + classConfig.prefix());
            System.out.println("version: " + classConfig.version());
            System.out.println("file: " + classConfig.configFile());
        }

        // 62. Если у нас аннотация как маркер, типа есть или нет ее, то не будем получать ссылку, например для полей или для методов.
        // 63. Собрали все методы и поля в один массив с помощью метода getDeclaredFields() и начинаем переберать
        Field[] fields = catClass.getDeclaredFields();

        for (Field field: fields){
            Annotation[] fieldAnnotations = field.getDeclaredAnnotations();
            System.out.println("ссылки на аннотации поля: " + Arrays.toString(fieldAnnotations));

            //64. Проверка наличия определенной аннотации
            if (field.isAnnotationPresent(Required.class)){
            } else {
                System.out.println(field.getName() + " - поле без аннотации Required");
            }
        }
// test
        // TODO: Задание: реализовать метод, принимающий на вход ссылку на класс и возвращающий экземпляр данного
        //  класса или null
        //  Если класс аннотирован аннотацией ConfigClass, создать объект данного класса (использовать рефлексию),
        //  если аннотации нет, вернуть null.
        //  Если поле отмечено аннотацией @Required,
        //  необходимо установить значение данного поля (любое или из config.properties файла),
        //  значение поля устанавливать через сеттер (name - setName / age - setAge).
        //  У созданного объекта вызвать метод toString(), используя рефлексию.
        //  Вернуть созданный объект.
    }
}
