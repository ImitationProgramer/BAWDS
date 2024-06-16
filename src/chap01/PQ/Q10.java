package chap01.PQ;

import java.util.Scanner;

// 양의 정수를 입력하고 자릿수를 출력하는 프로그램을 작성하세요.
public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("양의 정수를 입력하세요.");
        do {
            System.out.print("n: ");
            n = sc.nextInt();
        } while (n <= 0);
//       방법 1
//       String num = Integer.toString(n);
//       System.out.println("그 수는 " + num.length() + "자리입니다.");
        int count = 0;
        while (n != 0) {
            count++;
            n /= 10;
        }
        System.out.println("그 수는 " + count + "자리입니다.");
    }
}
