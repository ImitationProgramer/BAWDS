package chap08;

import java.util.Scanner;

// 연결 리스트 클래스 LinkedList<E>의 사용 예
public class LinkedListTester {
    static Scanner sc = new Scanner(System.in);

    // 데이터(회원번호+이름)
    static class Data {
        static final int NO = 1; // 번호 입력 받기
        static final int NAME = 2;  // 이름 입력기
        private Integer no;     // 회원번호
        private String name;        // 이름

        // 문자열 출력을 반환
        public String toString() {
            return "(" + no + ") " + name;
        }

        
    }
}
