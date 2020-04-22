package yxxy.tree;

/**
 * @author WangLe
 * @date 2019/12/2 11:20
 * @description 二叉树的深度优先遍历--递归遍历
 */
public class BTTreeTest {
    public static void main(String[] args) {
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

        // 遍历
        look(a1);
    }

    /**
     * 要想分别得到 前序、中序、后序的遍历序列，只需要将visit()放在不同的地方即可
     * 原理也很简单:
     * @param node
     */
    public static void look(Node node) {
        if (node != null) {
            //(1) 前序遍历,此时第一次访问节点
            //visit(node);
            look(node.lChild);
            //(2) 中序遍历,此时开始都是第二次访问该节点了,左孩子都访问完了,然后回到当前节点,就是第二次访问了
            //visit(node);
            look(node.rChild);
            //(3) 后序遍历,所有的右孩子都访问过了,然后回到当前节点,就是第三次访问该节点了,注意,叶子节点也是有左右孩子的只是都是null而已
            visit(node);
        }
    }


    private static void visit(Node node) {
        System.out.print(node.v + "  ");
    }
}
