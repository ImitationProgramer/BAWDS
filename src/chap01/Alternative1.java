package chap01;

import java.util.Scanner;

public class Alternative1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("+와 -를 번갈아 n개 출력합니다.");
        System.out.print("n값: ");
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                System.out.print("-");
            else
                System.out.print("+");
        }
    }
}
