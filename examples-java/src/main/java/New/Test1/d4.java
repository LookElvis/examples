package New.Test1;

import java.util.Scanner;

/**
 * Created by Elvis on 2020/2/11.
 */
public class d4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String a = input.nextLine();
        String b = input.nextLine();
        System.out.println( longest(a, b));
    }

    public static int longest(String a, String b) {
        if (a.length() == 0 || b.length() == 0 || a == null || b == null) {
            return 0;
        }
        int indexA = 0;
        int indexB = 0;
        int count = 0;
        while (indexA < a.length() && indexB < b.length()) {
            if (a.charAt(indexA) == b.charAt(indexB)) {
                count++;
                indexA++;
                indexB++;
            } else {
                break;
            }
        }
        return count;
    }
}
