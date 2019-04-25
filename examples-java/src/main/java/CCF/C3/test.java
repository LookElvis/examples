package CCF.C3;

/**
 * Created by liuxiang on 2019/3/2.
 */
public class test {
    public static void main(String[] args) {
//        for (int i = 0; i < 30; i++) {
//            int count1 = (i % 7 + 2) % 7;
//            int count2 = (i + 1) % 7 + 1;
//            if (count1 != count2) {
//                System.out.println(i + " " + count1 + " - " + count2);
//            }
//        }
//        String a = "e";
//        switch (a) {
//            default:
//                System.out.println("default");
//            case "a":
//                System.out.println("aaa");
//            case "b":
//                System.out.println("bbb");
//
//            case "d":
//                System.out.println("ddd");
//            case "f":
//                System.out.println("fff");
//
//        }
        int[][] m = new int[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        add(m, 1, 3);
        add(m, 1, 5);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void add(int[][] mat, int i, int j) {
        mat[i][j] = 3;
//        return mat;
    }
}
