package LeetCode.WeekExam.Week164;


import LeetCode.PublicClass.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by liuxiang on 2019/11/24.
 */
public class W3 {
    public static void main(String[] args) {
        String[] products = {"havana"};
        String searchWord = "tatiana";
        List<List<String>> list = suggestedProducts(products, searchWord);
        Utils.printDoubleArrays(list);
    }

    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> list = new ArrayList<>(searchWord.length());

        List<String> tList;
        for (int i = 0; i < searchWord.length(); i++) {
            String t = searchWord.substring(0, i + 1);

            List<String> gList = new ArrayList<>();
            for (int j = 0; j < products.length; j++) {
                if (products[j].startsWith(t)) {
                    gList.add(products[j]);
                }
            }

            Collections.sort(gList);

            tList = new ArrayList<>();
            for (int k = 0; k < 3 && k < gList.size(); k++) {
                tList.add(gList.get(k));
            }

            list.add(tList);
        }

        return list;
    }
}
