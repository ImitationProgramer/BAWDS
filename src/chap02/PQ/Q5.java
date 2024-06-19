package chap02.PQ;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 {
    static void rcopy(int[] a, int[] b){
        for(int i=0;i<a.length;i++){
            a[i]=b[a.length-i-1];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0;i<n;i++){
            System.out.print("b["+i+"]: ");
            b[i] = sc.nextInt();
        }
        rcopy(a, b);
        System.out.println("역순으로 복사된 배열 a의 배열은 "+ Arrays.toString(a)+"입니다.");
    }
}
