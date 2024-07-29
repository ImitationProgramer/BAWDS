package chap08.PQ;

import java.util.Comparator;

// 선형 리스트 클래스(메서드 purge와 retrieve를 추가)
public class Q1Q2 {
    static class LinkedList<E> {

        private Node<E> head;       // 머리 포인터(머리 노드에 대한 참조)
        private Node<E> crnt;       // 선택 포인터(선택 노드에 대한 참조)
        //--- 생성자 ---//
        public LinkedList() {
            head = crnt = null;
        }

        //--- 노드 검색 ---//
        public E search(E obj, Comparator<? super E> c) {
            Node<E> ptr = head;         // 현재 스캔 중인 노드

            while (ptr != null) {
                if (c.compare(obj, ptr.data) == 0) {   // 검색 성공
                    crnt = ptr;
                    return ptr.data;
                }
                ptr = ptr.next;             // 다음 노드를 선택
            }
            return null;                    // 검색 실패
        }

        //--- 머리에 노드를 삽입 ---//
        public void addFirst(E obj) {

        }

        //--- 노드 ---//
        class Node<E> {
            private E data;         // 데이터
            private Node<E> next;   // 뒤쪽 포인터(다음 노드에 대한 참조)

            //--- 생성자 ---//
            Node(E data, Node<E> next) {
                this.data = data;
                this.next = next;
            }
        }
    }
}
