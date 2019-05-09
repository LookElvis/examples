package Algorithm.CCF.C3;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/11.
 */
public class C201609 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = input.nextLine();
        }

        //两位英雄的血量
        int blood1 = 30;
        int blood2 = 30;

        //两个玩家的随从数组
        Fellow[] f1 = new Fellow[7];
        Fellow[] f2 = new Fellow[7];

        //解析游戏过程
        int prior = 0;
        for (int i = 0; i < n; i++) {
            String t = s[i];
            if (t.equals("end")) {
                prior++;
                continue;
            }

            String[] ins = t.split(" ");
            //召唤
            if (ins[0].equals("summon")) {
                int pos = Integer.parseInt(ins[1]);
                int att = Integer.parseInt(ins[2]);
                int hel = Integer.parseInt(ins[3]);
                Fellow f = new Fellow(att, hel);
                //先手玩家
                if (prior % 2 == 0) {
                    moveRight(f1, f, pos - 1);
                } else {  //后手玩家
                    moveRight(f2, f, pos - 1);
                }
            } else if (ins[0].equals("attack")) {  //攻击
                int att = Integer.parseInt(ins[1]);
                int defender = Integer.parseInt(ins[2]);

                //攻击英雄
                if (defender == 0) {
                    //先手玩家
                    if (prior % 2 == 0) {
                        blood2 = blood2 - f1[att - 1].attack;
                        if (blood2 > 0) {
                            continue;
                        } else {
                            break;
                        }
                    } else {  //后手玩家
                        blood1 = blood1 - f2[att - 1].attack;
                        if (blood1 > 0) {
                            continue;
                        } else {
                            break;
                        }
                    }
                } else {  //攻击随从
                    //先手玩家
                    if (prior % 2 == 0) {
                        f1[att - 1].health -= f2[defender - 1].attack;
                        f2[defender - 1].health -= f1[att - 1].attack;
                        //随从死亡左移
                        if (f1[att - 1].health <= 0) {
                            moveLeft(f1, att - 1);
                        }
                        if (f2[defender - 1].health <= 0) {
                            moveLeft(f2, defender - 1);
                        }
                    } else {  //后手玩家
                        f2[att - 1].health -= f1[defender - 1].attack;
                        f1[defender - 1].health -= f2[att - 1].attack;
                        //随从死亡左移
                        if (f2[att - 1].health <= 0) {
                            moveLeft(f2, att - 1);
                        }
                        if (f1[defender - 1].health <= 0) {
                            moveLeft(f1, defender - 1);
                        }
                    }
                }
            }

//            //先手
//            System.out.print("health1:");
//            for (int m = 0; m < f1.length; m++) {
//                if (f1[m] != null) {
//                    System.out.print(f1[m].health + " ");
//                }
//            }
//            System.out.println();
//            //后手
//            System.out.print("health2:");
//            for (int m = 0; m < f2.length; m++) {
//                if (f2[m] != null) {
//                    System.out.print(f2[m].health + " ");
//                }
//            }
//            System.out.println();
//
//            System.out.println("hero1:" + blood1);
//            System.out.println("hero2:" + blood2);
        }

//        System.out.println("----------------");
        //输出结果
        if ((blood1 > 0) && blood2 > 0) {
            System.out.println(0);
        } else if (blood1 > 0){
            System.out.println(1);
        } else {
            System.out.println(-1);
        }
        System.out.println(blood1);
        int count1 = 0;
        for (int m = 0; m < f1.length; m++) {
            if (f1[m] != null && f1[m].health > 0) {
                count1++;
            }
        }
        System.out.print(count1);
        for (int m = 0; m < count1; m++) {
            System.out.print(" " + f1[m].health);
        }
        System.out.println();

        System.out.println(blood2);
        int count2 = 0;
        for (int m = 0; m < f2.length; m++) {
            if (f2[m] != null && f2[m].health > 0) {
                count2++;
            }
        }
        System.out.print(count2);
        for (int m = 0; m < count2; m++) {
            System.out.print(" " + f2[m].health);
        }
    }

    public static void moveLeft(Fellow[] fs, int pos) {
        for (int i = pos; i < fs.length - 1; i++) {
            if (fs[i] != null) {
                fs[i] = fs[i + 1];
            }
        }
    }

    public static void moveRight(Fellow[] fs, Fellow f, int pos) {
        for (int i = fs.length - 2; i >= pos; i--) {
            if (fs[i] != null) {
                fs[i + 1] = fs[i];
            }
        }
        fs[pos] = f;
    }

    public static class Fellow {
        int attack;
        int health;

        public Fellow (int attack, int health) {
            this.attack = attack;
            this.health = health;
        }
    }
}

//8
//summon 1 3 6
//summon 2 4 2
//end
//summon 1 4 5
//summon 1 2 1
//attack 1 2
//end
//attack 1 1