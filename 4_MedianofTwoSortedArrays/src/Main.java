import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = {1,1,3};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //convert the int[] to BST
        TreeNode node = sortedArrayToBST(nums1);
        //insert the other int[] to BST
        node = insertArrayToBST(node, nums2);
        //BST to arry
        List<Integer> arr = convertBSTtoSortedArray(node);

        //calculate median
        double median = 0.0;
        if(arr.size()%2 == 0){
            median = (arr.get(arr.size()/2-1) + arr.get(arr.size()/2))/2.0;
        }else{
            median = arr.get((arr.size()+1)/2 -1);
        }
        return median;
    }

    public static TreeNode sortedArrayToBST(int[] nums){
        //binary search method
        if(nums.length == 0) return null;
        return sortedArrayToBST(nums,0,nums.length-1);
    }
    public static TreeNode sortedArrayToBST(int[] nums, int start, int end){
        //binary search method
        if(start > end) return null;
        int mid = (start + end)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, start, mid-1);
        node.right = sortedArrayToBST(nums, mid+1, end);
        return node;
    }

    public static TreeNode insertArrayToBST(TreeNode node, int[] nums){
        for (int i = 0; i < nums.length; i++) {
            node = insertNodeKey(node, nums[i]);
        }
        return node;
    }

    public static TreeNode insertNodeKey(TreeNode node, int key){
        TreeNode newNode = new TreeNode(key);
        if (node == null){
            node = newNode;
        }
        //allow duplication in BST according to this problem
        //no matter insert to left or right
        else if (node.val >= key){
            node.left = insertNodeKey(node.left, key);
        }
        else if (node.val < key){
            node.right = insertNodeKey(node.right, key);
        }
        return node;
    }

    public static List<Integer> convertBSTtoSortedArray(TreeNode node){
        //inorder traversal method with no recursion
        List<Integer> list = new ArrayList<>();
        if(node == null) return list;
        Stack<TreeNode> treeNodeStack = new Stack<>();
        while(node !=null || !treeNodeStack.isEmpty()){
            //all to way to the left
            while (node != null){
                treeNodeStack.push(node);
                node = node.left;
            }
            //start to consider the right side of the node pushed in the stack
            if(!treeNodeStack.isEmpty()){
                node = treeNodeStack.pop();
                list.add(node.val);
                node = node.right;
            }
        }
        return list;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}