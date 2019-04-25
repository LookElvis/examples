package NetWork.utils;

import NetWork.entity.Graph;
import NetWork.entity.Node;

import java.util.*;

/**
 * Created by liuxiang on 2018/12/15.
 */
public class GraphUtils {
    //模拟最大重传次数
    private static int hip = 0;
    //形成网络拓扑图
    public static Graph formGraph(List<Node> nodeList) {
        Graph graph = new Graph();
        for (int i = 0; i < nodeList.size(); i++) {
            graph.addNode(nodeList.get(i).getNodeName(), nodeList.get(i));
        }
        return graph;
    }

    //路由算法
    public static String routeAlgorithm(Graph graph, String source, String dest, String message){
        if (!(graph.isContains(source) && graph.isContains(dest))) {
            return "源点或目的节点不存在!";
        }
        Node sNode = graph.getNodeMap().get(source);
        //往重传缓冲区和发送缓冲区里写入数据
        sNode.getRetransBuffer().add(message);
        sNode.getSendBuffer().add(message);
        Map<String, List<String>> route = sNode.getRoute();

        if(dest != null && !dest.equals("")){
            //目的节点不存在路由表中，则开启路由发现
            if(!route.containsKey(dest)){
                routeFinding(graph, source, dest);
            }

            //目的节点已存在路由表中，直接查路由表返回路径
            String way = route.get(dest).get(0);
            //判断该路径是否还存在
            boolean isPathExist = true;
            Map<String, Node> nodeMap = graph.getNodeMap();
            Set<String> keySet = nodeMap.keySet();
            String[] nodes = way.split("->");
            for (int i = 0; i < nodes.length; i++) {
                if (!keySet.contains(nodes[i])) {
                    isPathExist = false;
                }
            }

            //若路径存在则发送成功，返回路径并发送数据，清空重传缓存区和发送缓存区
            if (isPathExist) {
                sNode.getSendBuffer().poll();
                sNode.getRetransBuffer().poll();
                return way;
            }
            //若路径不存在
            else {
                //重传次数小于10则继续重新重传
                //获取重传缓冲区的数据
                if (hip < 5) {
                    String mes = sNode.getRetransBuffer().poll();
                    hip++;
                    System.out.println("重新传送中......");
                    routeAlgorithm(graph, source, dest, mes);
                }
                //若重传次数超过五次，则重新进行路由发现
                else {
                    System.out.println();
                    hip = 0;
                    NodeUtils.initNode(graph);
                    System.out.println("重新进行路由发现！");
                    System.out.println();
                    routeFinding(graph, source, dest);
                }
                //刷新路由表
                String table;
                try {
                    Map<String, List<String>> r = sNode.getRoute();
                    table = route.get(dest).get(0);

                } catch (NullPointerException e) {
                    table = "源点到目的节点没有可达路径！";
                }
                return table;
            }
        }
        //目的节点不在网络拓扑中
        else{
            return "目的节点不存在！";
        }
    }

    //路由请求表中没有能够直接到达目的节点的路径，开始路由发现
    public static void routeFinding(Graph graph, String source, String dest){
        Node sNode = graph.getNodeMap().get(source);
        //对网络拓扑进行广度优先搜索，寻找到达目的节点的最短路径
        Queue<Node> queue = new LinkedList<>();
        //目的节点不存在路由表中，通过邻接点继续寻找，先对邻接点的路由缓存表进行更新
        List<String> neighborNodes = sNode.getNeighborNode();
        Iterator<String> iterator = neighborNodes.iterator();
        while(iterator.hasNext()){
            String stemp = iterator.next();
            Node temp = graph.getNodeMap().get(stemp);
            temp.setSearch(new StringBuffer(source + "->" + temp.getNodeName()));
            queue.add(temp);
        }
        //进行路由发现
        routeFindingImp(graph, sNode, queue, dest);
    }

    //通过泛洪法进行路由发现
    public static void routeFindingImp(Graph graph, Node sNode, Queue<Node> queue, String dest){
        //广度优先搜索队列
        while(!queue.isEmpty()){
            Node tempNode = queue.poll();
            //模拟路由应答，true则说明找到了目的节点，false则说明还没找到，需要继续通过邻接点进行查找
            boolean flag = tempNode.isDestNode(dest);
            if(flag){
                //该邻接点为目的节点，将该邻接点的路由缓存表添加进源节点的路由表
                List<String> routeList = new ArrayList<String>();
                routeList.add(tempNode.getSearch().toString());
                sNode.getRoute().put(dest, routeList);
                //找到目的节点直接返回
                return;
            }
            //没找到目的节点，继续下面操作，设置邻居节点缓存，并将其加入队列
            List<String> neighborList = tempNode.getNeighborNode();
            Iterator<String> iterator = neighborList.iterator();
            //设置邻接点的路由缓存为当前节点的路由缓存加上邻接点名字
            while(iterator.hasNext()){
                //如果当前节点的路由缓存已经包含该邻接点，则不更新该节点路由缓存
                //因为该邻接点是当前节点的路由缓存来源处，避免成环
                String tempString = iterator.next();
                if (!tempNode.getSearch().toString().contains(tempString)) {
                    Node tempNode2 = graph.getNodeMap().get(tempString);
                    tempNode2.setSearch(new StringBuffer(tempNode.getSearch().toString() + "->" + tempNode2.getNodeName()));
                    //将邻居节点放入队列中，继续通过循环查找
                    queue.add(tempNode2);
                }
            }
        }
    }
}
