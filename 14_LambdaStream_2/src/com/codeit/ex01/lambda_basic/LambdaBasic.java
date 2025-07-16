package com.codeit.ex01.lambda_basic;

import java.util.ArrayList;
import java.util.Collections;

public class LambdaBasic {
	public static void main(String[] args) {
		// 익명클래스 사용
		MyLambda1 myLambda1 = new MyLambda1() {
			@Override
			public void run() {
				System.out.println("Hello World!");
			}
		};

		myLambda1.run();

		//람다 기본형
		MyLambda1 f1 = () -> {
			System.out.println("Hello World!!");
		};
		f1.run();

		//단축 표현 2번째
		MyLambda2 f2 = (msg) -> {
			System.out.println(msg);
		};

		// 단축 표현 3번째
		MyLambda2 f3 = msg -> System.out.println(msg);

		// 여러 파라메터 + 반환 값 있을 때
		MyLambda3<Integer> f4 = (a, b) -> {
			return a + b;
		};

		// 반환 값 더 생략된 문법 -> 순수 함수 꼴
		MyLambda3<Integer> f5 = (a, b) -> a + b;

		// 인자로 람다 남길 때
		staticMethod(f5, 10, 20);
		Integer result = staticMethod((a, b) -> a / b, 10, 20);
		System.out.println(result);
		Collections.sort(new ArrayList<>(), (o1, o2) -> o1.hashCode() - o2.hashCode());

		// 메서드 참조 : '::"로 메서드를 호출하는 방법, 이미 만들어진 static 메서드도 가능하다.
		int result2 = staticMethod(MethodRef::sum, 10, 20);
		int result3 = staticMethod(MethodRef::multiply, 10, 20);
		int result4 = staticMethod(Integer::sum, 10, 20);
		int result5 = staticMethod(Math::addExact, 10, 20);
		int result6 = staticMethod(Math::multiplyExact, 10, 20);

		System.out.println(result2 + ", " + result3 +  ", " + result4 + ", " + result5 + ", " + result6);
	}

	public static <T> T staticMethod(MyLambda3<T> f, T a, T b) {
		return f.calc(a, b);
	}

}
