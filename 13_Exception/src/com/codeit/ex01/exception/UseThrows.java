package com.codeit.ex01.exception;


// 예외 전가 전략
// - 지금과 같은 프레임워크를 사용하지 않는 경우 어디선가 예외를 처리하지 않으면 프로그램이 죽음으로 반드시 처리
// - 향후 Spring 프레임워크에서는 예외를 전가하고 이를 공통적으로 처리하는 AOP 설계 가능
// - 예외를 던지고 공통적으로 처리하는 로직으로 코드 구성이 간결해짐

// throws : 예외가 발생하면 호출한 메소드에게 예외의 책임을 전가하는 키워드
//          단, main에서 발생시에는 프로그램 종료를 의미
// throw : 예외를 만들어서 던지는 문장

// main에서 상위 프로세스에게 예외를 전가하는 코드 -> 죽는코드
//    public static void main(String[] args) throws Exception {}
public class UseThrows {
	public static void main(String[] args) throws Exception {
		try {
			method();
		} catch (Exception e) {
			// throw new RuntimeException(e);
			e.printStackTrace();
			System.out.println("main 에러 처리");
		}
	}

	private static void method() throws Exception {
		runtimeMethod();
		if(true){
			throw new Exception();
		}
		System.out.println("method 끝");
	}

	private static void runtimeMethod() {
		if(true){
			throw new RuntimeException();
		}
	}
}
