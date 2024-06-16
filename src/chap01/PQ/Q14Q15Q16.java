package chap01.PQ;

import java.util.Scanner;

public class Q14Q15Q16 {
    static void triangleLB(int n) {// 왼쪽 아래가 직각인 이등변 삼각형을 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }

    static void triangleLU(int n) {// 왼쪽 위가 직각인 이등변 삼각형을 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRU(int n) {// 오른쪽 위가 직각인 이등변삼각형을 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j <= n - i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void triangleRB(int n) {// 오른쪽 아래가 직각인 이등변삼각형을 출력
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void npria(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= (i - 1) * 2 + 1; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.print("몇 단을 원합니까?: ");
        n = sc.nextInt();
        triangleLB(n);
        System.out.println("------------------");
        triangleLU(n);
        System.out.println("------------------");
        triangleRU(n);
        System.out.println("------------------");
        triangleRB(n);
        System.out.println("------------------");
        spira(n);
        System.out.println("------------------");
        npria(n);
    }
}
