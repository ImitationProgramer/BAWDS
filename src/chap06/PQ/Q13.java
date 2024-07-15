package chap06.PQ;

import java.util.Scanner;

// 퀵 정렬(개선 버전 : 요솟수가 9이하이면 단순삽입정렬)
public class Q13 {

    //--- 배열의 요소 a[idx1]과 a[idx2]의 값을 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    //--- 단순삽입정렬 ---//
    static void insertionSort(int[] a, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            int temp = a[i];
            int j;
            for (j = i; j > left && a[j - 1] > temp; j--)
                a[j] = a[j - 1];
            a[j] = temp;
        }
    }

    //--- x[a], x[b], x[c]을 정렬(중앙값의 인덱스를 반환) ---//
    static int sort3elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a])
            swap(x, b, a);
        if (x[c] < x[b])
            swap(x, c, b);
        if (x[b] < x[a])
            swap(x, b, a);
        return b;
    }

    //--- 퀵 정렬 ---//
    static void quickSort(int[] a, int left, int right) {
        if (right - left < 9)                // 요솟수가 9보다 작으면
            insertionSort(a, left, right);  // 단순삽입정렬
        else {
            int pl = left;                  // 왼쪽 커서
            int pr = right;                 // 오른쪽 커서
            int m = sort3elem(a, pl, (pl + pr) / 2, pr);  // 맨앞 맨끝 중앙을 정렬
            int x = a[m];

            swap(a, m, right - 1);       // 가운데와 맨끝에서 2번째를 교환
            pl++;                           // 왼쪽 커서를 한칸 오른쪽으로
            pr -= 2;                        // 오른쪽 커서를 2칸 왼쪽으로

            do {
                while (a[pl] < x)
                    pl++;
                while (a[pr] > x)
                    pr--;
                if (pl <= pr)
                    swap(a, pl++, pr--);
            } while (pl <= pr);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, nx - 1);            // 배열 x를 퀵 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
