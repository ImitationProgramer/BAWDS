package chap04.PQ;

import java.util.Scanner;

public class Q3Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q3.DoubleHeadIntStack s = new Q3.DoubleHeadIntStack(64);

        while (true) {
            System.out.println("현재 데이터 개수 : A : "
                    + s.size(Q3.DoubleHeadIntStack.AorB.StackA) +
                    "/B : " + s.size(Q3.DoubleHeadIntStack.AorB.StackB));
            System.out.print("(1) A 푸시 (2) A 팝 (3) A 피크 (4) A 덤프 (5) A 검색 (6) A 비움\n" +
                    "(7) B 푸시 (8) B 팝 (9) B 피크 (10) B덤프 (11) B 검색 (12) B 비움\n" +
                    "(13) 출력 (0) 종료 : ");
            int menu = sc.nextInt();
            if (menu == 0)
                break;
            int n, x = 0;
            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try {
                        s.push(Q3.DoubleHeadIntStack.AorB.StackA, x);
                    } catch (Q3.DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 2:
                    try {
                        x = s.pop(Q3.DoubleHeadIntStack.AorB.StackA);
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (Q3.DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 3:
                    try {
                        x = s.peek(Q3.DoubleHeadIntStack.AorB.StackA);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (Q3.DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 4:
                    s.dump(Q3.DoubleHeadIntStack.AorB.StackA);
                    break;
                case 5:
                    System.out.print("검색할 데이터 : ");
                    x = sc.nextInt();
                    n = s.indexOf(Q3.DoubleHeadIntStack.AorB.StackA, x);
                    if (n >= 0)
                        System.out.println("곡대기에서 " + (s.size(Q3.DoubleHeadIntStack.AorB.StackA) - n) + "번째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;
                case 6:
                    s.clear(Q3.DoubleHeadIntStack.AorB.StackA);
                    break;
                case 7:
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try {
                        s.push(Q3.DoubleHeadIntStack.AorB.StackB, x);
                    } catch (Q3.DoubleHeadIntStack.OverflowDoubleHeadIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;
                case 8:
                    try {
                        x = s.pop(Q3.DoubleHeadIntStack.AorB.StackB);
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch (Q3.DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 9:
                    try {
                        x = s.peek(Q3.DoubleHeadIntStack.AorB.StackB);
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (Q3.DoubleHeadIntStack.EmptyDoubleHeadIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;
                case 10:
                    s.dump(Q3.DoubleHeadIntStack.AorB.StackB);
                    break;
                case 11:
                    System.out.print("검색할 데이터 : ");
                    x = sc.nextInt();
                    n = s.indexOf(Q3.DoubleHeadIntStack.AorB.StackB, x);
                    if (n >= 0)
                        System.out.println("꼭대기에서 " + (s.size(Q3.DoubleHeadIntStack.AorB.StackB) - (s.getCapacity() - n) + 1) + "번째에 있습니다.");
                    else
                        System.out.println("그 데이터가 없습니다.");
                    break;
                case 12:
                    s.clear(Q3.DoubleHeadIntStack.AorB.StackB);
                    break;
                case 13:
                    System.out.println("용량 : " + s.getCapacity());
                    System.out.println("A의 데이터수 : " + s.size(Q3.DoubleHeadIntStack.AorB.StackA));
                    System.out.println("B의 데이터수 : " + s.size(Q3.DoubleHeadIntStack.AorB.StackB));
                    System.out.println("A는 비어 " + (s.isEmpty(Q3.DoubleHeadIntStack.AorB.StackA) ? "있습니다." : "있지 않습니다."));
                    System.out.println("B는 비어 " + (s.isEmpty(Q3.DoubleHeadIntStack.AorB.StackB) ? "있습니다." : "있지 않습니다."));
                    System.out.println("가득 차 " + (s.isFull() ? "있습니다" : "있지 않습니다."));
                    break;
            }
        }
    }
}
