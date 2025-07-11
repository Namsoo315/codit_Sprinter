package com.codeit.ex05.streamobj;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summarizingInt;

class StreamObj02 {
	public static void main(String[] args) {
		Student2[] stuArr = {
			new Student2("이자바", 3, 300),
			new Student2("김자바", 1, 200),
			new Student2("안자바", 2, 100),
			new Student2("박자바", 2, 150),
			new Student2("소자바", 1, 200),
			new Student2("나자바", 3, 290),
			new Student2("감자바", 3, 180)
		};

		// 학생 이름만 뽑아서 List<String>에 저장하는 방법
		List<String> names = Stream.of(stuArr).map(Student2::getName)
									          .collect(Collectors.toList());
		System.out.println(names);

		// 스트림을 배열로 변환하는 방법
		Student2[] stuArr2 = Stream.of(stuArr).toArray(Student2[]::new);

		for(Student2 s : stuArr2)
			System.out.println(s);

		// 스트림을 Map<String, Student>로 변환. 학생 이름이 key
		Map<String,Student2> stuMap = Stream.of(stuArr)
						                   .collect(Collectors.toMap(s->s.getName(), p->p));
		for(String name : stuMap.keySet())
			System.out.println(name +"-"+stuMap.get(name));

		long count = Stream.of(stuArr).count();
		long totalScore = Stream.of(stuArr).mapToInt(Student2::getTotalScore).sum();
		System.out.println("count="+count);
		System.out.println("totalScore="+totalScore);

		totalScore = Stream.of(stuArr).map(Student2::getTotalScore).reduce(0, Integer::sum);
		System.out.println("totalScore="+totalScore);

		Optional<Student2> topStudent = Stream.of(stuArr)
		                                     .max(Comparator.comparingInt(Student2::getTotalScore));
		System.out.println("topStudent="+topStudent.get());

		IntSummaryStatistics stat = Stream.of(stuArr)
					                      .collect(summarizingInt(Student2::getTotalScore));
		System.out.println(stat);

		String stuNames = Stream.of(stuArr)
							    .map(Student2::getName)
							    .collect(joining(",", "{", "}"));
		System.out.println(stuNames);
	}
}


class Student2 implements Comparable<Student2> {
	String name;
	int ban;
	int totalScore;

	Student2(String name, int ban, int totalScore) {
		this.name = name;
		this.ban = ban;
		this.totalScore =totalScore;
	}

	public String toString() {
	   return String.format("[%s, %d, %d]", name, ban, totalScore).toString();
	}

	String getName() { return name;}
	int getBan() { return ban;}
	int getTotalScore() { return totalScore;}

	public int compareTo(Student2 s) {
		return s.totalScore - this.totalScore;
	}
}
