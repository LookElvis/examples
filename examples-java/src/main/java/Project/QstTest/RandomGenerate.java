package Project.QstTest;

import java.util.Random;

/**
 * 随机生成模拟数据
 * Created by liuxiang on 2018/9/4.
 */
public class RandomGenerate {
    public static void main(String[] args) {
        Random random = new Random();

        String objId = "";
        for (int i = 0; i < 16; i++){
            objId += (char)(Math.random() * 26 + 97);
        }
        objId += System.currentTimeMillis();

        String upperClothing = "";
        upperClothing = random.nextInt(3) + "";

        String lowerClothing = "";
        lowerClothing = random.nextInt(3) + "";
        String coatStyle = "";
        int int_coatStyle = random.nextInt(3);
        coatStyle = switchColor(int_coatStyle);

        String trousersStyle = "";
        int int_trousersStyle = random.nextInt(3);
        trousersStyle = switchColor(int_trousersStyle);

        String sex = "";
        sex = random.nextInt(2) + "";

        String age = "";
        age = random.nextInt(41) + 20 + "";

        String angle = "";
        int int_angle = random.nextInt(4);
        angle = switchAngle(int_angle);

        String bag = "";
        bag = random.nextInt(4) + "";

        String umbrella = "";
        int int_umbrella = random.nextInt(3);
        umbrella = switchColor(int_umbrella);

        String featureType = "";
        for (int i = 0; i < 16; i++){
            featureType += (char)(Math.random() * 26 + 97);
        }
        Random ran = new Random(System.currentTimeMillis());
        featureType += ran.nextInt();

        String url = "/home/url-";
        url += Math.abs(random.nextInt());

        System.out.println(objId + " " + upperClothing + " " + lowerClothing + " " + coatStyle + " " + trousersStyle + " " +
        sex + " " + age + " " + angle + " " + bag + " " + umbrella + " " + featureType + " " + url);
    }

    public static String switchColor(int index) {
        switch (index) {
            case 0: return "红";
            case 1: return "蓝";
            case 2: return  "白";
            default: return null;
        }
    }

    public static String switchAngle(int index) {
        switch (index) {
            case 0: return "东";
            case 1: return "南";
            case 2: return  "西";
            case 3: return "北";
            default: return null;
        }
    }
}
