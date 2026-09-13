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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderIndex = new HashMap<Integer, Integer>();
        for (int i = 0; i < inorder.length; ++i){
            inOrderIndex.put(inorder[i], i);
        }

        TreeNode root = null;
        if (preorder.length > 0){
            root = new TreeNode(preorder[0]);
        }

        for (int i = 1; i < preorder.length; ++i){
            TreeNode prev = null;
            TreeNode curr = root;
            int nodeVal = preorder[i];
            boolean shouldGoLeft = true;
            while (curr != null){
                prev = curr;
                shouldGoLeft = inOrderIndex.get(nodeVal).compareTo(inOrderIndex.get(curr.val)) < 0;
                if (shouldGoLeft){
                    curr = curr.left;
                }
                else{
                    curr = curr.right;
                }
            }
            if (shouldGoLeft){
                prev.left = new TreeNode(nodeVal);
            }
            else{
                prev.right = new TreeNode(nodeVal);
            }
        }

        return root;
    }
}
