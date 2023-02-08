package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
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
