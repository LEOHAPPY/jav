public class Main {

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(3);
        tree.right.right = new TreeNode(5);
        tree.left.left = new TreeNode(4);
        tree.left.left.right = new TreeNode(6);
        tree.left.left.right.left = new TreeNode(7);
        tree.left.left.right.right = new TreeNode(8);

        recursionPreorderTraversal(tree);

        System.out.println();
        recursionPreorderTraversal(tree,"InOrder");
        System.out.println();
        recursionPreorderTraversal(tree,"PostOrder");



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


