package NetWork.utils;



import NetWork.entity.Graph;
import NetWork.entity.Node;

import java.util.*;

/**
 * Created by liuxiang on 2018/12/15.
 */
public class NodeUtils {
    //将String转化为node
    public static List<Node> transferNode(List<String> list) {
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            String[] data = list.get(i).split(" ");
            String nodeName = data[0];
            int x = Integer.parseInt(data[1]);
            int y = Integer.parseInt(data[2]);
            int radius = Integer.parseInt(data[3]);
            Node node = new Node(nodeName, x, y, radius);
            nodeList.add(node);
        }

        return nodeList;
    }

    //对Node的邻接点和路由表进行初始化
    public static boolean initNeighbor(List<Node> nodeList) {
        //初始化邻接点
        for (int i = 0; i < nodeList.size() - 1; i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                if (i != j) {
                    Node x = nodeList.get(i);
                    Node y = nodeList.get(j);
                    int dist = (x.getX() - y.getX()) * (x.getX() - y.getX()) +
                            (x.getY() - y.getY()) * (x.getY() - y.getY());
                    boolean isArea = Math.sqrt(dist) <= (x.getRadius() + y.getRadius()) ? true : false;
                    if (isArea) {
                        nodeList.get(i).getNeighborNode().add(y.getNodeName());
                        nodeList.get(j).getNeighborNode().add(x.getNodeName());
                    }
                }
            }
        }

        //初始化路由表
        for (int m = 0; m < nodeList.size(); m++) {
            nodeList.get(m).initRoute();
        }
        return true;
    }

    //路由维护时，对graph中的节点进行重新初始化
    public static boolean initNode(Graph graph) {
        List<Node> nodeList = new ArrayList<>();
        Map<String, Node> map = graph.getNodeMap();
        Set<String> keySet = map.keySet();
        Iterator<String> iterator = keySet.iterator();
        while (iterator.hasNext()) {
            String temp = iterator.next();
            nodeList.add(map.get(temp));
        }

        for (int m = 0; m < nodeList.size(); m++) {
            nodeList.get(m).getNeighborNode().clear();
            nodeList.get(m).getRoute().clear();
            nodeList.get(m).setSearch( new StringBuffer());
            nodeList.get(m).getRetransBuffer().clear();
            nodeList.get(m).getSendBuffer().clear();
        }

        //初始化邻接点
        for (int i = 0; i < nodeList.size() - 1; i++) {
            for (int j = i + 1; j < nodeList.size(); j++) {
                if (i != j) {
                    Node x = nodeList.get(i);
                    Node y = nodeList.get(j);
                    int dist = (x.getX() - y.getX()) * (x.getX() - y.getX()) +
                            (x.getY() - y.getY()) * (x.getY() - y.getY());
                    boolean isArea = Math.sqrt(dist) <= (x.getRadius() + y.getRadius()) ? true : false;
                    if (isArea) {
                        nodeList.get(i).getNeighborNode().add(y.getNodeName());
                        nodeList.get(j).getNeighborNode().add(x.getNodeName());
                    }
                }
            }
        }

        //初始化路由表
        for (int m = 0; m < nodeList.size(); m++) {
            nodeList.get(m).initRoute();
        }
        return true;
    }
}