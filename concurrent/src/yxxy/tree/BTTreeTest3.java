package yxxy.tree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author WangLe
 * @date 2019/12/3 9:52
 * @description 二叉树的广度优先遍历
 */
public class BTTreeTest3 {
    public static void main(String[] args) throws InterruptedException {
        // 构建一棵树,树的形状如 二叉树.jpg所示
        Node a1 = new Node();
        a1.v = "a1";

        Node a2 = new Node();
        a2.v = "a2";

        Node a3 = new Node();
        a3.v = "a3";

        Node a4 = new Node();
        a4.v = "a4";

        Node a5 = new Node();
        a5.v = "a5";

        Node a6 = new Node();
        a6.v = "a6";

        // 设置二叉树的关系
        a1.lChild = a2;
        a1.rChild = a3;
        a2.lChild = a4;
        a2.rChild = a5;
        a3.lChild = a6;

        level(a1);
    }

    public static void level(Node node) throws InterruptedException {
        if (node == null) {
            return;
        }

        LinkedBlockingQueue<Node> queue = new LinkedBlockingQueue<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            Node take = queue.take();
            visit(take);

            if (take.lChild != null) {
                queue.add(take.lChild);
            }

            if (take.rChild != null) {
                queue.add(take.rChild);
            }
        }

    }

    private static void visit(Node node) {
        System.out.print(node.v + "  ");
    }
}
