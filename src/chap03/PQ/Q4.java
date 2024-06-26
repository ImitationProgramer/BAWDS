package chap03.PQ;

import java.util.Scanner;

public class Q4 {
    static int binSearchEx(int[] a, int n, int key) {
        System.out.print("   |");
        for (int k = 0; k < n; k++)
            System.out.printf("%4d", k);
        System.out.println();
        System.out.print("---+");
        for (int k = 0; k < 4 * n + 2; k++)
            System.out.print("-");
        System.out.println();
        int pl = 0;
        int pr = n - 1;
        do {
            int pc = (pl + pr) / 2;
            System.out.print("   |");
            if (pl != pc)
                System.out.printf(String.format("%%%ds<-%%%ds+",
                                (pl * 4) + 1, (pc - pl) * 4),
                        "", "");
            else
                System.out.printf(String.format("%%%ds<-+", pc * 4 + 1), "");
            if (pr != pc)
                System.out.printf(String.format("%%%ds->\n",
                        (pr - pc) * 4 - 2), "");
            else
                System.out.println("->");
            System.out.printf("%3d|", pc);
            for (int k = 0; k < n; k++)
                System.out.printf("%4d", a[k]);
            System.out.println("\n   |");
            if (a[pc] == key)
                return pc;
            else if (a[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("요솟수 : ");
        int num = sc.nextInt();
        int[] x = new int[num];

        System.out.println("오름차순으로 입력하세요.");
        System.out.print("x[0] : ");
        x[0] = sc.nextInt();
        for (int i = 1; i < num; i++) {
            do {
                System.out.print("x[" + i + "] : ");
                x[i] = sc.nextInt();
            } while (x[i] < x[i - 1]);
        }
        System.out.print("검색 값 : ");
        int key = sc.nextInt();

        int idx = binSearchEx(x, num, key);

        if (idx == -1)
            System.out.println("그 값의 요소는 존재하지 않습니다.");
        else
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
    }
}
