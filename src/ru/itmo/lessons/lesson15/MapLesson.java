package ru.itmo.lessons.lesson15;

import java.util.*;

public class MapLesson {

    public static void main(String[] args) {
        // коллекции
        // элемент1
        // элемент2
        // элемент3
        // элемент4

        // мапы
        // 7 - элемент4
        // 45 - элемент1
        // 78 - элемент2
        // 1111 - элемент3

        // Map хранят данные в парах ключ - значение
        // Особенности map:
        // 1. ключи мапы должны быть уникальны
        // 2. каждому ключу соответствует только одно значение
        // 3. Map не являются коллекциями

        // наиболее популярные HashMap<K, V>, TreeMap<K, V>, EnumMap<K, V>, LinkedHashMap<K, V>

        // Особенности HashMap:
        // 1. хранит ключи в hash таблице (на основе hash кода)
        // 2. для ключей дб переопределены методы equals и hashCode
        // 2. обладает хорошей производительностью
        // 3. в качестве ключа можно использовать null
        // 4. порядок хранения элементов может
        // отличаться от порядка добавления

        // создание экземпляра HashMap:
        // в <> сначала указываем типа данных ключей,
        // затем тип данных значений
        HashMap<String, Integer> hashMap = new HashMap<>();

        // добавление элементов
        hashMap.put("Москва", 790);
        hashMap.put("Ростов", 270);
        hashMap.put("Великий Новгород", 75);
        hashMap.put("Тверь", 12);
        hashMap.put(null, null);
        System.out.println(hashMap);

        // удаление пары
        hashMap.remove(null); // по ключу
        hashMap.remove("Москва", 5); // по ключу и значению
        hashMap.remove("Ростов", 270); // по ключу и значению
        System.out.println(hashMap);

        // замена
        hashMap.replace("Великий Новгород", 100); // по ключу
        hashMap.replace("Тверь", 12, 22); // по ключу и значению
        System.out.println(hashMap);

        // получение
        System.out.println(hashMap.get("Тверь"));
        System.out.println(hashMap.get("Москва"));
        // если ключ не найден, вернет значение по умолчанию
        System.out.println(hashMap.getOrDefault("Санкт-Петербург", 0));
        System.out.println(hashMap.getOrDefault("Великий Новгород", 0));

        // проверить, содержится ли в мапе ключ
        System.out.println(hashMap.containsKey("Санкт-Петербург"));
        // проверить, содержится ли в мапе значение
        System.out.println(hashMap.containsValue(1000));

        System.out.println("---Перебор мап---");
        // hashMap.keySet(); // только ключи (Set)
        // hashMap.values(); // только значения (Collection)
        for (Map.Entry<String, Integer> pair : hashMap.entrySet()) {
            System.out.println("город (ключ): " + pair.getKey());
            System.out.println("количество покупателей (значение): "
                    + pair.getValue());
        }
        // hashMap.keySet(); // только ключи (Set)
        // hashMap.values(); // только значения (Collection)
        // hashMap.entrySet(); // ключи + значения (Map.Entry)


        // TODO: ЗАДАЧИ
        //  1. Создать несколько экземпляров класса User
        User user1 = new User("log1", "pw1", Role.ADMIN, 21);
        User user2 = new User("log2", "pw2", Role.USER, 21);
        User user3 = new User("log3", "pw3", Role.ADMIN, 19);
        User user4 = new User("log4", "pw4", Role.USER, 19);
        User user5 = new User("log5", "pw5", Role.ADMIN, 18);
        User user6 = new User("log6", "pw6", Role.USER, 19);
        //  2. Создать EnumMap,где ключи - роли, значения - списки пользователей
        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
        ArrayList<User> admins = new ArrayList<>(Arrays.asList(user1, user3, user5));
        ArrayList<User> users = new ArrayList<>();
        users.add(user2);
        users.add(user4);
        users.add(user6);
        //  3. Добавить данные в мапу
        enumMap.put(Role.USER, users);
        enumMap.put(Role.ADMIN, admins);
        //  4. Вывести в консоль логины всех пользователей с ролью USER
        for (Map.Entry<Role, ArrayList<User>> pare : enumMap.entrySet()) {
            if (pare.getKey().equals(Role.USER)) {
                for (User valueLog : pare.getValue()) {
                    System.out.println(valueLog.getLogin());
                }
            }
        }
        for (User pare : enumMap.get(Role.USER)) {
            System.out.println(pare.getLogin());
        }


        //  5. Создать еще один экземпляр класса User, добавить его в мапу, представляя, что роль пользователя Вам неизвестна

        User user7 = new User("log7", "pw7", Role.USER, 21);

        for (Map.Entry<Role, ArrayList<User>> pare : enumMap.entrySet()) {
            if (pare.getKey().equals(user7.getRole())) {
                pare.getValue().add(user7);
            }
            System.out.println(enumMap);

   /*         // TODO: ЗАДАЧИ
            //  1. Создать несколько экземпляров класса User
            User user1 = new User("a", "a1", Role.ADMIN, 18);
            User user2 = new User("b", "b1", Role.USER, 22);
            User user3 = new User("c", "c1", Role.USER, 22);
            User user4 = new User("d", "d1", Role.USER, 44);
            User user5 = new User("f", "f1", Role.ADMIN, 18);
            //  с повторяющимися значениями свойства age
            //  2. Создать HashMap, где ключи - логины пользователей,
            //  значения - экземпляры класса User

            HashMap<String, User> userHashMap = new HashMap<>();
            //  3. Добавить данные в мапу
            userHashMap.put(user1.getLogin(), user1); // Entry(key, value)
            userHashMap.put(user2.getLogin(), user2); // Entry(key, value)
            userHashMap.put(user3.getLogin(), user3); // Entry(key, value)
            userHashMap.put(user4.getLogin(), user4); // Entry(key, value)
            userHashMap.put(user5.getLogin(), user5); // Entry(key, value)

            //  ------
            //  4. Логины всех пользователей, старше 20 лет скопировать в отдельный List
            ArrayList<String> logins = new ArrayList<>();
            for (Map.Entry<String, User> pair : userHashMap.entrySet()) {
                if (pair.getValue().getAge() > 20) {
                    logins.add(pair.getKey()); // TODO берем ключь (логины) из значения
                    //TODO  и добовляем его в список
                }
            }
            //  ------
            //  5. Вывести логины и пароли пользователей с ролью ADMIN
            for (User user : userHashMap.values()) { // TODO При переборе можно обращаться к
                // TODO ЗНАЧЕНИЮ (свойствам)!!!, а не только к ПАРАМ.
                if (user.getRole() == Role.ADMIN) {
                    System.out.println(user.getLogin());
                    System.out.println(user.getPwd());   // TODO Параль пользователя
                }
            }
            //  ------
            //  6. На основе существующей мапы создать новую,
            //  где ключи - возраст пользователей
            //  значения - списки пользователей соответствующего возраста
            HashMap<Integer, ArrayList<User>> ageMap = new HashMap<>();
            for (User user : userHashMap.values()) { // TODO перебераем значения/свойства
                if (!ageMap.containsKey(user.getAge())) { // TODO не доконца понял логику но она следующая, если в мапе не ключа соответствующему возрасту (по моему он там и не может содержаться т.к у нас в мапе ключи это ЛОГИНЫ(наверно если инфо о мапе приходит со стороны то мы можем и не знать есть в мапе ключ соответствующий возрасту, тогда это как то объяснимо)).
                    ArrayList<User> users = new ArrayList<>();
                    users.add(user); // TODO то добавляем свойства/значения в новый список, а
                    ageMap.put(user.getAge(), users); // TODO в новую мапу добовляем ключ (возраст), а в значение новый список.
                } else {
                    ageMap.get(user.getAge()).add(user); // TODO метод get по ключу (возраст) возвращает свойства/значения/список (найденого user1 в новой мапе), и этого пользователя который имеет аналогисный вораст в его список со значениями/свойствами добавляет еще одно значение (user), т.к ключи у них одинаковые ex:16 [user1, user2].
                }
            }
 */

            // LinkedHashMap аналогична HashMap, но позволяет сохранять
            // порядок элементов (из-за чего менее производительна, чем HashMap)

            // Особенности EnumMap:
            // 1. использует перечисления (enum) в качестве ключей
            // 2. нельзя использовать null в качестве ключа
            // 3. все ключи должны быть одного типа перечисления
            // 4. все значения содержит в массиве
            // (размер массива - количество элементов перечисления)
            // 5. порядок хранения элементов соответствует порядку
            // элементов enum
            // 6. для извлечения значений использует индекс ключа: vals[key.ordinal()]

            // при создании объекта в конструктор необходимо передать ссылку на класс перечисления,
            // например, Role.class
/*
            EnumMap<Role, String> map = new EnumMap<>(Role.class);
            map.put(Role.ADMIN, "Администратор");
            map.put(Role.USER, "Пользователь");
            // values = ["Пользователь", "Администратор"]
            map.get(Role.ADMIN); // "Администратор"
            // values[Role.ADMIN.ordinal()]

            EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);
            ArrayList<User> admins = new ArrayList<>(Arrays.asList(user1, user5));
            ArrayList<User> users = new ArrayList<>();
            users.add(user2);
            users.add(user3);
            users.add(user4);

            // TODO: ЗАДАЧИ
            //  1. Создать несколько экземпляров класса User
            //  2. Создать EnumMap,
            //  где ключи - роли, значения - списки пользователей
            //  3. Добавить данные в мапу
            enumMap.put(Role.ADMIN, admins);
            enumMap.put(Role.USER, users);
            //  4. Вывести в консоль логины всех пользователей с ролью USER
            for (User user : enumMap.get(Role.USER)) { // TODO для перебора была вызвана та часть мапы numMap.get(Role.USER), которорой ключи USER
                System.out.println(user.getLogin());
            }
            //  5. Создать еще один экземпляр класса User, добавить его в мапу,
            //  представляя, что роль пользователя Вам неизвестна
            User user6 = new User("z", "z1", Role.ADMIN, 33);
            Role userRole = user6.getRole();
            ArrayList<User> usersFromMap = enumMap.get(userRole); // TODO обратились к мапе, по ключу USER получили список пользователь, присвояли спискуusersFromMap.
            usersFromMap.add(user6); // TODO в список добавили пользователей.

            enumMap.get(user6.getRole()).add(user6); // TODO это короткая запись строк 178-180

            // Особенности TreeMap:
            // 1. хранит элементы в отсортированном по ключам порядке
            // 2. основан на красно-черном дереве
            // 3. null нельзя использовать в качестве ключей
            // 4. класс, объекты которого будут использоваться в качестве ключей
            // должен реализовывать интерфейс Comparable
            // или в конструктор мапы необходимо передать Comparator

            TreeMap<String, Integer> treeMap = new TreeMap<>(hashMap);
            treeMap.put("Анапа", 45);

            System.out.println(treeMap);
*/
        }
    }
}


