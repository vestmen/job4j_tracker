package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
/* 1. Метод averageScore() - вычисляет общий средний балл.

2. Метод averageScoreByPupil() - вычисляет средний балл по каждому ученику.

То есть берем одного ученика и считаем все его баллы за все предметы и делим на количество предметов.

Возвращает список из объекта Label (имя ученика и средний балл).

3. Метод averageScoreBySubject() - вычисляет средний балл по каждому предмету.


Например, собираем все баллы учеников по предмету география и делим на количество учеников.

Возвращает список из объектов Label (название предмета и средний балл).

4. Метод bestStudent() - возвращает лучшего ученика. Лучшим считается ученик с наибольшим суммарным баллом по всем предметам. Возвращает объект Label (имя ученика и суммарный балл).

5. Метод bestSubject() - возвращает предмет с наибольшим баллом для всех студентов. Возвращает объект Label (имя предмета, сумма баллов каждого ученика по этому предмету).

     */
    public static double averageScore(List<Pupil> pupils) {
        double sum = 0;
        int size = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                size++;
                sum += subject.score();
            }
        }
        return sum / size;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            int size = 0;
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                size++;
                sum += subject.score();
            }
            Label label = new Label(pupil.name(), sum / size);
            labels.add(label);
        }
        return labels;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        Map<String, Integer> subjectLabels = new LinkedHashMap<>();
        List<Label> labels = new LinkedList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = subjectLabels.getOrDefault(subject.name(), 0);
                subjectLabels.put(subject.name(), score + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : subjectLabels.entrySet()) {
            int rsl = entry.getValue() / pupils.size();
            labels.add(new Label(entry.getKey(), rsl));
        }
        return labels;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labels = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double sum = 0;
            for (Subject subject : pupil.subjects()) {
                sum += subject.score();
            }
            Label label = new Label(pupil.name(), sum);
            labels.add(label);
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        Map<String, Integer> subjectLabels = new LinkedHashMap<>();
        List<Label> labels = new LinkedList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                int score = subjectLabels.getOrDefault(subject.name(), 0);
                subjectLabels.put(subject.name(), score + subject.score());
            }
        }
        for (Map.Entry<String, Integer> entry : subjectLabels.entrySet()) {
            labels.add(new Label(entry.getKey(), entry.getValue()));
        }
        labels.sort(Comparator.naturalOrder());
        return labels.get(labels.size() - 1);
    }
}
