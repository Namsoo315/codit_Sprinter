package com.codeit.ex04.stream;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class streamBasic02 {
	public static void main(String[] args) {
		//List 스트림 (중복 없음)
		List<Integer> list = new ArrayList<>(List.of(2, 1, 3, 4, 5, 6, 9, 8, 7, 10));
		List<String> strList1 = new ArrayList<>(List.of("CCC", "AAA", "BBB", "DDD", "EEE"));

		// 중복 있음
		List<Integer> list2 = new ArrayList<>(List.of(2, 1, 3, 2, 3, 4, 2, 1, 5));
		List<String> strList2 = new ArrayList<>(List.of("CCC", "AAA", "BBB", "AAA", "BBB"));

		Optional<Integer> sum1 = list.stream().reduce((a, b) -> a + b);
		System.out.println(sum1.get());

		Optional<Integer> sum2 = list.stream().reduce(Integer::sum);
		System.out.println(sum2.get());

		IntStream intStream = list.stream().mapToInt((v) -> v);
		intStream.sum();
		intStream.average();
		intStream.max();
		intStream.min();
		intStream.count();
		IntSummaryStatistics stst = intStream.summaryStatistics();
		stst.getAverage();
		System.out.println();
	}
}
