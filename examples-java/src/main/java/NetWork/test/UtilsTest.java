package NetWork.test;



import NetWork.entity.Graph;
import NetWork.entity.Node;
import NetWork.utils.FileUtils;
import NetWork.utils.GraphUtils;
import NetWork.utils.NodeUtils;

import java.util.List;

/**
 * Created by liuxiang on 2018/12/15.
 */
public class UtilsTest {
    public static void main(String[] args) throws Exception{
        //读取文件data.txt测试
        List<String> list = FileUtils.readFile();
        //遍历文件中的内容
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
        //将String转化为node节点实体类
        List<Node> nodeList = NodeUtils.transferNode(list);
//        System.out.println(nodeList.get(3).getRetransBuffer());

        //对node进行邻接点和路由表初始化
        boolean isInit = NodeUtils.initNeighbor(nodeList);
//        System.out.println(nodeList.get(1).getNeighborNode().get(1));
//        System.out.println(nodeList.get(1).getRoute().get("node4").get(0));

        //形成网络拓扑图
        Graph graph = GraphUtils.formGraph(nodeList);
//        System.out.println(graph.getNodeMap().get("node1").getY());

        //模拟发送数据，进行路由发现
        String result = GraphUtils.routeAlgorithm(graph, "node2", "node4", "hello");
        System.out.println(result);
    }
}
