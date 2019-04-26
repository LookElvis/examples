package NetWork.entity;

import java.util.*;

/**
 * 通信节点
 * Created by liuxiang on 2018/12/15.
 */
public class Node {
    private String nodeName;  //节点名
    private List<String> neighborNode;  //邻居节点
    private StringBuffer search;  //路由缓存，存储在路由发现过程中源节点到本节点的路径
    private Map<String, List<String>> route;;  //路由请求表，存储目的地址和到达目的地址的多条路由，初始为空
    private Queue<String> sendBuffer;  //发送缓冲区，临时存储发送路由请求之后，收到路由应答请求之前的分组信息
    private Queue<String> retransBuffer;  //重传缓冲区，临时存储发出数据中，需要ack回复的分组信息
    private int x;  //节点坐标x
    private int y;  //节点坐标y
    private int radius;  //节点覆盖半径

    public Node(String nodeName, int x, int y, int radius) {
        this.nodeName = nodeName;
        this.neighborNode = new ArrayList<>();
        this.search = new StringBuffer();
        this.route = new HashMap<String, List<String>>();
        this.sendBuffer = new LinkedList<>();
        this.retransBuffer = new LinkedList<>();
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    //节点构造初始化，根据邻居节点初始化路由表，存储了到邻居节点的完整路径
    public void initRoute(){
        Iterator<String> iterator = neighborNode.iterator();
        while(iterator.hasNext()){
            List<String> temp = new ArrayList<String>();
            String key = iterator.next();
            String value = this.nodeName + "->" + key;
            temp.add(value);
            this.getRoute().put(key, temp);
        }
    }

    //判断邻接点是否为目的节点，如果是则返回true并对目的节点的路由缓存表进行更新，否则返回false
    public boolean isDestNode(String dest){
        Iterator<String> iterator = neighborNode.iterator();
        while(iterator.hasNext()){
            String temp = iterator.next();
            if(temp.equals(dest)){
                this.search.append("->" + temp);
                return true;
            }
        }
        return false;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public List<String> getNeighborNode() {
        return neighborNode;
    }

    public void setNeighborNode(List<String> neighborNode) {
        this.neighborNode = neighborNode;
    }

    public StringBuffer getSearch() {
        return search;
    }

    public void setSearch(StringBuffer search) {
        this.search = search;
    }

    public Map<String, List<String>> getRoute() {
        return route;
    }

    public void setRoute(Map<String, List<String>> route) {
        this.route = route;
    }

    public Queue<String> getSendBuffer() {
        return sendBuffer;
    }

    public void setSendBuffer(Queue<String> sendBuffer) {
        this.sendBuffer = sendBuffer;
    }

    public Queue<String> getRetransBuffer() {
        return retransBuffer;
    }

    public void setRetransBuffer(Queue<String> retransBuffer) {
        this.retransBuffer = retransBuffer;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
}
