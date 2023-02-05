package ru.job4j.queue;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("parsentev@yandex.ru", "Petr Arsentev");
        map.put("alex@mail.ru", "Alexey Nemtsev");
        map.put("ivanov@gmail.com", "Ivan Ivanov");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
