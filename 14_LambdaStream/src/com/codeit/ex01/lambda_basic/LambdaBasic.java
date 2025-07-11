package com.codeit.ex01.lambda_basic;

// 람다식이란? (Java8 부터 활용)
// - 함수형 프로그래밍이 가능한 순수 함수 문법
// - 메서드를 하나의 식(반드시 입력과 출력이 있는 식)으로 표현 가능한 문법
// - 기존 익명 클래스로 가능한 방법이었으나 그 문법을 간편화하여 구성
public class LambdaBasic {
    public static void main(String[] args) {
        // 기존의 익명클래스로 MyLambda를 구현하는 방법

        MyLambda1 f0 = new MyLambda1() {
            @Override
            public void run() {
                System.out.println("MyLambda1 call!!");
            }
        };
        f0.run();

        // 람다 기본형 : (param1, param2 ...) -> { ~~~ }
        // -> 중괄호를 사용시 여러줄의 내용을 작성할수 있다.
        MyLambda1 f1 = () -> {
            System.out.println("MyLambda1 call!! 1");
            System.out.println("MyLambda1 call!! 2");
        };
        f1.run();

        // 람다 단축표현1 - {...} 표현이 한줄일때 중괄호 생략 가능!!
        MyLambda1 f2 = () -> System.out.println("MyLambda1 call!! 3");
        f2.run();

        // 람다 단축표현2 - 인자가 한개일때는 (~~) 괄호도 생략 가능!
//        MyLambda1 f3 =  -> System.out.println("MyLambda1 call!! 3"); // 안된다!
//        MyLambda2 f3 = (msg) -> System.out.println("MyLambda2 msg : "+ msg);
        MyLambda2 f3 = msg -> System.out.println("MyLambda2 msg : "+ msg);
        f3.print("Hello World!");

        // 여러 파라메터 + 반환값이 있는 람다식 활용
        MyLambda3 f4 = (a, b) -> {return a + b;};

        // 람다 단축표현3 - return값이 한줄이면 return 도 생략 가능!!
        MyLambda3 f5 = (a, b) -> a * b; // return이 생략된 표현
        int result1 = f5.calc(10, 20);
        System.out.println("result1 = " + result1);


        // 람다 함수의 메서드 인자 활용
        MyLambda3 f6 = (a, b) -> a * b;
        int result2 = staticMethod(f6, 30, 50);
        System.out.println(result2);

        // 직접 람다를 선언하여 인자로 활용하는 방법
        int result3 = staticMethod((a, b)-> a / b, 40, 20);

        // 익명 클래스 버전!
        int result4 = staticMethod(new MyLambda3() {
            @Override
            public int calc(int a, int b) {
                return a * b;
            }
        }, 10, 20);
        System.out.println(result4);

        // 메서드 참조 : '::'를 통해 메서드를 호출하는 방법, static 메서드만 가능!
        int result5 = staticMethod(MethodRef::sum, 10, 20);
        System.out.println(result5);
        int result6 = staticMethod(MethodRef::multiply, 10, 20);
        System.out.println(result6);
        int result7 = staticMethod(Integer::sum, 10, 20);
        System.out.println(result7);
        int result8 = staticMethod(Math::multiplyExact, 10, 20);
        System.out.println(result8);

        // 생성자 람다 활용
        MyMember member = staticMethod2(MyMember::new);
        System.out.println(member);

        MyMember member2 = staticMethod3(MyMember::new, "홍길동", 21);
        System.out.println(member2);
    }


    public static int staticMethod(MyLambda3 f, int a, int b) {
        return f.calc(a, b);
    }
    public static MyMember staticMethod2(MyLambdaCreatable creatable){
        return creatable.createMember();
    }
    public static MyMember staticMethod3(MyLambdaCreatable2 creatable, String name, int age){
        return creatable.createMember(name, age);
    }
}


















