package chap05.PQ;

import java.util.Scanner;

public class Q5 {
    static int countRecur = 0;
    static int countRecurMemo = 0;
    static String[] memo;

    static void recur(int n) {
        countRecur++;
        if (n > 0) {
            recur(n - 1);
            System.out.println(n);
            recur(n - 2);
        }
    }

    static void recurMemo(int n) {
        countRecurMemo++;
        if (memo[n + 1] != null)
            System.out.print(memo[n + 1]);  // 메모를 출력
        else {
            if (n > 0) {
                recurMemo(n - 1);
                System.out.println(n);
                recurMemo(n - 2);
                memo[n + 1] = memo[n] + n + "\n" + memo[n - 1]; // 메모화
            } else {
                memo[n + 1] = "";   // 메모화: recur(0)과 recur(-1)은 빈 문자열
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int x = sc.nextInt();
        memo = new String[x + 2];
        recur(x);
        recurMemo(x);
        System.out.println(countRecur);
        System.out.println(countRecurMemo);
    }
}
