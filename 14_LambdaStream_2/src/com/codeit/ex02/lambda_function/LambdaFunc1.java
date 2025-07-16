package com.codeit.ex02.lambda_function;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaFunc1 {

	public static void main(String[] args) {
		// Suplier : 공급자, T get();
		Supplier<String> s1 = () -> "Hello World!!";
		Supplier<Integer> supplier = () -> new Random().nextInt(100) + 1;	//1 ~ 100
		List<Integer> list1 = new ArrayList<>();
		makeRandomList(list1, supplier, 10);
		System.out.println(list1);

		// Consumer : 소비자, void accept(T t);
		Consumer<Integer> consumer = (v) -> System.out.println(v + " ");
		printFormat(list1, consumer);
		printFormat(list1, System.out::print);
		System.out.println("============================");

		// Predicate : 서술부, 필터로 활용! boolean test(T t);
		Predicate<Integer> predicate1 = (v) -> v % 2 == 0;	//짝수 필터링
		Predicate<Integer> predicate2 = (v) -> v % 2 == 0 && v % 3 == 0;	//2, 3의 배수 필터링
		Predicate<Integer> predicate3 = (v) -> v % 2 == 0 || v % 3 == 0;	//2 또는 3의 배수 필터링
		printComputeNumber(list1, predicate3, consumer);

		// Function : 함수형, 순수 사상, R apply(T t)
		// -> int를 받으면 16진수 문자열로 반환도 가능.
		Function<Integer, String> f1 = (v) -> "0x" + Integer.toHexString(v);
		List<String> newList = makeNewList(list1, f1);
		System.out.println(newList);

		// BIXXX류
		BiConsumer<String, Integer> biConsumer = (v1, v2) -> System.out.println(v1 + " + " + v2);
		biConsumer.accept("Hello World!!", 10);
	}
	// 제네릭 함수
	// Supplier 함수부 예시
	private static <T> void makeRandomList(List<T> list, Supplier<T> s, int size) {
		for(int i = 0; i < size; i++) {
			list.add(s.get());
		}
	}

	// Consumer 함수부 예시
	private static <T> void printFormat(List<T> list, Consumer<T> c) {
		System.out.print("[");
		for(T v : list) {
			c.accept(v);
		}
		System.out.println("]");
	}

	// Predicate 함수부 예시
	private static <T> void printComputeNumber(List<T> list, Predicate<T> p,
		Consumer<T> c) {
		System.out.print("[");
		for(T v : list) {
			if(p.test(v)) {
				c.accept(v);
			}
		}
		System.out.println("]");
	}

	// Function 함수부 예시
	private static <T, R> List<R> makeNewList(List<T> list, Function<T, R> f) {
		List<R> newList = new ArrayList<>();
		for(T v : list) {
			newList.add(f.apply(v));
		}
		return newList;
	}
}
