package chap04.PQ;

import java.util.Scanner;

public class Q7Tester {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q7.IntDeque s = new Q7.IntDeque(64);

        while (true) {
            System.out.printf("현재 데이터 개수 : %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1)맨앞에 인큐　(2)맨앞에서 디큐　(3)맨앞에서 피크\n" +
                    "(4)맨끝에 인큐　(5)맨끝에서 디큐　(6)맨끝에서 피크\n" +
                    "(7)덤프　(8)검색　(0) 종료 : ");

            int menu = sc.nextInt();
            if (menu == 0)
                break;
            int x = 0, idx;

            switch (menu) {
                case 1:
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try {
                        s.enqueFront(x);
                    } catch (Q7.IntDeque.OverflowIntDequeException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 2:
                    try {
                        x = s.dequeFront();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (Q7.IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 3:
                    try {
                        x = s.peekFront();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (Q7.IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;
                case 4:
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try {
                        s.enqueRear(x);
                    } catch (Q7.IntDeque.OverflowIntDequeException e) {
                        System.out.println("큐가 가득 찼습니다.");
                    }
                    break;

                case 5:
                    try {
                        x = s.dequeRear();
                        System.out.println("디큐한 데이터는 " + x + "입니다.");
                    } catch (Q7.IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 6:
                    try {
                        x = s.peekRear();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch (Q7.IntDeque.EmptyIntDequeException e) {
                        System.out.println("큐가 비어 있습니다.");
                    }
                    break;

                case 7:
                    s.dump();
                    break;

                case 8:
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    int n = s.search(x);
                    if (n != 0)
                        System.out.printf("%d번째 데이터로 인덱스%d의 위치에 저장되어 있습니다.\n", n, s.indexOf(x));
                    else
                        System.out.println("그 데이터는 등록되어 있지 않습니다.");
                    break;
            }
        }
    }
}
