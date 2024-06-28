package chap05;

import chap04.IntStack;

import java.util.Scanner;

public class RecurX2 {

    static void recur(int n) {
        IntStack s = new IntStack(n);
        while (true) {
            if (n > 0) {
                s.push(n);              // n값을 푸시
                n = n - 1;
                continue;
            }
            if (s.isEmpty() != true) {  // 스택이 비어 있지 않으면
                n = s.pop();            // 저장하고 있던 스택값을 팝
                System.out.println(n);
                n = n - 2;
                continue;
            }
            break;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수를 입력하세요 : ");
        int x = sc.nextInt();

        recur(x);
    }
}
