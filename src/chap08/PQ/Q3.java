package chap08.PQ;

import java.util.Comparator;

// 선형 리스트 클래스(꼬리 포인터도 관리)
public class Q3 {
    static class LinkedList<E> {
        private Node<E> head;       // 머리 포인터(머리 노드에 대한 참조)
        private Node<E> tail;       // 꼬리 포인터(꼬리 노드에 대한 참조)
        private Node<E> crnt;       // 선택 포인터(선택 노드에 대한 참조)

        //--- 생성자 ---//
        public LinkedList() {
            head = tail = crnt = null;
        }

        //--- 노드 검색 ---//
        public E search(E obj, Comparator<? super E> c) {
            Node<E> ptr = head;

            while (ptr != null) {
                if (c.compare(obj, ptr.data) == 0) {
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next;
            }
            return null;
        }

        //--- 머리에 노드를 삽입 ---//
        public void addFirst(E o) {
            boolean empty = (tail == null);
            Node<E> ptr = head;                     // 삽입 전의 머리 노드
            head = crnt = new Node<E>(o, ptr);
            if (empty)
                tail = crnt;
        }

        //--- 꼬리에 노드를 삽입 ---//
        public void addLast(E o) {
            if (head == null)        // 리스트가 비어 있으면
                addFirst(o);        // 머리에 삽입
            else {
                tail.next = crnt = new Node<E>(o, null);
                tail = crnt;
            }
        }

        //--- 머리 노드를 삭제 ---//
        public void removeFirst() {
            if (head != null) {       // 리스트가 비어 있지 않으면
                head = crnt = head.next;
                if (head == null)
                    tail = null;
            }
        }

        //--- 꼬리 노드를 삭제 ---//
        public void removeLast() {
            if (head != null) {
                if (head.next == null)       // 노드가 하나 뿐이면
                    removeFirst();          // 머리 노드를 삭제
                else {
                    Node<E> ptr = head;     // 스캔 중인 노드
                    Node<E> pre = head;     // 스캔 중인 노드의 앞쪽 노드

                    while (ptr.next != null) {
                        pre = ptr;
                        ptr = ptr.next;
                    }
                    pre.next = null;        // pre는 삭제 후의 꼬리 노드
                    tail = crnt = pre;
                }
            }
        }

        //--- 노드 p를 삭제 ---//
        public void remove(Node<E> p) {
            if (head != null) {
                if (p == head)           // p가 머리 노드이면
                    removeFirst();      // 머리 노드를 삭제
                else if (p == tail)     // p가 꼬리 노드이면
                    removeLast();       // 꼬리 노드를 삭제
                else {
                    Node<E> ptr = head;
                    while (ptr.next != p) {
                        ptr = ptr.next;
                        if (ptr == null)
                            return;         // p가 리스트에 없음
                    }
                    ptr.next = p.next;
                    crnt = ptr;
                }
            }
        }

        //--- 선택 노드를 삭제 ---//
        public void removeCurrentNode() {
            remove(crnt);
        }

        //--- 모든 노드를 삭제 ---//
        public void clear() {
            while (head != null)             // 노드에 아무것도 없을 때까지
                removeFirst();              // 머리 노드를 삭제
            crnt = null;
        }

        //--- 선택 노드를 하나 뒤쪽으로 진행 ---//
        public boolean next() {
            if (crnt == null || crnt.next == null)
                return false;               // 나아갈 수 없음
            crnt = crnt.next;
            return true;
        }

        //--- 선택 노드를 출력 ---//
        public void printCurrentNode() {
            if (crnt == null)
                System.out.println("선택한 노드가 없습니다.");
            else
                System.out.println(crnt.data.toString());
        }

        //--- 모든 노드를 출력 ---//
        public void dump() {
            Node<E> ptr = head;

            while (ptr != null) {
                System.out.println(ptr.data.toString());
                ptr = ptr.next;
            }
        }

        //---[연습8-1] 컴퍼레이터c로 서로 같은 노드를 찾아 모든 노드를 삭제 ---//
        public void purge(Comparator<? super E> c) {
            Node<E> ptr = head;

            while (ptr != null) {
                int count = 0;
                Node<E> ptr2 = ptr;
                Node<E> pre = ptr;

                while (pre.next != null) {
                    ptr2 = pre.next;
                    if (c.compare(ptr.data, ptr2.data) == 0) {
                        pre.next = ptr2.next;
                        count++;
                    } else
                        pre = ptr2;
                }
                if (count == 0)
                    ptr = ptr.next;
                else {
                    Node<E> temp = ptr;
                    remove(ptr);
                    ptr = temp.next;
                }
            }
            crnt = head;
        }

        //---[연습8-2]머리부터 n개 뒤 노드의 데이터에 대한 참조를 반환---//
        public E retrieve(int n) {
            Node<E> ptr = head;
            while (n >= 0 && ptr != null) {
                if (n-- == 0) {
                    crnt = ptr;
                    return ptr.data;    // 검색 성공
                }
                ptr = ptr.next;         // 다음 노드를 선택
            }
            return null;
        }

        //--- 노드 ---//
        class Node<E> {
            private E data;     // 데이터
            private Node<E> next;   // 뒤쪽 포인터(다음 노드에 대한 참조)

            //--- 생성자 ---//
            Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }
    }
}
