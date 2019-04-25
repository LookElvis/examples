package NetWork.utils;


import NetWork.entity.Graph;
import NetWork.entity.Node;

import java.util.List;

/**
 * Created by liuxiang on 2018/12/16.
 */
public class OperateUtils {
    public static Graph initGraph() throws Exception{
        //读取文件data.txt
        List<String> list = FileUtils.readFile();
        //将String转化为node节点实体类
        List<Node> nodeList = NodeUtils.transferNode(list);
        //对node进行邻接点和路由表初始化
        boolean isInit = NodeUtils.initNeighbor(nodeList);
        //形成网络拓扑图
        Graph graph = GraphUtils.formGraph(nodeList);
        return graph;
    }

    public static void sendMessage(Graph graph, String source, String dest, String message) {
        String route = GraphUtils.routeAlgorithm(graph, source, dest, message);
        System.out.println("源点:" + source + "->目的节点:" + dest);
        System.out.println("路由: " + route);
        if (route.contains("->")) {
            System.out.println("信息(" + message + ")发送成功！");
        } else {
            System.out.println("信息(" + message + ")发送失败！");
        }

        System.out.println();
    }
}
