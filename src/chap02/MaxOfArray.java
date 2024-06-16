package chap02;
// 배열 요소의 최댓값 출력(값을 입력받음)

import java.util.Scanner;

public class MaxOfArray {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    // 배열 a의 최댓값을 구하여 반환
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("키의 최댓값을 구합니다.");
        int n;
        System.out.print("사람 수: ");
        n = sc.nextInt();
        int[] height = new int[n];
        for (int i = 0; i < height.length; i++) {
            System.out.print("height[" + i + "]: ");
            height[i] = sc.nextInt();
        }
        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}
