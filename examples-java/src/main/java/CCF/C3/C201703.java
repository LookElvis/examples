package CCF.C3;

import java.util.Scanner;

/**
 * Created by liuxiang on 2019/3/12.
 */
public class C201703 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String line = null;
        boolean isBlank = false;
        boolean isList = false;
        boolean isPara = false;
        String tempPara = "";

        while (input.hasNextLine()) {
            line = input.nextLine();

            //无序列表结束
            if (isList && line.isEmpty()) {
                isList = false;
                System.out.println("</ul>");
            }
            //段落结束
            if (isPara && line.isEmpty()) {
                isPara = false;
                System.out.println(tempPara + "</p>");
            }

            //标题
            if (line.contains("#")) {
                char[] t = line.split(" ")[0].toCharArray();
                int l = t.length;
                String pre = "<h" + l + ">";
                String suf = "</h" + l + ">";
                String content = line.replaceAll("#", "").trim();
                System.out.println(pre + content + suf);
            } else if (line.contains("*")) {  //无序列表
                if (isBlank) {  //无序列表开始
                    System.out.println("<ul>");
                }
                isList = true;
                String pre = "<li>";
                String suf = "</li>";
                String content = line.replaceAll("\\*", "").trim();
                System.out.println(pre + content + suf);
            } else { //段落
                if (isBlank) {  //段落开始
                    isPara = true;
                    tempPara = line;
                    System.out.println("<p>" + line);
                }
            }

            isBlank = line.isEmpty() ? true : false;
        }
    }
}
