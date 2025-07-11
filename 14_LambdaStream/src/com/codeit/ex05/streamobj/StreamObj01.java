package com.codeit.ex05.streamobj;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamObj01 {
    // 사용자 객체 스트림 예시
    public static void main(String[] args) {
        Student1[] stuArr = {new Student1("이자바", 3, 300), new Student1("김자바", 1, 200), new Student1("안자바", 2, 100), new Student1("박자바", 2, 150), new Student1("소자바", 1, 200), new Student1("나자바", 3, 290), new Student1("감자바", 3, 180)};

        // 단순 필터링
        Stream<Student1> stream = Stream.of(stuArr);
        long count = stream.filter(s -> s.getTotalScore() >= 200).count();
        System.out.println("200점 보다 높은 사람 수 : " + count);
        System.out.println("--------------------------------");

        // 정렬 예제
        Stream<Student1> studentStream = Stream.of(new Student1("이자바", 3, 300), new Student1("김자바", 1, 200), new Student1("안자바", 2, 100), new Student1("박자바", 2, 150), new Student1("소자바", 1, 200), new Student1("나자바", 3, 290), new Student1("감자바", 3, 180));
        studentStream.sorted(Comparator.comparing(Student1::getBan) // 반별 정렬
                        .thenComparing(Comparator.naturalOrder()))    // 기본 정렬
                .forEach(System.out::println);
        System.out.println("-------------------------------------");

        // of로 스트린 생성하기
        Stream<Student1> stuStream = Stream.of(stuArr);
        stuStream.sorted(Comparator.comparing(Student1::getBan).thenComparing(Comparator.naturalOrder())).forEach(System.out::println);
        System.out.println("-------------------------------------");

        // 통계 내기
        stuStream = Stream.of(stuArr); // 스트림을 다시 생성한다.
        IntStream stuScoreStream = stuStream.mapToInt(Student1::getTotalScore);

        IntSummaryStatistics stat = stuScoreStream.summaryStatistics();
        System.out.println("count=" + stat.getCount());
        System.out.println("sum=" + stat.getSum());
        System.out.printf("average=%.2f%n", stat.getAverage());
        System.out.println("min=" + stat.getMin());
        System.out.println("max=" + stat.getMax());
    }
}


class Student1 implements Comparable<Student1> {
    String name;
    int ban;
    int totalScore;

    Student1(String name, int ban, int totalScore) {
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString() {
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName() {
        return name;
    }

    int getBan() {
        return ban;
    }

    int getTotalScore() {
        return totalScore;
    }

    // 총점 내림차순을 기본 정렬로 한다.
    public int compareTo(Student1 s) {
        return s.totalScore - this.totalScore;
    }
}