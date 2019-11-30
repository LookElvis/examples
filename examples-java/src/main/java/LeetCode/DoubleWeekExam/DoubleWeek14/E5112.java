package LeetCode.DoubleWeekExam.DoubleWeek14;

import org.neo4j.cypher.internal.v3_4.functions.Collect;

import java.math.BigInteger;

/**
 * Created by Elvis on 2019/11/30.
 */
public class E5112 {
    public static void main(String[] args) {
        String num = "747823223228";
        System.out.println(toHexspeak(num));
    }

    public static String toHexspeak(String num) {
        BigInteger b = new BigInteger(num);
        String t = b.toString(16);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < t.length(); i++) {
            char s = t.charAt(i);
            s = s == '1' ? 'I' : s;
            s = s == '0' ? 'O' : s;
            if (s != 'a' && s != 'b' && s != 'c' && s != 'd' && s != 'e' && s != 'f' && s != 'I' && s != 'O') {
                return "ERROR";
            }
            sb.append(s);
        }



        return sb.toString().toUpperCase();
    }
}
