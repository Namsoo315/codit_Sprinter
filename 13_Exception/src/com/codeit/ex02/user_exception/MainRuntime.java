package com.codeit.ex02.user_exception;

public class MainRuntime {

    public static void main(String[] args) {
        // 로그인 기능 예시
        // 사용자에게 입력 받아온 id, pw값
        String inputId = "test";
        String inputPw = "1234";
        
        boolean isLogin = false;

        // RuntimeException으로 만드는 경우 예외처리는 필요없으나 실제는 예외 발생 가능성 존재
        // -> 일관적 처리와 전가 규칙을 사용하는 경우 코드가 깔끔할수 있다.
        // -> Spring에서는 RuntimeException으로 처리해야 AOP 단순화나 트랜잭션 rollback 처리가 가능
        isLogin = loginRuntime(inputId, inputPw);
        if(isLogin){
            System.out.println("로그인이 완료 되었습니다.");
        }
    }

    // RuntimeException 인경우 throws 문도 생략 가능
    private static boolean loginRuntime(String inputId, String inputPw) /*throws LoginExceptionRuntime*/ {
        // 실제 DB에서 조회된 id, pw
        String memberId = "test";
        String memberPw = "1234";

        if(inputId == null || inputId.isEmpty()){
            throw new LoginExceptionRuntime(LoginErrorCode.NOT_INPUT_ID);
        }
        if(inputPw == null || inputPw.isEmpty()) {
            throw new LoginExceptionRuntime(LoginErrorCode.NOT_INPUT_PW);
        }
        if(!inputId.equals(memberId)) {
            throw new LoginExceptionRuntime(LoginErrorCode.WRONG_ID);
        }
        if(!inputPw.equals(memberPw)) {
            throw new LoginExceptionRuntime(LoginErrorCode.WRONG_PW);
        }
        // DB가 에러난 경우
//        throw new LoginException(LoginErrorCode.DB_ERROR);
        return true;
    }
}
