package New.Test7;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by Elvis on 2020/4/7.
 */
public class demo3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(); // n只怪物
        int D = input.nextInt(); //勇者初始防御
        List<Monster> list = new ArrayList<>();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            arr[i][1] = input.nextInt();
        }
        for (int i = 0; i < n; i++) {
            list.add(new Monster(arr[i][0], arr[i][1]));
        }

        List<Monster> res = list.stream()
                .sorted(Comparator.comparing(Monster::getDefeat).thenComparing(Monster::getHurt))
                .collect(Collectors.toList());
        int hurtCount = 0;
        for (Monster m : res) {
//            System.out.println(m.getDefeat() + " " + m.getHurt());
            if (D >= m.getDefeat()) {
                D++;
            } else {
                hurtCount += m.getHurt();
            }
        }
        System.out.println(hurtCount);
    }
}

class Monster {
    private int defeat;
    private int hurt;
    public Monster(int d, int h) {
        defeat = d;
        hurt = h;
    }

    public int getDefeat() {
        return defeat;
    }

    public void setDefeat(int defeat) {
        this.defeat = defeat;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }
}
