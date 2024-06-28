package chap05.PQ;

import java.util.Scanner;

public class Q7 {
    static String[] name = {"A 기둥", "B 기둥", "C 기둥"};

    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);
        System.out.println("원반[" + no + "]을 " + name[x - 1] + "에서 " + name[y - 1] + "으로 이동");

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("하노이의 탑");
        System.out.print("원반의 개수: ");
        int n = sc.nextInt();

        move(n, 1, 3);  // 1번 기둥에 쌓인 n개의 원반을 3번 기둥으로 옮김
    }
}
