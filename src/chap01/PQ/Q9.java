package chap01.PQ;

import java.util.Scanner;

// 변수 b에 입력한 값이 a값 이하면 변수 b값을 다시 입력하세요.
public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a;
        int b;
        System.out.print("a값: ");
        a = sc.nextInt();
        System.out.print("b값: ");
        b = sc.nextInt();
        while (a >= b) {
            System.out.println("a보다 큰 값을 입력하세요!");
            System.out.print("b값: ");
            b = sc.nextInt();
        }
        System.out.println("b-a는 " + (b - a) + "입니다.");
    }
}
