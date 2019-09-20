package Common.FileTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * Created by liuxiang on 2018/8/23.
 */
public class BytesOperator {
    public static void main(String[] args) throws Exception{
        //读入
        File file = new File("D:\\Test.txt");
        FileInputStream inputStream = new FileInputStream(file);
        //逐字节读入
        int l = 0;
        while ((l = inputStream.read()) != -1) {
            System.out.println((char) l);
        }
        inputStream.close();
        //按字节数组读入
//        byte[] bytes = new byte[inputStream.available()];
//        inputStream.read(bytes);
//        String string = new String(bytes);
//        System.out.println(string);
//        inputStream.close();

        //写出
        File file2 = new File("D:\\Result.txt");
        FileOutputStream outputStream = new FileOutputStream(file2);
        String test = "test1 test2";
        byte[] bytes2 = test.getBytes();
        //逐字节写出
        for(int i = 0; i < bytes2.length; i++) {
            outputStream.write(bytes2[i]);
        }
        outputStream.close();
        //按字节数组写出
//        outputStream.write(bytes2);
//        outputStream.close();
    }
}