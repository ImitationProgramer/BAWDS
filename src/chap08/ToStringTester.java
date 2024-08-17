package chap08;


class A {
    // toString을 정의하지 않음
}

class B {
    int x;

    // 생성자
    B(int x) {
        this.x = x;
    }

    // toString
    public String toString() {
        return "B[" + x + "]";
    }
}

public class ToStringTester {

    public static void main(String[] args) {
        A a1 = new A();
        A a2 = new A();
        B b1 = new B(18);
        B b2 = new B(55);

        System.out.println("a1 = " + a1.toString());
        System.out.println("a1 = " + a2.toString());
        System.out.println("a1 = " + b1.toString());
        System.out.println("a1 = " + b2.toString());

    }
}
