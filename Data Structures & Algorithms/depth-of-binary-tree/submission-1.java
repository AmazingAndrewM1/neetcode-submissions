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
    public int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.addLast(root);
        int queueSize = 1;
        int currentLevel = 0;
        while (queueSize > 0){
            for (int i = 0; i < queueSize; ++i){
                TreeNode node = queue.removeFirst();
                if (node.left != null){
                    queue.addLast(node.left);
                }
                if (node.right != null){
                    queue.addLast(node.right);
                }
            }
            queueSize = queue.size();
            currentLevel++;
        }
        return currentLevel;
    }
}
