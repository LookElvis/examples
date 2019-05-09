package Algorithm.CCF.C12;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/2/22.
 */
public class C201612_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int S = 0;
        int l = 0;
        int r = 0;

        if (T <= 3500) {
          S = T;
          System.out.println(S);
        } else if (T > 3500 && T <= 5000) {
            l = 3500;
            r = 8000;
            for (int i = l; i <= r; i += 100) {
                if (i <= 5000) {
                    S = (int) (i - (i - 3500) * 0.03);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                } else {
                    S = (int) (i - 45 - (i - 5000) * 0.1);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        } else if (T > 5000 && T <= 8000) {
            l = 5000;
            r = 12500;
            for (int i = l; i <= r; i += 100) {
                if (i <= 8000) {
                    S = (int) (i - 45 - (i - 5000) * 0.1);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                } else {
                    S = (int) (i - 45  - 300 - (i - 8000) * 0.2);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        } else if (T > 8000 && T <= 12500) {
            l = 8000;
            r = 38500;
            for (int i = l; i <= r; i += 100) {
                if (i <= 12500) {
                    S = (int) (i - 45  - 300 - (i - 8000) * 0.2);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                } else {
                    S = (int) (i - 45  - 300 - 900 - (i - 12500) * 0.25);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        } else if (T > 12500 && T <= 38500) {
            l = 12500;
            r = 58500;
            for (int i = l; i <= r; i += 100) {
                if (i <= 38500) {
                    S = (int) (i - 45  - 300 - 900 - (i - 12500) * 0.25);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                } else {
                    S = (int) (i - 45  - 300 - 900 - 6500 - (i - 38500) * 0.3);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        } else if (T > 38500 && T <= 58500) {
            l = 38500;
            r = 83500;
            for (int i = l; i <= r; i += 100) {
                if (i <= 58500) {
                    S = (int) (i - 45  - 300 - 900 - 6500 - (i - 38500) * 0.3);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                } else {
                    S = (int) (i - 45  - 300 - 900 - 6500 - 6000 - (i - 58500) * 0.35);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        } else if (T > 58500 && T <= 83500) {
            l = 58500;
            r = 160000;
            for (int i = l; i <= r; i += 100) {
                if (i <= 83500) {
                    S = (int) (i - 45  - 300 - 900 - 6500 - 6000 - (i - 58500) * 0.35);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                } else {
                    S = (int) (i - 45  - 300 - 900 - 6500 - 6000 - 8750 - (i - 83500) * 0.45);
                    if (S == T) {
                        System.out.println(i);
                        break;
                    }
                }
            }
        } else {
            l = 83500;
            r = 160000;
            for (int i = l; i <= r; i += 100) {
                S = (int) (i - 45  - 300 - 900 - 6500 - 6000 - 8750 - (i - 83500) * 0.45);
                if (S == T) {
                    System.out.println(i);
                    break;
                }
            }
        }

//        System.out.print(S);
    }
}
