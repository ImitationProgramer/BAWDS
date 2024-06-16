package chap02;
// 배열 요소의 최댓값 출력(값을 난수로 생성)

import java.util.Random;
import java.util.Scanner;

public class MaxOfArrayRand {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max)
                max = a[i];
        return max;
    }

    // 배열 a의 최댓값을 구하여 반환
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("키의 최댓값을 구합니다.");
        int n;
        System.out.print("사람 수: ");
        n = sc.nextInt();
        int[] height = new int[n];
        System.out.println("킷값은 다음과 같습니다.");
        for (int i = 0; i < height.length; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "]: " + height[i]);
        }
        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}
