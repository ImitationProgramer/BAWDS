package chap06.PQ;

import java.util.Scanner;

public class Q16 {

    //--- 배열의 요소 a[idx1]과 a[idx2]를 교환 ---//
    static void swap(int[] a, int idx1, int idx2) {
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //--- 2의 n乗을 구합니다 ---*/
    static int pow2(int n) {
        int k = 1;

        while (n-- > 0)
            k *= 2;
        return k;
    }

    //--- n개의 스페이스(공백문자)를 출력 ---//
    static void dispSpace(int n) {
        for (int i = 0; i < n; i++)
            System.out.print(' ');
    }

    //--- 힙을 출력 ---//
    static void dispHeap(int a[], int n) {
        int i = n;
        int height = 1;                        // 트리의 높이
        while ((i >>= 1) > 0)
            height++;
        i = 0;
        int w = 1;
        Loop:
        {
            for (int level = 0; level < height; level++) {
                dispSpace(pow2(height - level) - 2);
                for (int k = 0; k < w; k++) {
                    System.out.printf("%02d", a[i++]);
                    if (i >= n) break Loop;
                    if (k < w - 1)
                        dispSpace(pow2(height - level + 1) - 2);
                }
                System.out.println();

                dispSpace(pow2(height - level) - 3);
                for (int k = 0; k < w; k++) {
                    if (2 * k + i < n) System.out.print("/");
                    if (2 * k + i + 1 < n) System.out.print("\\");
                    if (k < w - 1)
                        dispSpace(pow2(height - level + 1) - 4);
                }
                System.out.println();
                w *= 2;
            }
        }
        System.out.println();
        System.out.println();
    }

    //--- a[left]~a[right]을 힙으로 만들기 ---//
    static void downHeap(int[] a, int left, int right) {
        int temp = a[left];        // 루트
        int child;                        // 큰 쪽의 자식
        int parent;                        // 부모

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;        // 왼쪽 자식
            int cr = cl + 1;                        // 오른쪽 자식
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl;    // 큰 쪽
            if (temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    //--- 힙 정렬 ---//
    static void heapSort(int[] a, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {        // a[i]~a[n-1]을 힙으로 만들기
            dispHeap(a, n);
            downHeap(a, i, n - 1);
        }

        for (int i = n - 1; i > 0; i--) {
            swap(a, 0, i);                    // 최대 요소와 아직 정렬되지 않은 부분의 맨끝 요소를 교환
            dispHeap(a, n);
            downHeap(a, 0, i - 1);            // a[0]~a[i-1]을 힙으로 만들기
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("힙 정렬");
        System.out.print("요솟수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        heapSort(x, nx);    // 배열 x를 힙 정렬

        System.out.println("오름차순으로 정렬하였습니다.");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]＝" + x[i]);
    }
}
