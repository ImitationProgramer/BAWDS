package chap02.PQ;

import java.util.Arrays;
import java.util.Scanner;

public class Q2 {
    static void swap(int[] a, int indx1, int indx2) {
        int temp = a[indx1];
        a[indx1] = a[indx2];
        a[indx2] = temp;
    }

    static void reverse(int[] a){
        int i = 0;
        do {
            System.out.println(Arrays.toString(a));
            System.out.println("a["+i+"]과 a["+(a.length-i-1)+"]을 교환합니다.");
            swap(a, i, a.length-i-1);
            i++;
        }while(i<a.length/2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int num = sc.nextInt();
        int[] x = new int[num];
        for(int i=0;i<num;i++){
            System.out.print("x["+i+"]: ");
            x[i] = sc.nextInt();
        }

        reverse(x); // 배열 a의 요소를 역순으로 정렬

        System.out.println(Arrays.toString(x));
        System.out.println("역순 정렬을 마쳤습니다.");
    }
}
