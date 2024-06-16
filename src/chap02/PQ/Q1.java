package chap02.PQ;

import java.util.Random;
import java.util.Scanner;

public class Q1 {


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
        System.out.println("키의 최댓값을 구합니다.");
        int n;
        System.out.print("사람 수는 다음과 같습니다. ");
        n = 1 + rand.nextInt(10);
        System.out.println("사람 수: " + n);
        int[] height = new int[n];
        System.out.println("킷값은 다음과 같습니다.");
        for (int i = 0; i < height.length; i++) {
            height[i] = 100 + rand.nextInt(90);
            System.out.println("height[" + i + "]: " + height[i]);
        }
        System.out.println("최댓값은 " + maxOf(height) + "입니다.");
    }
}

