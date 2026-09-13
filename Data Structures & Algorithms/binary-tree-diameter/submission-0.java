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
    int maxDiameter = 0;

    private int getNodeHeight(TreeNode root){
        if (root == null){
            return 0;
        }

        int leftHeight = getNodeHeight(root.left);
        int rightHeight = getNodeHeight(root.right);
        if (leftHeight + rightHeight > maxDiameter){
            maxDiameter = leftHeight + rightHeight;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        getNodeHeight(root);
        return this.maxDiameter;
    }
}
