package com.codeit.ex04.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class StreamBasic01 {
    // 스트림(Stream)이란?
    // - 함수형 프로그래밍이 가능한 순수 함수 문법인 람다의 확장 기능으로 우아한 코딩(?)이 가능하다.
    // - 본래 용도는 데이터 분석용도로 개발된 기능으로 다른 분석용 언어에서 지원하는 다양한 기능을 내장화 하였다.
    // - 또한 내부적으로 병렬처리를 지원함으로써 더욱 빠르게 데이터 처리가 가능하다.
    //   -> java에서 유일한 공식적인 병렬처리 방법으로 알고는 있어야한다. (혹시 모를 대용량 병렬처리를 위해)

    // 스트림 병렬처리 : 내부적으로 알고리즘과 Thread를 자동으로 구성하여 병렬처리 가능하다. -> 자동화
    // Thread : 병렬처리가 가능하도록 도구 제공하고 알고리즘은 개발자가 구성 필요 -> 반자동

    // https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html

    public static void main(String[] args) {
        String[] strArray = {"abc", "bbb", "ccc", "abb", "bcc", "ddd"};

        // 스트림 선언
//        Stream<String> strStream = Stream.of("abc", "bbb", "ccc", "abb", "bcc", "ddd"); // 문자열 스트림 생성 방법
        Stream<String> strStream = Stream.of(strArray); // 문자열 스트림 생성 방법

        // forEach : 스트림을 반복하면서 Consumer를 호출하는 메서드
        // 단순 출력하는 방법
//        strStream.forEach(System.out::println);
        strStream.forEach(str -> System.out.print(str + ", "));
        System.out.println("------------------------------------------------------");

        // stream has already been operated upon or closed 에러 발생!!
        // -> 스트림은 한번 사용하면 close됨으로 재사용할수 없다!

        // 해결방법1 : Stream.of를 통해 계속 생성하면서 활용한다.
        // -> 스트림을 새로 열때 마다 오버레드 존재한다. (메모리 비용 + 변환 비용)
        strStream = Stream.of(strArray);
        strStream.forEach(str -> System.out.print(str + ", "));
        System.out.println("\n-------------------------------------------------");

        // 해결방법2 : Arrays나 List 스트림을 통해 생성하며 활용하는 방법
        // Arrays.stream, List.stream
        List<String> strList = new ArrayList<>(Arrays.asList(strArray));
        strList.stream().forEach(str -> System.out.print(str + ", ")); // stream()호출 할때 마다 스트림 생성
        strList.stream().forEach(str -> System.out.print(str + ", ")); // stream()호출 할때 마다 스트림 생성
        System.out.println("\n-------------------------------------------------");
        Arrays.stream(strArray).forEach(str -> System.out.print(str + ", "));
        Arrays.stream(strArray).forEach(str -> System.out.print(str + ", "));
        System.out.println("\n-------------------------------------------------");

        // sorted : 스트림 정렬하는 방법
        System.out.println("스트림 정렬");
        Stream.of(strArray).sorted().forEach(str -> System.out.print(str + ", "));
        System.out.println();
        Stream.of(strArray).sorted(Comparator.reverseOrder()).forEach(str -> System.out.print(str + ", "));
        System.out.println("\n-------------------------------------------------");

        // map : 순수함수를 호출하는 메서드, Function을 중간에 넣어 연산을 할수 있음
        System.out.println("대문자 변경");
        Stream.of(strArray).map((str)->str.toUpperCase()).forEach(str -> System.out.print(str + ", "));
        Stream.of(strArray).map(String::toUpperCase).forEach(str -> System.out.print(str + ", "));
        System.out.println("\n-------------------------------------------------");

        // filter : 스트림에서 특정 조건을 제거하는 필터링, Predicate 필요!
        System.out.println("a가 포함된 문자열 제거");
        Stream.of(strArray).filter((str)-> !str.contains("a")).forEach(str -> System.out.print(str + ", "));
        System.out.println("\n-------------------------------------------------");

        // allMatch : 스트림의 모든 객체가 조건에 매칭되는지 확인하는 기능
        // anyMatch : 스트림의 특정 객체가 조건에 매칭되는지 확인하는 기능
        // noneMatch : allMatch 반대, 스트림의 모든 객체가 조건에 매칭되지 않는지 확인하는 기능
        System.out.println("a가 포함된 문자열 ");
        System.out.println("allMatch : " + Stream.of(strArray).allMatch((str)-> str.contains("a")));
        System.out.println("anyMatch : " + Stream.of(strArray).anyMatch((str)-> str.contains("a")));
        System.out.println("noneMatch : " + Stream.of(strArray).noneMatch((str)-> str.contains("a")));
        System.out.println("---------------------------------------------");


        // distinct : 중복을 제거하는 기능
        String[] strArray2 = {"aaa", "bbb", "bbb", "ccc", "ccc", "ccc"};
        System.out.println("중복 제거");
        Stream.of(strArray2).distinct().forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------------");

        // 복합 예제1) 대문자 변경 + 중복제거
//        Stream.of(strArray2).map(String::toUpperCase).distinct().forEach(str -> System.out.print(str + ", "));
        Stream.of(strArray2).distinct().map(String::toUpperCase).forEach(str -> System.out.print(str + ", "));
        System.out.println("\n----------------------------------------------");

        // 복합예제2) 중복제거 + 대문자 변경 + 정렬
        Stream.of(strArray2).distinct().map(String::toUpperCase).sorted().forEach(str -> System.out.print(str + ", "));
        List<String> list = Stream.of(strArray2).distinct().map(String::toUpperCase).sorted().toList();
        System.out.println(list);


        Stream<String[]> strArrStrm2 = Stream.of(
                new String[]{"abc", "bbb", "ccc"},
                new String[]{"ABC", "bbb", "ddd"} );

        // 2차원 스트림을 만드는 가장 기본적인 방법
        Stream<Stream<String>> strStream2 = strArrStrm2.map(Arrays::stream);

        // flatMap : 2차원을 1차원으로 바꾸는 메소드
        System.out.println("2차원 스트림을 1차원으로 변경");
        Stream<String> strStream3 = strArrStrm2.flatMap(Arrays::stream);
        strStream3.forEach(s -> System.out.print(s + ","));
    }
}
