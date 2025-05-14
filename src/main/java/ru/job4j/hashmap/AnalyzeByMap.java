package ru.job4j.hashmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        float subjectCount = 0;
        float totalScore = 0;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                subjectCount++;
                totalScore += subject.score();
                }
            }
        return totalScore / subjectCount;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> labelList = new ArrayList<>();
        float subjectCount;
        float totalScore;
        for (Pupil pupil : pupils) {
            subjectCount = 0;
            totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                subjectCount++;
                totalScore += subject.score();
            }
            labelList.add(new Label(pupil.name(), totalScore / subjectCount));
        }
        return labelList;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> scoreList = new LinkedHashMap<>();
        List<Label> result = new ArrayList<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                scoreList.put(subject.name(), scoreList.getOrDefault(subject.name(), 0) + subject.score());
            }
        }
        for (String subject : scoreList.keySet()) {
            int average = scoreList.get(subject) / pupils.size();
            Label label = new Label(subject, average);
            result.add(label);
        }
        return result;

    }

    public static Label bestStudent(List<Pupil> pupils) {
        LinkedList<Label> result = new LinkedList<>();
        float totalScore;
        for (Pupil pupil : pupils) {
            totalScore = 0;
            for (Subject subject : pupil.subjects()) {
                totalScore += subject.score();
            }
            result.add(new Label(pupil.name(), totalScore));
        }
        result.sort(Comparator.naturalOrder());
        return  result.getLast();
    }

    public static Label bestSubject(List<Pupil> pupils) {
        LinkedHashMap<String, Integer> scoreList = new LinkedHashMap<>();
        LinkedList<Label> result = new LinkedList<>();
        int score;
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                if (!scoreList.containsKey(subject.name())) {
                    score = subject.score();
                    scoreList.put(subject.name(), score);
                } else {
                    score = scoreList.get(subject.name());
                    scoreList.put(subject.name(), score + subject.score());
                }
            }
        }
        for (String subject : scoreList.keySet()) {
            Label label = new Label(subject, scoreList.get(subject));
            result.add(label);
        }
        result.sort(Comparator.naturalOrder());
        return result.getLast();
    }
}