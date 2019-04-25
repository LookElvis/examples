package CCF.C3;

import java.util.*;

/**
 * Created by liuxiang on 2019/2/28.
 */
public class C201412 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Map<Integer, String> map = new HashMap<>();
        int count = 1;
        while (input.hasNextLine()) {
            String s = input.nextLine();
            if(s.trim().length() == 0) {
                break;
            }

            if (s.contains("cancel")) {
                map.remove(Integer.parseInt(s.split(" ")[1]));
            } else {
                map.put(count, s);
            }
            count++;
        }

        Map<Double, Integer> buyMap = new TreeMap<>();
        Map<Double, Integer> sellMap = new TreeMap<>();
        Set<Integer> set = map.keySet();
        Iterator<Integer> it = set.iterator();
        Set<Double> priceSet = new HashSet<>();
        while (it.hasNext()) {
            String t = map.get(it.next());
            double a = Double.parseDouble(t.split(" ")[1]);
            int b = Integer.parseInt(t.split(" ")[2]);
            priceSet.add(a);
            if (t.contains("buy")) {
                if (buyMap.containsKey(a)) {
                    buyMap.put(a, buyMap.get(a) + b);
                } else {
                    buyMap.put(a, b);
                }
            } else {
                if (sellMap.containsKey(a)) {
                    sellMap.put(a, buyMap.get(a) + b);
                } else {
                    sellMap.put(a, b);
                }
            }
        }

        double result1 = 0;
        int result2 = 0;
        Iterator<Double> priceIt = priceSet.iterator();
        while (priceIt.hasNext()) {
            double p = priceIt.next();
            int r = 0;

            int temp1 = 0;
            Set<Double> s1 = buyMap.keySet();
            Iterator<Double> aa = s1.iterator();
            while (aa.hasNext()) {
                double ta = aa.next();
                if (ta >= p) {
                    temp1 += buyMap.get(ta);
                } else {
//                    break;
                }
            }

            int temp2 = 0;
            Set<Double> s2 = sellMap.keySet();
            Iterator<Double> bb = s2.iterator();
            while (bb.hasNext()) {
                double tb = bb.next();
                if (tb <= p) {
                    temp2 += sellMap.get(tb);
                } else {
//                    break;
                }
            }

            r = temp1 < temp2 ? temp1 : temp2;
            if (r > result2) {
                result1 = p;
                result2 = r;
            } else if (r == result2) {
                result1 = (p > result1 ? p : result1);
            }
        }

        System.out.println(String.format("%.2f", result1) + " " + result2);
    }
}

//buy 9.25 100
//buy 8.88 175
//sell 9.00 1000
//buy 9.00 400
//sell 8.92 400
//cancel 1
//buy 100.00 50