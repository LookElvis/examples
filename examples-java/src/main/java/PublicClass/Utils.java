package PublicClass;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Created by liuxiang on 2018/10/11.
 */
public class Utils {
    // 求1-N的逆元,避免另一种方式超时
    public static long[] reverseArray(int N, int MOD) {
//        int N = 200000 + 5;
//        int MOD = (int) 1e9 + 7;
        long inv[] = new long[N];
        inv[1] = 1;
        for (int i = 2; i < N; i++) {
            inv[i] = (MOD - MOD / i) * 1L * inv[MOD % i] % MOD;
        }
        return inv;
    }

    // 某个分数的逆元 = 分子 * (分母 % p的逆元) = 分子 * Fermat(分母, p)
    public static long Fermat(long a, long p){//费马求a关于b的逆元
        return pow_mod(a, p - 2, p);
    }
    public static long pow_mod(long a, long b, long p){//a的b次方求余p
        long ret = 1;
        while(b != 0){
            if((b & 1) == 1) {
                ret = (ret * a) % p;
            }
            a = (a * a) % p;
            b >>= 1;
        }
        return ret;
    }

    public static TreeNode createTree1() {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(9);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(6);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n3.left = n7;
        n5.right = n8;
        Utils.printTree(root);
        return root;
    }

    public static TreeNode createTree2() {
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(9);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(8);
        TreeNode n7 = new TreeNode(11);
        TreeNode n8 = new TreeNode(3);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n2.right = n6;
        n3.left = n7;
        n7.left = n4;
        n5.right = n8;
        Utils.printTree(root);
        return root;
    }

    public static void printTree(TreeNode head) {
        System.out.println();
        System.out.println("Binary Tree:");
        printInOrder(head, 0, "←", 17);
        System.out.println();
    }

    public static void printInOrder(TreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.right, height + 1, "↙", len);
        String val = to + head.val + to;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.left, height + 1, "↖", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    public static void printLinkedList(ListNode root) {
        while (root != null) {
            System.out.print(root.val + "->");
            root =  root.next;
        }
        System.out.println();
    }

    public static void printMiddleTree(TreeNode root) {
        if(root != null) {
            printMiddleTree(root.left);
            System.out.print(root.val + "->");
            printMiddleTree(root.right);
        }
    }

    public static void printLevelTree(TreeNode root) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + "->");
            if(node.left != null) {
                queue.offer(node.left);
            }
            if(node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void printArrayList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }

    public static void printIntArrays(int[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void printIntMatrix(int[][] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void printObjectArrays(Object[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static void printObjectMatrix(Object[][] list) {
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                System.out.print(list[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void printCharArrays(char[] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i] + " ");
        }
    }

    public static <T> void printDoubleArrays(List<List<T>> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                System.out.print(list.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}
