package chap01.PQ;

import java.util.Scanner;

public class Q1Q2Q3 {
    static int max4(int a, int b, int c, int d) {
        int max = a;
        if (b > max) max = b;
        if (c > max) max = c;
        if (d > max) max = d;
        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) min = b;
        if (c < min) min = c;
        if (d < min) min = d;
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("max4(3,2,6,9) = " + max4(3, 2, 6, 9));
        System.out.println("min3(6,3,1) = " + min3(6, 3, 1));
        System.out.println("min4(3,2,6,9) = " + min4(3, 2, 6, 9));
    }
}
