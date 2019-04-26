package NetWork.test;


import NetWork.entity.Graph;
import NetWork.utils.OperateUtils;

/**
 * Created by liuxiang on 2018/12/16.
 */
public class LinesTest {
    public static void main(String[] args) throws Exception{
        //初始化图
        Graph graph = OperateUtils.initGraph();
        //发送信息
        String source1 = "node5";
        String dest1 = "node10";
        String message1 = "hello";
        OperateUtils.sendMessage(graph, source1, dest1, message1);

        //删除节点
        graph.deleteNode("node3");
        //发送信息
        String source2 = "node5";
        String dest2 = "node10";
        String message2 = "world";
        //启动路由维护
        OperateUtils.sendMessage(graph, source2, dest2, message2);
    }
}