package Common.RegexTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuxiang on 2019/3/15.
 */
public class DataFormate {
    public static void main(String[] args) {
        Date date = new Date(System.currentTimeMillis());
        DateFormat df = new SimpleDateFormat("EEEE-yyyy/MM/dd");
        String aa = df.format(date);
        System.out.println(aa);
    }
}
