package Common.Other;

import java.math.BigDecimal;

/**
 * Created by liuxiang on 2019/10/22.
 */
public class BigDecimalTest {
    public static void main(String[] args) {
        BigDecimal bg1 = new BigDecimal("12.0");
        BigDecimal bg2 = new BigDecimal("12.00");
        BigDecimal bg3 = new BigDecimal("12.000");

        int i1 = bg1.hashCode();
        int i2 = bg2.hashCode();
        int i3 = bg3.hashCode();

        String str1 = "HashCode of " + bg1 + " is " + i1;
        String str2 = "HashCode of " + bg2 + " is " + i2;
        String str3 = "HashCode of " + bg3 + " is " + i3;

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println(new BigDecimal("0.1"));
        System.out.println(new BigDecimal(0.1));

        System.out.println(new BigDecimal("0.1").hashCode());
        System.out.println(new BigDecimal(0.1).hashCode());


//        long LONG_MASK = 0xffffffffL;
//        long intCompact = Integer.MAX_VALUE + 1111;
//        System.out.println(Integer.MAX_VALUE+"dd");
//        int scale = 2;
//        long val2 = (intCompact < 0)? -intCompact : intCompact;
//        System.out.println(val2);
//        int temp = (int)( ((int)(val2 >>> 32)) * 31  +
//                (val2 & LONG_MASK));
//        System.out.println(((int)(val2 >>> 32)) * 31);
//        System.out.println(val2 & LONG_MASK);
//        System.out.println(temp);
////        return 31*((intCompact < 0) ?-temp:temp) + scale;
//        System.out.println(31*((intCompact < 0) ?-temp:temp) + scale);





    }

}