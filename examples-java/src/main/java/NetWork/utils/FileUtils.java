package NetWork.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiang on 2018/12/15.
 */
public class FileUtils {
    public static List<String> readFile() throws Exception{
        //获取文本
        String path = FileUtils.class.getClassLoader().getResource("data.txt").getPath();
//        String inputStream = System.getProperty("user.dir");
//        String path = inputStream.concat("/data.txt");

        // 使用ArrayList来存储每行读取到的字符串
        List<String> list = new ArrayList<>();
        FileReader fr = new FileReader(path);
        BufferedReader bf = new BufferedReader(fr);
        String str;
        // 按行读取字符串
        while ((str = bf.readLine()) != null) {
            list.add(str);
        }
        bf.close();
        fr.close();

        return list;
    }
}
