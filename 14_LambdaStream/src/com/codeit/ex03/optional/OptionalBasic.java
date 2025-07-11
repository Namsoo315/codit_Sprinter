package com.codeit.ex03.optional;

import java.util.Optional;
import java.util.OptionalInt;

public class OptionalBasic {
	// Optional이란?
	// null 또는 값을 감싸서 NPE(NullPointerException)로부터 부담을 줄이기 위해 등장한 Wrapper 클래스 
	// Optional은 값을 Wrapping하고 Null Check로직은 간소화하여 코드의 가독성을 높인다고 한다.
	// -> 문제 실제 사용해 보면 생산성이 떨어진다. 정말 필요한 경우만 사용 권장! 단순 DTO에는 선언할 필요 없다고 생각

	@SuppressWarnings("unused")
	public static void main(String[] args) {
//		String str = "abcde";

		String str = null;
		if(str != null) { // null check!
			System.out.println(str.toUpperCase());
		}

		// Optional로 문자열 감싸는 방법
		Optional<String> optStr = Optional.of("abcde"); // 정상적인 방법!
//		Optional<String> optStr = Optional.of(null); // null을 넣으면? of는 죽는다!
		Optional<Integer> optInt = Optional.of(100);
		OptionalInt optInt2 = OptionalInt.of(200);
		
		// Optional 사용법 -> 그냥 출력하면 안된다!
		System.out.println(optStr); // Optional[abcde]이 출력이 된다. -> 정상 출력방법 아님!!
		System.out.println(optInt); // Optional[100]이 출력이 된다.
		System.out.println(optInt2); // OptionalInt[200]이 출력이 된다.
		System.out.println("---------------------------------------------");
		
		// get을 통해 호출하는 방법 ★★★
		System.out.println(optStr.get()); // 정상적인 인자 출력방법
		System.out.println(optInt.get()); // 정상적인 인자 출력방법
		System.out.println(optInt2.getAsInt()); // 정상적인 인자 출력방법
		System.out.println("---------------------------------------------");
		
		
		// Optional 선언법2 ★★★
		// null이 인자로 들어올수 있는 상황을 가정해서 항상 ofNullable로 선언한다.
		Optional<String> optStr2 = Optional.ofNullable("abcde");
		Optional<String> optStr3 = Optional.ofNullable(null);
		
		// 출력
		System.out.println(optStr2.get());
//		System.out.println(optStr3.get()); // null이면 죽는다!
		
		// 인자에서 null을 체크하는 방법 -> null check 문법을 대체할수 있다.
		// 1. isPresent : null이 아닐때 참
		if(optStr2.isPresent()) {
			System.out.println(optStr2.get());
		}
		if(optStr3.isPresent()) {
			System.out.println(optStr3.get()); // 출력 안됨!
		}
		System.out.println("---------------------------------------------");
		// 2. isEmpty : null 일때 참
		if(!optStr2.isEmpty()) { // !로 쓰면 잘 안보인다!
			System.out.println(optStr2.get());
		}
		if(optStr3.isEmpty()) {
			System.out.println(optStr3.get()); // 출력 안됨!
		}
		
		// 3. orElse : null 일때 default값을 설정할수 있는 방법 ★★★
		System.out.println(optStr3.orElse("null 입니다."));
		System.out.println("---------------------------------------------");

		// 4. orElseThrow : null 일때 특정 에러를 발생시키는 방법 ★★★★★
		try {
			optStr3.orElseThrow(Exception::new);
		} catch (Exception e) {
			System.out.println("null 에러발생!!");
		}
		System.out.println("--------------------------------------------");
		
		// filter : 특정값을 필터링할때 사용하는 메소드
		//  -> Predicate : 동사, 필터링할 행위를 표현해야함
		// length이 0인 문자열을 필터링 하는 문법
		String result1 = Optional.of("test").filter(s -> !s.isEmpty()).get();
		System.out.println(result1);
		
		// length이 0인 문자열을 필터링 하는 문법
		String result2 = Optional.of("").filter(s -> !s.isEmpty()).orElse("빈 문자열");
		System.out.println(result2);
		System.out.println("---------------------------------------------");
		
		// map : 특정 Function 형을 실행시키고 다시 자신을 돌려주는 기능 (단순 사상)
		//   -> Function : 함수를 이미, 이미 만들어진 것도 활용 가능
		int result3 = Optional.of("123").map(Integer::parseInt).get(); // 파싱 한줄로하는법
		int result4 = Optional.of("12345").map(Integer::parseInt).get(); // 파싱 한줄로하는법
		System.out.println(result3);
		System.out.println(result4);
		System.out.println("---------------------------------------------");
		
		// filter + map
		int result5 = Optional.of("123").filter(x -> !x.isEmpty()).map(Integer::parseInt).get();
		int result6 = Optional.of("").filter(x -> !x.isEmpty()).map(Integer::parseInt).orElse(-1);
		System.out.println(result5);
		System.out.println(result6);
	}
}


























