package com.codeit.ex01.exception;

import java.io.IOException;

// Try-catch문
// - 에러를 직접 처리하기 위한 문장으로 에러가 발생하면 직접 에러를 받아 처리할수 있는 문법
// - try-catch 문은 함수 호출 메커니즘(Stack)의 응용으로 아주 미미한 성능 저하가 발생
//   -> 이 정도는 성능저하 현대에서는 무시된다. try-catch 성능저하 보단 안정성과 생산성이 중요시 된다.
// - 과도한 try-catch문은 난발은 삼가해야 하지만, 실제로는 매우 유용한 프로그래밍 스킬이다.
//   -> 적당히 에러가 발생할꺼 같으면 try-catch로 처리하는 것도 실용적이다.
//   -> 간단한 null 체크 외의 여러 error가 발생할꺼 같으면 try-catch 문 안에서 처리
// - 자동 완성 단축키 : ctrl + alt + t -> try-catch문
public class Trycatch {
	public static void main(String[] args) throws Exception {

		try {
			System.out.println("예외가 발생할 수 있는 구간.");
			if (true) {
				throw new IOException("파일 에러");
				// throw new Exception("사용자 예외");
				// throw new RuntimeException("사용자 예외");
			}
			System.out.println("예외가 발생하면 도달하지 않는 문장.");
		} catch (IOException e) {
			System.out.println("IOException 처리 완료");
		} catch (Exception e) {
			System.out.println("Exception 예외 처리 완료");
		} finally {
			System.out.println("뭐가 됐든 반드시 출력되는 진입하는 공간.");
		}

	}

}
