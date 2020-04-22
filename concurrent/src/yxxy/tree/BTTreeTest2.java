package yxxy.tree;

import java.util.Stack;

/**
 * @author WangLe
 * @date 2019/12/2 11:20
 * @description 二叉树的深度优先遍历--非递归遍历
 */
public class BTTreeTest2 {
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

        // 前序遍历
//        lookPre(a1);
        // 后序遍历
//        lookSuf(a1);
        // 中序遍历
        lookMid(a1);
    }


    /**
     * 前序遍历(先序遍历)
     *
     * @param root
     */
    public static void lookPre(Node root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            Node pop = stack.pop();
            visit(pop);
            if (pop.rChild != null) {
                stack.push(pop.rChild);
            }
            if (pop.lChild != null) {
                stack.push(pop.lChild);
            }
        }
    }


    /**
     * 中序遍历
     *
     * @param root
     */
    public static void lookMid(Node root) {
        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
                current = current.lChild;
            }else {
                // 出栈
                Node pop = stack.pop();
                visit(pop);
                current = pop.rChild;
            }
        }
    }

    /**
     * 后序遍历
     * 注意后序遍历和前序遍历的关系和区别
     *
     * @param root
     */
    public static void lookSuf(Node root) {
        Stack<Node> stack = new Stack<>();
        Stack<Node> stackTemp = new Stack<>();
        stack.push(root);
        while (stack.size() != 0) {
            Node pop = stack.pop();
            stackTemp.push(pop);
            if (pop.lChild != null) {
                stack.push(pop.lChild);
            }
            if (pop.rChild != null) {
                stack.push(pop.rChild);
            }
        }

        while (!stackTemp.empty()) {
            visit(stackTemp.pop());
        }
    }


    private static void visit(Node node) {
        System.out.print(node.v + "  ");
    }
}
