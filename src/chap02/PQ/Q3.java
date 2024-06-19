package chap02.PQ;

import java.util.Scanner;

public class Q3 {
    static int sumOf(int[] a){
        int sum = 0;
        for (int i : a) sum += i;
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("x["+i+"]: ");
            a[i] = sc.nextInt();
        }
        System.out.println("요소의 합계는 "+sumOf(a)+"입니다.");

    }
}
