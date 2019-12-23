package Algorithm.Bilibili;

import java.util.HashMap;
import java.util.List;

/**
 * 并查集
 * Created by Elvis on 2019/12/23.
 */
public class UnionFind {
	public static class Node {
		//what you like
	}

	public static class UnionFindSet {
		public HashMap<Node, Node> fatherMap;
		public HashMap<Node, Integer> sizeMap;

		public UnionFindSet() {
			this.fatherMap = new HashMap<>();
			this.sizeMap = new HashMap<>();
		}

		public void initSet(List<Node> nodes) {
			fatherMap.clear();
			sizeMap.clear();
			for (Node n : nodes) {
				fatherMap.put(n, n);
				sizeMap.put(n, 1);
			}
		}

		public Node findHead(Node node) {
			Node father = fatherMap.get(node);
			if (father != node) {
				father = fatherMap.get(father);
			}
			fatherMap.put(node, father);
			return father;
		}

		public boolean isSameSet(Node n1, Node n2) {
			return findHead(n1) == findHead(n2);
		}

		public void unionSet(Node n1, Node n2) {
			if (n1 == null || n2 == null) {
				return;
			}
			n1 = findHead(n1);
			n2 = findHead(n2);
			if (n1 != n2) {
				int n1Size = sizeMap.get(n1);
				int n2Size = sizeMap.get(n2);
				if (sizeMap.get(n1) <= sizeMap.get(n2)) {
					fatherMap.put(n1, n2);
					sizeMap.put(n1, n1Size + n2Size);
				} else {
					fatherMap.put(n2, n1);
					sizeMap.put(n2, n1Size + n2Size);
				}
			}
		}
	}

    public static void main(String[] args) {

    }    
}
