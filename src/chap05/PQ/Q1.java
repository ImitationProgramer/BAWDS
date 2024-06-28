package chap05.PQ;

import java.util.Scanner;

public class Q1 {


    static int factorial(int n) {
        int sum = 1;
        for (int i = n; i >= 1; i--)
            sum *= i;
        return sum;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요: ");
        int x = sc.nextInt();

        System.out.println(x + "의 팩토리얼은 " + factorial(x) + "입니다.");
    }
}
