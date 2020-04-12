package New.Test9;

/**
 * Created by Elvis on 2020/4/12.
 */
public class demo4 {
    /**
     * 获取最大可同事办公员工数
     * @param pos char字符型二维数组 工位分布
     * @return int整型
     */
    public int GetMaxStaffs (char[][] pos) {
        int[][][] arr = new int[pos.length + 2][pos[0].length + 2][2];
        // 1代表放，0代表不放
        int res = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j = 2; j < arr[i].length; j++) {
                if (pos[i - 2][j - 2] == '*') {
                    arr[i][j][0] = 0;
                    arr[i][j][1] = 0;
                } else if (pos[i - 2][j - 2] == '.') {
                    int t1 = Math.max(arr[i - 1][j][0], arr[i][j - 1][0]);
                    int t2 = Math.max(arr[i - 1][j][1], arr[i][j - 1][1]);
                    arr[i][j][0] = Math.max(t1, t2);
                    int m1 = Math.max(arr[i - 2][j][0], arr[i][j - 2][0]);
                    int m2 = Math.max(arr[i - 2][j][1], arr[i][j - 2][1]);
                    int m3 = Math.max(arr[i - 1][j -1][0], arr[i - 1][j -1][1]);
                    int m4 = Math.max(m1, m2);
                    arr[i][j][1] = Math.max(m3, m4) + 1;
                }
            }
        }
        return Math.max(arr[arr.length - 1][arr[0].length - 1][0], arr[arr.length - 1][arr[0].length - 1][1]);
    }
}
