package Common.RegexTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by liuxiang on 2019/3/15.
 */
public class PatternAndMatcher {
    public static void main(String[] args) {
        String s = "iphone xs max高清壁纸";
//        String[] strings = s.split("\\d+");
//        for (int i = 0; i < strings.length; i++) {
//            System.out.println(strings[i]);
//        }

        Pattern p = Pattern.compile("sm.*");
        String result = s.trim();
        Matcher matcher = p.matcher(result);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }


    }
}
