package chap06.PQ;

import java.util.Scanner;

public class Q10_1 {
    // 셀 정렬
    static int shellShort(int[] a, int n) {
        int cnt = 0;
        for (int h = n / 2; h > 0; h /= 2)
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h) {
                    a[j + h] = a[j];
                    cnt++;
                }
                a[j + h] = tmp;
                cnt++;
            }
        return cnt;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("셸 정렬(버전 1)");
        System.out.print("요솟수: ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }
        int count = shellShort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]= " + x[i]);
        System.out.println("요소의 이동 횟수는 " + count + "회입니다.");
    }
}
