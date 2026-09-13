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

public class Codec {
    private void serializeHelper(TreeNode node, StringBuilder str){
        if (node == null){
            return;
        }

        str.append(node.val);
        if (node.left != null || node.right != null){
            str.append('(');
            serializeHelper(node.left, str);
            str.append(',');
            serializeHelper(node.right, str);
            str.append(')');
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder serialized = new StringBuilder();
        serializeHelper(root, serialized);
        String result = serialized.toString();
        System.out.println(result);
        return result;
    }

    private int scanIndex = 0;

    private void deserializeHelper(TreeNode node, String data, int depth){
        int startIndex = scanIndex;
        while (data.charAt(scanIndex) != ',' && data.charAt(scanIndex) != '('){
            ++scanIndex;
        }
        node.left = startIndex == scanIndex ? null 
                        : new TreeNode(Integer.parseInt(data.substring(startIndex, scanIndex)));
        if (data.charAt(scanIndex) == '('){
            ++scanIndex;
            deserializeHelper(node.left, data, depth + 1);
        }
        ++scanIndex;    // Consume the ',' character
        
        startIndex = scanIndex;
        while (data.charAt(scanIndex) != ')' && data.charAt(scanIndex) != '('){
            ++scanIndex;
        }
        node.right = startIndex == scanIndex ? null 
                        : new TreeNode(Integer.parseInt(data.substring(startIndex, scanIndex)));
        if (data.charAt(scanIndex) == '('){
            ++scanIndex;
            deserializeHelper(node.right, data, depth + 1);
        }
        ++scanIndex; // Consume the ')' character
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        System.out.println(data);
        if (data.length() == 0){
            return null;
        }

        int indexOpen = data.indexOf('(');
        if (indexOpen == -1){
            return new TreeNode(Integer.parseInt(data));
        }

        TreeNode root = new TreeNode(Integer.parseInt(data.substring(0, indexOpen)));
        scanIndex = indexOpen + 1;
        deserializeHelper(root, data, 0);
        return root;
    }
}
