package chap01.PQ;

import java.util.Scanner;

public class Q7 {
    static int Gaus(int n) {
        int sum = 0;
        for (int i = 1; i <= n / 2; i++)
            sum += 1 + n;
        if (n % 2 != 0)
            sum += n / 2 + 1;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("1부터 n까지의 합을 구합니다.");
        int n = sc.nextInt();
        System.out.println("1부터 " + n + "까지의 합은 " + Gaus(n) + "입니다.");

    }
}
