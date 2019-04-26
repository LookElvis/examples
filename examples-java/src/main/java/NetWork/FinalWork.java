package NetWork;


import NetWork.entity.Graph;
import NetWork.utils.OperateUtils;

import java.util.Scanner;

/**
 * Created by liuxiang on 2018/12/16.
 */
public class FinalWork {
    public static void main(String[] args) throws Exception{
        System.out.println("输入请求格式如下(以空格分割，不要多加回车/空格)：");
        System.out.println("发送消息：send node5 node10 hello");
        System.out.println("删除节点：delete node3");
        Scanner input = new Scanner(System.in);
        Graph graph = OperateUtils.initGraph();
        while (input.hasNext()) {
            String data = input.nextLine();
            String[] splits = data.split(" ");
            if (splits.length == 2) {
                String nodeNum = splits[1];
                graph.deleteNode(nodeNum);
            } else if (splits.length == 4){
                String sNode = splits[1];
                String tNode = splits[2];
                String message = splits[3];
                OperateUtils.sendMessage(graph, sNode, tNode, message);
            } else {
                System.out.println("格式输入错误！");
            }
        }
    }
}
