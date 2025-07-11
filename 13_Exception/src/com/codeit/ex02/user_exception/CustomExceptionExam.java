package com.codeit.ex02.user_exception;

public class CustomExceptionExam {

    public static void main(String[] args) {
        // Java에 예외지만 사용자 예외로 자주 사용되는 리스트
        
        // 1. IllegalArgumentException
        throw new IllegalArgumentException("잘못된 메서드 인자를 전달했습니다.");

        // 2. IllegalStateException
        // throw new IllegalStateException("객체 상태가 잘못되었습니다.");

        // 3. UnsupportedOperationException
        // throw new UnsupportedOperationException("지원하지 않는 기능입니다.");

        // 4. NoSuchElementException
        // throw new java.util.NoSuchElementException("요소가 존재하지 않습니다.");

        // 5. NumberFormatException
        // throw new NumberFormatException("문자열을 숫자로 변환할 수 없습니다.");

        // 6. SecurityException
        // throw new SecurityException("보안 위반이 발생했습니다.");

        // 7. IOException (체크 예외라 throws 필요)
        // try {
        //     throw new java.io.IOException("입출력 오류가 발생했습니다.");
        // } catch (java.io.IOException e) {
        //     e.printStackTrace();
        // }

        // 8. SQLException (체크 예외라 throws 필요)
        // try {
        //     throw new java.sql.SQLException("데이터베이스 오류가 발생했습니다.");
        // } catch (java.sql.SQLException e) {
        //     e.printStackTrace();
        // }

        // 9. ParseException (체크 예외라 throws 필요)
        // try {
        //     throw new java.text.ParseException("문자열 파싱 오류가 발생했습니다.", 0);
        // } catch (java.text.ParseException e) {
        //     e.printStackTrace();
        // }
    }
}
