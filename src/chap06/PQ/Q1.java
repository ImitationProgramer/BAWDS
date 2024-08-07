package chap06.PQ;

import java.util.Scanner;

public class Q1 {

    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void bubbleSortR(int[] a, int n) {
        for (int i = n - 1; i > 0; i--)
            for (int j = 0; j < i; j++)
                if (a[j] > a[j + 1])
                    swap(a, j, j + 1);

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("버블 정렬(버전1)");
        System.out.print("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }

        bubbleSortR(x, nx); // 배열 x를 버블 정렬
        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]: " + x[i]);
    }
}
