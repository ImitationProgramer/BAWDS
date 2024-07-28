package chap07;

import java.util.Scanner;

public class SubString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 s : ");
        String s = sc.next();
        System.out.print("시작 인덱스 begin : ");
        int begin = sc.nextInt();
        System.out.print("종료 인덱스 end   : ");
        int end = sc.nextInt();

        System.out.println("s.substring(begin)         = " + s.substring(begin));
        System.out.println("s.substring(begin, end)    = " + s.substring(begin, end));
    }
}
