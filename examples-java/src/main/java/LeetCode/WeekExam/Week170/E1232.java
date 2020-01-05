package LeetCode.WeekExam.Week170;

/**
 * Created by Elvis on 2020/1/5.
 */
public class E1232 {
    public static void main(String[] args) {
        System.out.println('a' + 10);
        System.out.println((char) 97);
//        System.out.println((int) '1');
//        System.out.println(freqAlphabets());
    }

    public static String freqAlphabets(String s) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '#') {
                i = i - 2;
                int t = Integer.parseInt(chars[i] + "" + chars[i + 1]);
                System.out.println(t);
                sb.append((char) ('a' + t - 1));
            } else {
                int t = Integer.parseInt(chars[i] + "");
                System.out.println(t);
                sb.append((char) ('a' + t - 1));
            }
        }
        return sb.reverse().toString();
    }
}
