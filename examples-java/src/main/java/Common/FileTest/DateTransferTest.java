package Common.FileTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by liuxiang on 2018/8/8.
 */
public class DateTransferTest {
    public static void main(String[] args) throws Exception{
        String readPath = "D:/test.txt";
        FileReader fr = new FileReader(readPath);
        BufferedReader br = new BufferedReader(fr);
        String writePath = "D:/BpnnDayPredictTest.txt";
        FileWriter fw = new FileWriter(writePath);

        String str = br.readLine();
        while (str != null) {
            //操作
            str += "\r\n";
            String[] ss = str.split("\t");
            str = ss[0] + "\t" + ss[1] + "\t" + ss[4];
            System.out.println(str);
//            str = str.replaceAll("/", "-");
            fw.write(str);
            str = br.readLine();
        }

        fw.close();
        br.close();
        fr.close();
    }
}
