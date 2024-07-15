package chap06.PQ;

import chap06.PhyscExamSort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q15 {
    static final int VMAX = 21;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhyscData[] x = {
                new PhyscData("강민하", 162, 0.3),
                new PhyscData("김찬우", 173, 0.7),
                new PhyscData("박준서", 175, 2.0),
                new PhyscData("유서범", 171, 1.5),
                new PhyscData("이수연", 168, 0.4),
                new PhyscData("장경오", 174, 1.2),
                new PhyscData("황지안", 169, 0.8),
        };

        Arrays.sort(x, PhyscData.VISION_DESC);
        System.out.println("■ 신체검사 리스트 ■");
        System.out.println("이름     키    시력");
        System.out.println("-----------------");
        for (int i = 0; i < x.length; i++)
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
    }

    static class PhyscData {


        static final Comparator<PhyscData> VISION_DESC = new VisionDescComparator();
        String name;
        int height;
        double vision;

        PhyscData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        public String toString() {
            return name + " " + height + " " + vision;
        }

        private static class VisionDescComparator implements Comparator<PhyscData> {
            public int compare(PhyscData d1, PhyscData d2) {
                return (d1.vision < d2.vision) ? 1 :
                        (d1.vision > d2.vision) ? -1 : 0;
            }
        }
    }

}
