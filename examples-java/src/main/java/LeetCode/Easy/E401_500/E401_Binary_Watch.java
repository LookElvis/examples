package LeetCode.Easy.E401_500;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiang on 2018/11/9.
 */
public class E401_Binary_Watch {
    public static void main(String[] args) {

    }

    public List<String> readBinaryWatch(int num) {

        int total = 1 << 10; // 1024, there are 10 bits, max integer value is 2^10, or 1 << 10, or 1024
	        /*
							Visualize bits ?
							All possible integer numbers: from 0000 000000 to 1111 111111.
	        */
        List<String> result = new ArrayList<>();
        for (int i = 0; i < total; i++) { // exactly 1024 times
            if (Integer.bitCount(i) == num) { // count the number of bit 1 in its binary representation, if it's equal to num then we have a valid solution
                int hour = (i & 0b1111000000) >> 6; // take only the hour bits, don't forget to trim the rightmost 6 bits
                int minute = (i & 0b111111);
                if (hour >= 12 || minute > 59) continue; // continue if not valid hours or minutes
                String hourStr = String.valueOf(hour);
                String minuteStr = minute < 10 ? "0" + minute : String.valueOf(minute);
                result.add(hourStr + ":" + minuteStr);
            }
        }

        return result;
    }
}
