package chap07;

import java.util.Scanner;

// 브루트-포스법으로 문자열 검색
public class BFmatch {
    // 브루트-포스법으로 문자열을 검색하는 메서드
    static int bfMatch(String txt, String pat) {
        int pt = 0;         // txt 커서
        int pp = 0;         // pat 커서

        while (pt != txt.length() && pp != pat.length()) {
            if (txt.charAt(pt) == pat.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if (pp == pat.length())  // 검색 성공
            return pt - pp;
        return -1;              // 검색 실패
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("텍스트: ");
        String s1 = sc.next();  // 텍스트용 문자열

        System.out.print("패 턴: ");
        String s2 = sc.next();      // 패턴용 문자열

        int idx = bfMatch(s1, s2);  // 문자열 s1에서 문자열 s2를 검색

        if (idx == -1)
            System.out.println("텍스트에 패턴이 없습니다.");
        else {
            // 일치하는 문자 바로 앞까지의 문자 개수를 반각 문자롤 환산하여 구함
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i + 1).getBytes().length;
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트: " + s1);
            System.out.printf(String.format("패 턴: %%%ds\n", len), s2);
        }
    }
}
