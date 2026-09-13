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
    private int getNumberOfNodes(TreeNode root){
        if (root == null){
            return 0;
        }

        int numLeftNodes = getNumberOfNodes(root.left);
        int numRightNodes = getNumberOfNodes(root.right);
        return numLeftNodes + numRightNodes + 1;
    }

    public int kthSmallest(TreeNode root, int k) {
        int numNodesLeft = getNumberOfNodes(root.left);

        if (numNodesLeft + 1 == k){
            return root.val;
        }
        else if (numNodesLeft >= k){
            return kthSmallest(root.left, k);
        }
        else{
            return kthSmallest(root.right, k - numNodesLeft - 1);
        }
    }
}
