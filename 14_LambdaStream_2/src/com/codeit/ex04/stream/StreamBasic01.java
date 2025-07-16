package com.codeit.ex04.stream;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Stream;

public class StreamBasic01 {
	public static void main(String[] args) {
		String[] strArray = {"abc", "bbb", "ccc", "aba", "cbc", "ddd"};

		// 스트림 선언
		Stream<String> strStream = Stream.of("abc", "bbb", "ccc", "aba", "cbc", "ddd");
		strStream.forEach(System.out::println);
		strStream.close();
		try (Stream<String> strStream2 = Stream.of("abc", "bbb", "ccc", "aba", "cbc", "ddd")) {
			strStream2.forEach(System.out::println);
		} catch (Exception e) {
			throw new RuntimeException();
		}

		// 스트림이 닫히고 다시 여는 방법
		strStream = Stream.of(strArray);

		ArrayList<String> strList = new ArrayList<>(Arrays.asList(strArray));
		strList.stream().forEach((str) -> System.out.print(str + ", "));
		System.out.println();
		strList.stream().forEach((str) -> System.out.print(str + ", "));
		System.out.println();
		Arrays.stream(strArray).forEach((str) -> System.out.print(str + ", "));
		System.out.println();

		//중간 함수
		// 정렬
		Stream.of(strArray).sorted().forEach((str) -> System.out.print(str + ", "));
		System.out.println();
		Stream.of(strArray).sorted(Comparator.reverseOrder()).forEach((str) -> System.out.print(str + ", "));
		System.out.println();
		System.out.println("====================================");

		// map -> function꼴
		// 대문자 변경
		Stream.of(strArray).map(str -> str.toUpperCase()).forEach((str) -> System.out.print(str + ", "));
		System.out.println();
		Stream.of(strArray).map(String::toUpperCase).forEach((str) -> System.out.print(str + ", "));
		System.out.println();

		// filter : 스트림에서 제거
		System.out.println("a 포함된 문자열 제거");
		Stream.of(strArray).filter((str) -> !str.contains("a")).forEach((str) -> System.out.print(str + ", "));
		System.out.println();
		System.out.println("------------------------------------");

		// allMatch : 모든 객체가 조건에 매칭되는지 확인하는 기능
		// anyMatch : 특정 객체가 조건에 매칭되는지 확인하는 기능
		// noneMatch : allMatch 반대, 스트림의 모든 객체가 조건에 매칭되지 않는지 확인하는 기능
		System.out.println("a 가 포함된 문자열 제거");
		System.out.println("allMatch : " + Stream.of(strArray).allMatch((str) -> !str.contains("a")));
		System.out.println("anyMatch : " + Stream.of(strArray).anyMatch((str) -> !str.contains("a")));
		System.out.println("noneMatch : " + Stream.of(strArray).noneMatch((str) -> !str.contains("a")));

		String[] strArray2 = {"aaa", "bbb", "ccc", "aaa", "cbc", "ddd"};
		Stream.of(strArray2).distinct().forEach((str) -> System.out.print(str + ", "));
		System.out.println();
		System.out.println("================================");
		System.out.println(Stream.of(strArray2).distinct().count());

		// 대문자 변경 + 중복제거
		Stream.of(strArray2).distinct().map(String::toUpperCase)
			.filter((v) -> !v.contains("A"))
			.sorted().forEach((str) -> System.out.print(str + " "));

	}
}
