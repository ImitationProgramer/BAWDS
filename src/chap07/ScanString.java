package chap07;

import java.util.Scanner;

public class ScanString {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("문자열 s : ");
        String s = sc.next();

        for (int i = 0; i < s.length(); i++)
            System.out.println("s[" + i + "] = " + s.charAt(i));
    }
}
