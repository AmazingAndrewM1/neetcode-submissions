/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution { 
    private boolean isSameTree(TreeNode root, TreeNode subRoot){
        if (root == null){
            return subRoot == null;
        }
        if (subRoot == null || root.val != subRoot.val){
            return false;
        }
        return isSameTree(root.left, subRoot.left) && 
               isSameTree(root.right, subRoot.right);
    }
    private boolean isSubtreeHelper(TreeNode root, TreeNode subRoot){
        if (root == null){
            return false;
        }
        if (isSameTree(root, subRoot)){
            return true;
        }
        return isSubtreeHelper(root.left, subRoot) ||
               isSubtreeHelper(root.right, subRoot);
    }
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null){
            return true;
        }
        return isSubtreeHelper(root, subRoot);
    }

}
