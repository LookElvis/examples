package New.Test1;


import java.util.Scanner;

/**
 * Created by Elvis on 2020/2/6.
 */
public class d1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int count = 0;
        String[] arr = new String[num];
        for (int i = 0; i < num; i++) {
            String t = input.next();
            if (i == 0) {
                arr[count++] = t + t;
            } else {
                boolean isTrue = false;
                for (int j = 0; j < count; j++) {
                    if (isSub(t, arr[j])) {
                        isTrue = true;
                        break;
                    }
                }
                if (!isTrue) {
                    arr[count++] = t + t;
                }
            }
        }
        System.out.println(count);
    }

    public static boolean isSub(String str2, String str1) {
        if (str1.length() == str2.length())
            return false;
        if (str1.contains(str2) && str1.length() == str2.length() * 2)
            return true;
        return false;
    }
}
