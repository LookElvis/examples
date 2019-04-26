package Project.KnowledgeGraph;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by liuxiang on 2019/4/1.
 */
public class DataTransfer {
    static Map<String, String> map = new HashMap<>();
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws Exception{
        String readPath = "D:\\文档\\研究生\\工程\\四川移动自然语言处理\\开发阶段\\数据\\提取关系.txt";
//        FileReader fr = new FileReader(readPath);
//        BufferedReader br = new BufferedReader(fr);
        FileInputStream inputStream = new FileInputStream(readPath);
        InputStreamReader sr = new InputStreamReader(inputStream, "GBK");
        BufferedReader br = new BufferedReader(sr);

        String nodePath = "D:\\文档\\研究生\\工程\\四川移动自然语言处理\\开发阶段\\数据\\node.csv";
//        FileWriter nodeWriter = new FileWriter(nodePath);
        FileOutputStream nodeOutput = new FileOutputStream(nodePath);
        OutputStreamWriter nodeWriter = new OutputStreamWriter(nodeOutput, "GBK");

        String relationPath = "D:\\文档\\研究生\\工程\\四川移动自然语言处理\\开发阶段\\数据\\relationship.csv";
//        FileWriter relationWriter = new FileWriter(relationPath);
        FileOutputStream relationOutput = new FileOutputStream(relationPath);
        OutputStreamWriter relationWriter = new OutputStreamWriter(relationOutput, "GBK");

        nodeWriter.write("name:ID,:LABEL");
        relationWriter.write(":START_ID,:TYPE,:END_ID");

        String str = br.readLine();
        while (str != null) {
            String result;
            //操作
            if (str.charAt(0) == 'T') {
                result = dealNode(str);
                if (!result.equals("")) {
                    nodeWriter.write("\n" + result);
                }
            } else {
                result = dealRel(str);
                relationWriter.write("\n" + result);
            }

            System.out.println(result);
            str = br.readLine();
        }

        nodeWriter.close();
        relationWriter.close();
        br.close();
        sr.close();

        System.out.println("Transfer success!");
    }

    public static String dealNode(String str) {
        String id = str.split("\t")[0].split(" ")[0];
        String label = str.split("\t")[1].split(" ")[0];
//        System.out.println("label:" + label);
        String name = str.split("\t")[2];
        map.put(id, name);
        if (set.contains(name)) {
            return "";
        } else {
            set.add(name);
            return name + "," + label;
        }
    }

    public static String dealRel(String str) {
        String relation = str.split("\t")[1].split(" ")[0];
        String source = str.split("\t")[1].split(" ")[1].split(":")[1];
        String target = str.split("\t")[1].split(" ")[2].split(":")[1];
        String sourceName = "";
        String targetName = "";
        if (map.containsKey(source) && map.containsKey(target)) {
            sourceName = map.get(source);
            targetName = map.get(target);
        } else {
            System.out.println("The order of Data is wrong!");
        }
        return sourceName + "," + relation + "," + targetName;
    }
}
