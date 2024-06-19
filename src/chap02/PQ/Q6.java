package chap02.PQ;

import java.util.Scanner;

public class Q6 {
    static void cardConv(int x, int r, char[] d){
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.println(r+"|      "+x);
        do{
            d[digits++] = dchar.charAt(x % r);
            x /= r;
            System.out.println(" + ----------");
            if(x!=0)
                System.out.println(r+"|      "+x+"   ..."+d[digits-1]);
            else
                System.out.println("        0   ..."+d[digits-1]);
        }while(x!=0);
        for(int i=0;i<digits/2;i++){
            char t = d[i];
            d[i] = d[digits-1-i];
            d[digits-1-i] = t;
        }
        System.out.print(r + "진수로 ");
        for(int i=0;i<digits;i++)
            System.out.print(d[i]);
        System.out.println("입니다.");
    }

    public static void main(String[] args) {
        int n;
        int cd;
        char[] cno = new char[32];
        Scanner sc = new Scanner(System.in);
        System.out.println("10진수를 기수 변환합니다.");
        do {
            System.out.print("변환하는 음이 아닌 정수: ");
            n = sc.nextInt();
        }while(n<=0);
        do{
            System.out.print("어떤 진수로 변환할까요? (2~36): ");
            cd = sc.nextInt();
        }while(cd<2||cd>36);
        cardConv(n,cd, cno);

    }
}
