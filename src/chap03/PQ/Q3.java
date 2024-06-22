package chap03.PQ;

import java.util.Arrays;
import java.util.Scanner;

public class Q3 {
    static int searchIdx(int[] a, int n, int key, int[] idx) {
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (a[i] == key)
                idx[j++] = i;
        }
        System.out.println(Arrays.toString(idx));
        return j;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num];
        int[] idx = new int[num];
        for (int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = sc.nextInt();
        }
        System.out.print("검색할 값: ");
        int key = sc.nextInt();
        int idxn = searchIdx(x, num, key, idx);
        System.out.println(idxn);
    }
}
