package com.codeit.ex03.optional;

import java.util.Optional;

public class OptionalBasic {
	public static void main(String[] args) {
		String str = null;
		if(str != null) { // null check!
			System.out.println(str.toUpperCase());
		}

		Optional<String> optional1 = Optional.of("Hello World!!!");
		Optional<String> optional2 = Optional.ofNullable(null);

		System.out.println(optional1);
		System.out.println(optional2);

		if(optional2.isPresent()) {
			System.out.println(optional2.get());
		}
		if(optional1.isEmpty()) {
			System.out.println("null 입니다.");
		}

		System.out.println(optional1.orElse("default value"));
		System.out.println(optional2.orElse("default value"));

		// 3. orElseThrow : null 일때 특정 에러 생성 가능
		try {
			optional2.orElseThrow(NullPointerException::new);
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}
}
