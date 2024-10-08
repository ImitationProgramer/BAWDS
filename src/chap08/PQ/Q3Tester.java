package chap08.PQ;
// 연습 8-3
// 선행 리스트 클래스 LinkedListx<E>의 사용 예

import java.util.Comparator;
import java.util.Scanner;

public class Q3Tester {
    static Scanner sc = new Scanner(System.in);

    //--- 데이터(회원번호+이름) ---//
    static class Data {
        //--- 회원번호로 순서를 정하는 컴퍼레이터 ---//
        public static final Comparator<Data> NO_ORDER = new NoOrderComparator();
        //--- 이름으로 순서를 정하는 컴퍼레이터 ---//
        public static final Comparator<Data> NAME_ORDER = new NameOrderComparator();
        static final int NO = 1;            // 번호를 입력 받을까요?
        static final int NAME = 2;          // 이름을 입력 받을까요?
        private Integer no;                 // 회원번호
        private String name;                // 이름

        //--- 메뉴 선택 ---//
        static Menu SelectMenu() {
            int key;
            do {
                for (Menu m : Menu.values()) {
                    System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                    if ((m.ordinal() % 3) == 2 &&
                            m.ordinal() != Menu.TERMINATE.ordinal())
                        System.out.println();
                }
                System.out.print(" : ");
                key = sc.nextInt();
            } while (key < Menu.ADD_FIRST.ordinal() ||
                    key > Menu.TERMINATE.ordinal());
            return Menu.MenuAt(key);
        }

        public static void main(String[] args) {
            Menu menu;              // 메뉴
            Data data;              // 추가용 데이터 참조
            Data ptr;               // 검색용 데이터 참조
            Data temp = new Data(); // 입력용 데이터

            Q3.LinkedList<Data> list = new Q3.LinkedList<>();   // 리스트를 생성

            do {
                switch (menu = SelectMenu()) {
                    case ADD_FIRST:                // 머리에 노드를 삽입
                        data = new Data();
                        data.scanData("머리 삽입", Data.NO | Data.NAME);
                        list.addFirst(data);
                        break;

                    case ADD_LAST:                  // 꼬리 에 노드를 삽입
                        data = new Data();
                        data.scanData("꼬리에 삽입", Data.NO | Data.NAME);
                        list.addLast(data);
                        break;

                    case RMV_FIRST:                 // 머리 노드를 삭제
                        list.removeFirst();
                        break;

                    case RMV_LAST:                  // 꼬리 노드를 삭제
                        list.removeLast();
                        break;

                    case RMV_CRNT:                  // 선택 노드를 삭제
                        list.removeCurrentNode();
                        break;

                    case SEARCH_NO:                 // 회원 번호로 검색
                        temp.scanData("검색", Data.NO);
                        ptr = list.search(temp, Data.NO_ORDER);
                        if (ptr == null)
                            System.out.println("그 번호의 데이터가 없습니다.");
                        else
                            System.out.println("검색 성공 : " + ptr);
                        break;

                    case SEARCH_NAME:               // 이름으로 검색
                        temp.scanData("검색", Data.NAME);
                        ptr = list.search(temp, Data.NAME_ORDER);
                        if (ptr == null)
                            System.out.println("그 이름의 데이터가 없습니다.");
                        else
                            System.out.println("검색 성공 : " + ptr);
                        break;

                    case NEXT:                      // 선택 노드를 하나 뒤쪽으로 진행
                        list.next();
                        break;

                    case PRINT_CRNT:                // 선택 노드의 데이터를 출력
                        list.printCurrentNode();
                        break;

                    case DUMP:                      // 모든 노드를 리스트 순서로 출력
                        list.dump();
                        break;

                    case CLEAR:                     // 모든 노드를 삭제
                        list.clear();
                        break;

                    case PURGE_NO:                 // [연습8-1] 동일 번호의 노드를 삭제
                        list.purge(Data.NO_ORDER);
                        break;

                    case PURGE_NAME:               // [연습8-1]동일 이름의 노드를 삭제
                        list.purge(Data.NAME_ORDER);
                        break;

                    case RETRIEVE: {                 // [연습8-2] 특정 노드를 출력
                        System.out.println("머리부터 몇 번째 데이터를 출력할까요? : ");
                        int no = sc.nextInt() - 1;
                        ptr = list.retrieve(no);
                        if (ptr == null)
                            System.out.println("그 데이터는 존재하지 않습니다.");
                        else
                            System.out.println("그 데이터는 " + ptr.toString() + "입니다.");
                    }
                }
            } while (menu != Menu.TERMINATE);
        }

        //--- 문자열로 만들어 반환합니다 ---//
        public String toString() {
            return "(" + no + ") " + name;
        }

        //--- 데이터를 입력받음 ---//
        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if ((sw & NO) == NO) {
                System.out.print("번호 : ");
                no = sc.nextInt();
            }
            if ((sw & NAME) == NAME) {
                System.out.println("이름 : ");
                name = sc.next();
            }
        }

        //--- 메뉴 열거행 ---//
        public enum Menu {
            ADD_FIRST("머리에 노드를 삽입"),
            ADD_LAST("고리에 노드를 삽입"),
            RMV_FIRST("머리 노드를 삭제  "),
            RMV_LAST("꼬리 노드를 삭제   "),
            RMV_CRNT("선택 노드를 삭제   "),
            CLEAR("모든 노드를 삭제   "),
            SEARCH_NO("번호로 검색      "),
            SEARCH_NAME("이름으로 검색  "),
            NEXT("선택 노드를 진행  "),
            PRINT_CRNT("선택 노드를 출력"),
            PURGE_NO("동일 번호의 노드를 삭제"),
            PURGE_NAME("동일 이름의 노드를 삭제"),
            RETRIEVE("특정 노드를 출력"),
            DUMP("모든 노드를 출력"),
            TERMINATE("종료");

            private final String message;

            Menu(String string) {
                message = string;
            }

            static Menu MenuAt(int idx) {    // 순서가 idx인 열거를 반환합니다
                for (Menu m : Menu.values())
                    if (m.ordinal() == idx)
                        return m;
                return null;
            }

            String getMessage() {
                return message;
            }
        }

        private static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return (d1.no > d2.no) ? 1 :
                        (d1.no < d2.no) ? -1 : 0;
            }
        }

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2) {
                return d1.name.compareTo(d2.name);
            }
        }
    }
}
