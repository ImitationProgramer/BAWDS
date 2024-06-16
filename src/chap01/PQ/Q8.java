package chap01.PQ;
// a와 b의 대소 관계에 상관없이 합을 구하세요.

import java.util.Scanner;

public class Q8 {
    static int sumof(int a, int b) {
        int sum = 0;
        if (a <= b)
            for (int i = a; i <= b; i++)
                sum += i;
        else
            for (int i = b; i <= a; i++)
                sum += i;

        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("a부터 b까지의 합을 구합니다.");
        System.out.print("a값:");
        int a = sc.nextInt();
        System.out.print("b값:");
        int b = sc.nextInt();

        System.out.println(a + "부터 " + b + "까지의 합은 " + sumof(a, b) + "입니다.");

    }
}
