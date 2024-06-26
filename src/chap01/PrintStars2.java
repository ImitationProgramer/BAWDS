package chap01;
// *를 n개 출력하되 w개마다 줄바꿈(1)

import java.util.Scanner;

public class PrintStars2 {
    public static void main(String[] args) {
        System.out.println("*를 n개 출력하되 w개마다 줄을 바꿔서 출력합니다.");
        int n;
        int w;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("n값: ");
            n = sc.nextInt();
        } while (n <= 0);

        do {
            System.out.print("w값: ");
            w = sc.nextInt();
        } while (w <= 0 || w > n);
        for (int i = 0; i < n / w; i++)
            System.out.println("*".repeat(w));
        int rest = n % w;
        if (rest != 0)
            System.out.println("*".repeat(rest));
    }
}
