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
    public int goodNodes(TreeNode root) {
        return numberGoodNodes(root, root.val);
    }

    private int numberGoodNodes(TreeNode node, int maxValue){
        if (node == null){
            return 0;
        }

        int totalGood = 0;
        if (node.val >= maxValue){
            totalGood = 1;
            totalGood += numberGoodNodes(node.left, node.val);
            totalGood += numberGoodNodes(node.right, node.val);
        }
        else{
            totalGood += numberGoodNodes(node.left, maxValue);
            totalGood += numberGoodNodes(node.right, maxValue);
        }
        return totalGood;
    }
}
