package Project.QstTest;

/**
 * 生成多条数据
 * Created by liuxiang on 2018/9/4.
 */
public class GenerateLines {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        int line = 1000;
        for (int i = 0; i < line; i++) {
            RandomGenerate.main(args);
        }
        long b = System.currentTimeMillis();
        long interval = b - a;
        System.out.println("Generate " + line + " lines use interval time: " + interval + " millis");
    }
}
