import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        // how to initial a treeNode
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(5);
        tree.left.left = new TreeNode(4);
        tree.left.right = new TreeNode(9);
        tree.left.left.left = new TreeNode(0);
        tree.left.left.left.left = new TreeNode(3);
        tree.left.left.right = new TreeNode(6);
        tree.left.left.right.left = new TreeNode(7);
        tree.left.left.right.right = new TreeNode(8);

        recursionPreorderTraversal(tree);
        System.out.println();
        preorderTraversal(tree);

        System.out.println();
        recursionPreorderTraversal(tree,"InOrder");
//        recursionPreorderTraversal(tree,"PostOrder");



    }

    //http://www.jianshu.com/p/456af5480cee
    // 非递归先序遍历
    public static void preorderTraversal(TreeNode root) {
        // 用来暂存节点的栈
        Stack<TreeNode> treeNodeStack = new Stack<TreeNode>();
        // 新建一个游标节点为根节点
        TreeNode node = root;
        // 当遍历到最后一个节点的时候，无论它的左右子树都为空，并且栈也为空
        // 所以，只要不同时满足这两点，都需要进入循环
        while (node != null || !treeNodeStack.isEmpty()) {
            // 若当前考查节点非空，则输出该节点的值
            // 由考查顺序得知，需要一直往左走
            while (node != null) {
                // 为了之后能找到该节点的右子树，暂存该节点
                treeNodeStack.push(node);
                node = node.left;
            }
            // 一直到左子树为空，则开始考虑右子树
            // 如果栈已空，就不需要再考虑
            // 弹出栈顶元素，将游标等于该节点的右子树
            if (!treeNodeStack.isEmpty()) {
                node = treeNodeStack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }

    public static void recursionPreorderTraversal(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");

            recursionPreorderTraversal(root.left);

            recursionPreorderTraversal(root.right);
        }
    }

    public static void recursionPreorderTraversal(TreeNode root, String traversalMethod) {
        switch (traversalMethod) {
            case "PreOrder":
                if (root != null) {
                    System.out.print(root.val + " ");
                    recursionPreorderTraversal(root.left, traversalMethod);
                    recursionPreorderTraversal(root.right, traversalMethod);
                }
                break;
            case "InOrder":
                if (root != null) {
                    recursionPreorderTraversal(root.left, traversalMethod);
                    System.out.print(root.val + " ");
                    recursionPreorderTraversal(root.right, traversalMethod);
                }
                break;
            case "PostOrder":
                if (root != null) {
                    recursionPreorderTraversal(root.left, traversalMethod);
                    recursionPreorderTraversal(root.right, traversalMethod);
                    System.out.print(root.val + " ");
                }
                break;
        }
    }

}

class TreeNode {
    int val;
    //左子树
    TreeNode left;
    //右子树
    TreeNode right;
    //构造方法
    TreeNode(int x) {
        val = x;
    }
}

    // 递归先序遍历


