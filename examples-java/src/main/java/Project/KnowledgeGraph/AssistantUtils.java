package Project.KnowledgeGraph;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by liuxiang on 2019/8/3.
 */
public class AssistantUtils {
    public static void main(String[] args) throws Exception{
        File srcFile = new File("D:\\Data");
        String tmpPath = "D:\\Data\\tmp";
        boolean isFinished = true;
        String[] zipList = srcFile.list();

        for (int i = 0; i < zipList.length; i++) {
            String t = srcFile.toString() + File.separator + zipList[i];
            if (t.endsWith(".zip")) {
                File zipFile = new File(t);
                isFinished = isFinished && singleZip(zipFile, tmpPath);
                System.out.println(zipFile);
            }
        }

        System.out.println(isFinished);
    }

    //处理单个压缩文件
    public static boolean singleZip(File srcFile, String targetPath) throws Exception {
        boolean isDeleted = true;
        List<String> result = unZip(srcFile, targetPath);
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }

        System.out.println("-------------");

        isDeleted = deleteAllFile(targetPath);
        return isDeleted;
    }

    //解压文件
    public static List<String>  unZip(File srcFile, String targetPath) throws  Exception{
        List<String> list = new ArrayList<>();

        if (!srcFile.exists()) {
            throw new RuntimeException(srcFile.getPath() + "文件不存在!");
        }

        //开始解压
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(srcFile);
            Enumeration<?> entries = zipFile.entries();
            while (entries.hasMoreElements()) {
                ZipEntry entry = (ZipEntry) entries.nextElement();
                System.out.println("解压" + entry.getName());
                // 如果是文件夹，就创建个文件夹
                if (entry.isDirectory()) {
                    String dirPath = targetPath + "/" + entry.getName();
                    File dir = new File(dirPath);
                    dir.mkdirs();
                } else {
                    // 如果是文件，就先创建一个文件，然后用io流把内容copy过去
                    File targetFile = new File(targetPath + "/" + entry.getName());
                    // 保证这个文件的父文件夹必须要存在
                    if(!targetFile.getParentFile().exists()){
                        targetFile.getParentFile().mkdirs();
                    }
                    targetFile.createNewFile();
                    // 将压缩文件内容写入到这个文件中
                    InputStream is = zipFile.getInputStream(entry);
                    FileOutputStream out = new FileOutputStream(targetFile);
                    BufferedOutputStream bos = new BufferedOutputStream(out);
                    int len;
                    while ((len = is.read()) != -1) {
                        bos.write(len);
                    }
                    // 关流顺序，先打开的后关闭
                    bos.close();
                    is.close();
                    list.add(targetFile.toString());
                    System.out.println(targetFile + "解压成功!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("解压工具错误！", e);
        } finally {
            if(zipFile != null) {
                try {
                    zipFile.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return list;
    }

    //删除文件夹中所有文件
    public static boolean deleteAllFile(String path) {
        boolean flag = false;
        File file = new File(path);
        if (!file.exists()) {
            System.out.println("文件路径不存在！");
            return flag;
        }
        if (!file.isDirectory()) {
            System.out.println("文件路径非目录！");
            return flag;
        }
        String[] tempList = file.list();
        File temp = null;
        for (int i = 0; i < tempList.length; i++) {
            //该路径如果以分隔符例如/结尾则直接加上文件名
            if (path.endsWith(File.separator)) {
                temp = new File(path + tempList[i]);
            } else {  //否则先加上文件分隔符
                temp = new File(path + File.separator + tempList[i]);
            }
            //如果是文件则直接删除
            if (temp.isFile()) {
                temp.delete();
                System.out.println(temp + "删除成功！");
            }
            //如果是文件夹则继续递归调用函数进行删除
            if (temp.isDirectory()) {
                //删除文件夹里面的文件
                deleteAllFile(path + File.separator + tempList[i]);
                //删除空文件夹
                delFolder(path + File.separator + tempList[i]);
                flag = true;
            }
        }

        System.out.println(path + "删除成功！");
        return flag;
    }

    //删除文件夹
    public static void delFolder(String folderPath) {
        try {
            File file = new File(folderPath);
            file.delete();
            System.out.println(file.toString() + "删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
