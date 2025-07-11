package com.codeit.ex01.lambda_basic;

@FunctionalInterface // 하나의 추상 메서드가 있는 것을 확인하는 어노테이션, 생략도 가능하지만, 사용자가 정의할때 있는게 좋다.
public interface MyLambda1 {
    void run();
}
