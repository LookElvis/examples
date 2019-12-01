package LeetCode.WeekExam.Week165;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiang on 2019/11/24.
 */
public class M1271 {
    public static void main(String[] args) {
        int tomatoSlices = 2385088;
        int cheeseSlices = 164763;
        numOfBurgers(tomatoSlices, cheeseSlices);

    }
    public static List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> list = new ArrayList<>();
        int doubleChesse = 2 * cheeseSlices;
        if (doubleChesse < tomatoSlices) {
            int t = (tomatoSlices - doubleChesse) % 2;
            if (t == 0) {
                int tmp = (tomatoSlices - doubleChesse) / 2;
                if (tmp <= cheeseSlices) {
                    list.add(tmp);
                    list.add(cheeseSlices - tmp);
                }
            }
        } else if (doubleChesse == tomatoSlices) {
            list.add(0);
            list.add(cheeseSlices);
        }

        return list;
    }
}
