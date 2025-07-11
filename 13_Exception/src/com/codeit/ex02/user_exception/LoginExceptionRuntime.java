package com.codeit.ex02.user_exception;


// RuntimeException 상속 예제 ★★★★★
// - 언체크드 예외 (Unchecked Exception)
// - Spring에서는 해당 방법이 선호됨으로 반드시 알고 있을것

public class LoginExceptionRuntime extends RuntimeException {
    private final LoginErrorCode errorCode;

    public LoginExceptionRuntime(LoginErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public LoginErrorCode getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return errorCode.getCause();
    }

    @Override
    public void printStackTrace() {
        System.err.println("로그인에 실패하였습니다.");
        System.err.println("원인 : " + errorCode.getCause());
        super.printStackTrace();
    }
}
