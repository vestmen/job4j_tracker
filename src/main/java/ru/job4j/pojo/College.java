package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student alex = new Student();
        alex.setFio("Немцев Алексей Васильевич");
        alex.setGroup("Прикладная математика");
        alex.setEntrance(new Date());
        System.out.println(alex.getFio() + " учится в группе: " + alex.getGroup());
    }
}
