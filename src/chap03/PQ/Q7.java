package chap03.PQ;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q7 {
    static class PhyscData {
        private String name;
        private int height;
        private double vision;

        // 생성자
        public PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        // 문자열로 만들어 반환하는 메서드
        public String toString() {
            return name + " " + height + " " + vision;
        }

        //시력의 내림차순용 comparator
        public static final Comparator<PhyscData> VISION_ORDER = new VisionOrderComparator();

        private static class VisionOrderComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision > d2.vision) ? -1 :
                        (d1.vision < d2.vision) ? 1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("황지안", 169, 0.8),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("박준서", 175, 2.0),
        };
        Arrays.sort(x, PhyscData.VISION_ORDER);
        System.out.print("검색할 시력은? : ");
        double vision = sc.nextDouble();
        int idx = Arrays.binarySearch(x, new PhyscData("", 0, vision), PhyscData.VISION_ORDER);
        if (idx < 0)
            System.out.println("그 값의 요소는 존재하지 않습니다.");
        else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("데이터 : " + x[idx]);
        }
    }
}
