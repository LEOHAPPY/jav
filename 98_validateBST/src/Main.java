import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
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

//        ArrayList<Integer> arr = inOrderTraversal(tree);
//        for (Integer item : arr){
//            System.out.println(item);
//        }
        List<Integer> arr2 = inorderTraversal(tree);
        for (Integer item : arr2) {
            System.out.print(item + " ");
        }
        System.out.println();
        recursionInorderTraversal(tree);

        for (Integer item : arr) {
            System.out.print(item + " ");
        }


    }

//    public boolean isValidBST(TreeNode root) {
//        //Inorder Traversal
////        return  inOrderTraversal();
//    }

//    public static ArrayList<Integer> inOrderRecursionTraversal(TreeNode root) {
//        ArrayList<Integer> arr = new ArrayList<Integer>();
//        if (root != null){
//            inOrderTraversal(root.left);
//            System.out.print(root.val);
//            arr.add(root.val);
//            inOrderTraversal(root.right);
//
////            return arr.get(arr.size()-2) < root.val;
//
//        }
//        return arr;
//    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;

        }
        return list;
    }

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null;
        while(root != null || !stack.empty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre!=null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    private static ArrayList arr = new ArrayList();

    public static void recursionInorderTraversal(TreeNode root) {
        if (root == null){
            return;
        }
        recursionInorderTraversal(root.left);
        arr.add(root.val);
        recursionInorderTraversal(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

