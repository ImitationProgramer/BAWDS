package chap03.PQ;

import java.util.Scanner;

public class Q5 {
    static int binSearchX(int[] a, int n, int key) {

        int pl = 0;
        int pr = n - 1;

        do {
            int pc = (pl + pr) / 2;
            if (a[pc] == key) {
                for (; pc > pl; pc--)
                    if (a[pc - 1] < key)
                        break;
                return pc;// 검색 성공
            } else if (a[pc] < key)
                pl = pc + 1;    // 검색 범위를 뒤쪽 절반으로 좁힘
            else
                pr = pc - 1;    // 검색 범위를 앞쪽 절반으로 좁힘
        } while (pl <= pr);
        return -1;              // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int n = sc.nextInt();
        int[] x = new int[n];
        System.out.println("오름차순으로 입력하세요.");
        System.out.print("x[0]: ");
        x[0] = sc.nextInt();
        for (int i = 1; i < n; i++) {
            do {
                System.out.print("x[" + i + "]: ");
                x[i] = sc.nextInt();
            } while (x[i] < x[i - 1]);        // 바로 앞의 요소보다 작으면 다시 입력받음
        }
        System.out.print("검색할 값: ");    // 키값을 입력받음
        int key = sc.nextInt();

        int idx = binSearchX(x, n, key);

        if (idx == -1)
            System.out.println("그 값의 요소가 없습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}

