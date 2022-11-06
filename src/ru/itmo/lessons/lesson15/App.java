package ru.itmo.lessons.lesson15;


import java.util.*;

public class App {
    public static void main(String[] args) {

        User user1 = new User("L1","P1", Role.ADMIN, 19);
        User user2 = new User("L2","P2", Role.USER, 19);
        User user3 = new User("L3","P3", Role.ADMIN, 35);
        User user4 = new User("L4","P4", Role.USER, 35);
        User user5 = new User("L5","P5", Role.ADMIN, 45);


        HashMap<String, User> hashMap1 = new HashMap<>();
        hashMap1.put(user1.getLogin(), user1);
        hashMap1.put(user2.getLogin(), user2);
        hashMap1.put(user3.getLogin(), user3);
        hashMap1.put(user4.getLogin(), user4);
        hashMap1.put(user5.getLogin(), user5);

        ArrayList<String> arrayList = new ArrayList<>();
        for (Map.Entry<String, User> pair: hashMap1.entrySet()){
            if (pair.getValue().getAge() > 20){
                arrayList.add(pair.getKey());
            }
        }
        for (Map.Entry<String, User> pair: hashMap1.entrySet()){
            pair.getValue().getRole();
                arrayList.add(pair.getKey());
        }

        EnumMap<Role, ArrayList<User>> enumMap = new EnumMap<>(Role.class);

        ArrayList<User> admins = new ArrayList<>(Arrays.asList(user2, user3));
        enumMap.put(Role.ADMIN,admins);
        ArrayList<User> user = new ArrayList<>(Arrays.asList(user1, user4, user5));
        enumMap.put(Role.USER,user);

        ArrayList<User> fromMap = enumMap.get(Role.USER);

    }
}
