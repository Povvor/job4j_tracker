package ru.job4j.stream;




import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0.0);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
    return stream.
            map(pupil -> {
                double average = pupil.subjects().stream()
                        .mapToInt(Subject::score)
                        .average()
                        .orElse(0.0);
                        return new Tuple(pupil.name(), average); })
            .toList();
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        Map<String, Double> avgMap = stream
                .flatMap(pupil -> pupil.subjects().stream())
                        .collect(Collectors.groupingBy(
                                Subject::name,
                                LinkedHashMap::new,
                                Collectors.averagingDouble(Subject::score)
                        ));
        return avgMap.entrySet().stream()
                .map(mapStream ->
                        new Tuple(mapStream.getKey(), mapStream.getValue()))
                .toList();
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.
                map(pupil -> {
                    double sum = pupil.subjects().stream()
                            .mapToInt(Subject::score)
                            .sum();
                    return new Tuple(pupil.name(), sum);
                })
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
            Map<String, Double> sumMap = stream
                    .flatMap(pupil -> pupil.subjects().stream())
                    .collect(Collectors.groupingBy(
                            Subject::name,
                            LinkedHashMap::new,
                            Collectors.summingDouble(Subject::score)
                    ));
            return sumMap.entrySet().stream()
                    .map(mapStream ->
                            new Tuple(mapStream.getKey(), mapStream.getValue()))
                    .max(Comparator.comparingDouble(Tuple::score))
                    .orElse(null);
    }
}