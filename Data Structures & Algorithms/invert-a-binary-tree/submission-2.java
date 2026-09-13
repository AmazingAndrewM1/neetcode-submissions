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
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        stack.addFirst(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.removeFirst();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null){
                stack.addFirst(node.left);
            }
            if (node.right != null){
                stack.addFirst(node.right);
            }
        }
        return root;
    }
}
