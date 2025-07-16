package com.codeit.ex01.lambda_basic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaBasicCollections {
	public static void main(String[] args) {

		//람다 메서드 실습
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			list.add(i + 1);
		}
		System.out.println(list);

		//foreach : list를 스트림을 변환
		list.forEach(v -> {
			if (v % 2 == 0) {
				System.out.println(v + ", ");
			}
		});

		list.forEach(v -> System.out.print(v + ","));
		System.out.println();
		list.forEach(System.out::println);
		list.stream().filter(v -> v % 2 == 0).forEach(System.out::println);
		System.out.println("=========================");

		// 2. removeif : list에서 일부 조건을 제거
		list.removeIf(v -> v % 2 == 0 || v > 5);
		System.out.println(list);

		// replaceAll : 인자를 모두 변경해주는 기능 , map
		List<Integer> list2 = new ArrayList<>(List.of(1, 2, 3, 4, 5));
		list2.replaceAll(v -> v * 100);
		System.out.println(list2);

		// Map에서 람다 문법
		Map<String, String> map = new HashMap<>();
		map.put("1", "aaa");
		map.put("2", "bbb");
		map.put("3", "ccc");
		map.forEach((k, v) -> System.out.println(k + ", " + v));
		System.out.println();

		// compute : key가 존재하면 선언한 함수식이 실행
		map.compute("1", (k, v) -> v.toUpperCase());
		System.out.println(map);
		// Key 값 없으면 에러

		// 있을때만 변경
		map.computeIfPresent("2", (k, v) -> v.toUpperCase() + "BBB");
		map.computeIfPresent("5", (k, v) -> v.toUpperCase() + "BBB");
		System.out.println(map);

		// 있을때만 변경
		map.computeIfAbsent("3", (v) -> v.toUpperCase());
		map.computeIfAbsent("5", (v) -> v.toUpperCase() + "EEE");
		System.out.println(map);

	}
}
