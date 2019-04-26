package Common.FileTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuxiang on 2018/8/20.
 */
public class CopySourceCodeTest {
    public static List<String> fileList;

    public static void main(String[] args) throws Exception{
        fileList = new ArrayList<>();
        String path = "D:\\a";
        getFileList(path);
        for (String fileName: fileList) {
            if(fileName.contains(".java") || fileName.contains(".scala")) {
                //获得文件的.java或.scala名
                int index = fileName.lastIndexOf("\\") + 1;
                String name = fileName.substring(index);
                readAndWrite(fileName, name);
            }
        }
    }

    public static void readAndWrite(String fileName, String name) throws Exception{
        FileReader fr = new FileReader(fileName);
        BufferedReader br = new BufferedReader(fr);
        String writePath = "D:/sourceCode.doc";
        FileWriter fw = new FileWriter(writePath, true);

        String str = "*********************" + name + "**********************************************************************\r\n" + br.readLine();
        while (str != null) {
            //操作
            str += "\r\n";
            fw.write(str);
            str = br.readLine();
        }
        fw.close();
        br.close();
        fr.close();
    }

    public static List<String> getFileList(String strPath) {
        File f = new File(strPath);
        try {
            if(f.isDirectory()){
                File[] fs = f.listFiles();
                for(int i=0;i<fs.length;i++){
                    String fsPath=fs[i].getAbsolutePath();
//                    System.out.println(fsPath);
                    getFileList(fsPath);
                }
            }else if(f.isFile()){
                String fname=f.getAbsolutePath();
                fileList.add(fname);
//                System.out.println(fname);
            }else{
                System.out.println("路径不正确!");
            }
        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("遍历异常");
        }
        return fileList;
    }
}
