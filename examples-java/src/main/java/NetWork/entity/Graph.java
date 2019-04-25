package NetWork.entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 网络拓扑图
 * Created by liuxiang on 2018/12/15.
 */
public class Graph {
    //存储拓扑中所有节点
    private Map<String, Node> nodeMap;

    //构造网络拓扑
    public Graph(){
        this.nodeMap = new HashMap<String, Node>();
    }

    public boolean isContains(String nodeName) {
        Set<String> keySet = this.nodeMap.keySet();
        return keySet.contains(nodeName);
    }

    //向网络拓扑中增加节点
    public void addNode(String nodeName, Node node){
        this.nodeMap.put(nodeName, node);
    }

    //从网络拓扑中删除节点
    public void deleteNode(String nodeName){
        System.out.println("节点:" + nodeName + "成功删除！");
        System.out.println();
        this.nodeMap.remove(nodeName);
    }

    public Map<String, Node> getNodeMap() {
        return nodeMap;
    }

    public void setNodeMap(Map<String, Node> nodeMap) {
        this.nodeMap = nodeMap;
    }
}
