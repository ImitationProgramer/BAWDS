package chap07;

import java.util.Scanner;

public class CompareString2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("문자열 s1 : ");
        String s1 = sc.next();
        System.out.print("문자열 s2 : ");
        String s2 = sc.next();

        int comp = s1.compareTo(s2);
        if (comp < 0)
            System.out.println("s1 < s2 입니다.");
        else if (comp > 0)
            System.out.println("s1 > s2 입니다.");
        else
            System.out.println("s1 == s2 입니다.");
    }
}
