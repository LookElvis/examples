package LeetCode.WeekExam.Week164;

/**
 * Created by liuxiang on 2019/11/24.
 */
public class E1266 {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {559,511},{932,618}
        };
        System.out.println(minTimeToVisitAllPoints(points));
    }

    public static int minTimeToVisitAllPoints(int[][] points) {
        if (points.length == 1) {
            return 0;
        }

        int count = 0;
        int pre = points[0][0];
        int suf = points[0][1];
        for (int i = 1; i < points.length; i++) {
            int p = points[i][0];
            int s = points[i][1];

            int preMin = Math.abs(p - pre);
            int sufMin = Math.abs(s - suf);

            int min = Math.min(preMin, sufMin);
            int other = Math.abs(preMin - sufMin);
            count = count + min + other;

            pre = p;
            suf = s;
        }

        return count;
    }
}
