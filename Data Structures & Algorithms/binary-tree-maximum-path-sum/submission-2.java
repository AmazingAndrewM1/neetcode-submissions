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
    private int maxSoFar = Integer.MIN_VALUE;

    private int maxPathSumHelper(TreeNode node){
        List<Integer> maxOptions = new ArrayList<Integer>(Arrays.asList(node.val));
        List<Integer> returnOptions = new ArrayList<Integer>(Arrays.asList(node.val));

        int leftRightTotal = node.val;
        if (node.left != null){
            int maxLeft = maxPathSumHelper(node.left);
            maxOptions.add(maxLeft);
            maxOptions.add(maxLeft + node.val);
            returnOptions.add(maxLeft + node.val);
            leftRightTotal += maxLeft;
        }
        if (node.right != null){
            int maxRight = maxPathSumHelper(node.right);
            maxOptions.add(maxRight);
            maxOptions.add(maxRight + node.val);
            returnOptions.add(maxRight + node.val);
            leftRightTotal += maxRight;
        }
        maxOptions.add(leftRightTotal);
        maxOptions.add(maxSoFar);

        System.out.println("Node: " + node.val);
        System.out.println("\tMax Options: " + maxOptions.toString());
        System.out.println("\tReturn Options: " + returnOptions.toString());

        maxSoFar = Collections.max(maxOptions);
        return Collections.max(returnOptions);
    }

    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        maxPathSumHelper(root);
        return maxSoFar;
    }
}
