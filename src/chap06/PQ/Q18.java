package chap06.PQ;

import java.util.Scanner;

public class Q18 {

    //--- 도수정렬(배열 요솟값은 min이상 max이하) ---//
    static void countingSort(int[] a, int n, int min, int max) {
        int[] f = new int[max - min + 2];   // 누적 도수
        int[] b = new int[n];           // 작업용 목표 배열

        for (int i = 0; i < n; i++)
            f[a[i] - min]++;
        for (int i = 1; i <= max - min + 1; i++)
            f[i] += f[i - 1];
        for (int i = n - 1; i >= 0; i--)
            b[--f[a[i] - min]] = a[i];
        for (int i = 0; i < n; i++)
            a[i] = b[i];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("도수 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = sc.nextInt();
            } while (x[i] < 0);
        }

        int max = x[0];
        for (int i = 1; i < nx; i++)
            if (x[i] > max) max = x[i];

        int min = x[0];
        for (int i = 1; i < nx; i++)
            if (x[i] < min) min = x[i];

        countingSort(x, nx, min, max);    // 배열 x를 도수 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
