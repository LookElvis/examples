package Common.FileTest;

import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * Created by liuxiang on 2018/8/27.
 */
public class CharacterOperator {
    public static void main(String[] args) throws Exception{
//        FileReader fr = new FileReader("D:\\Test.txt");
        //使用转换流指定编码表
        FileInputStream inputStream = new FileInputStream("D:\\Test.txt");
        InputStreamReader sr = new InputStreamReader(inputStream, "GBK");
        int l = 0;
        while ((l = sr.read()) != -1) {
            System.out.print((char) l);
        }
        sr.close();

//        FileWriter fw = new FileWriter("D:\\result.txt");
//        //使用转换流指定编码表
////        FileOutputStream outputStream = new FileOutputStream("D:\\result.txt");
////        OutputStreamWriter sr = new OutputStreamWriter(outputStream, "UTF-8");
//        String test = "test1 test2 测试1";
//        fw.write(test);
//        fw.close();
    }
}
