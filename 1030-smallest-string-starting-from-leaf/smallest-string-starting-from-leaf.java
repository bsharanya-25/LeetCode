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
    public String smallestFromLeaf(TreeNode root) {
        String[] ans = new String[1];
        ans[0] = "";
        helper(root, new StringBuilder(), ans);
        return ans[0];
    }

    private void helper(TreeNode node, StringBuilder s, String[] ans) {
        s.append((char)('a' + node.val));

        if(node.left == null && node.right == null) {
            s.reverse();
            String str = s.toString();
            if(ans[0].isEmpty() || str.compareTo(ans[0]) < 0) ans[0] = str;
        }

        if(node.left != null) helper(node.left, new StringBuilder(s), ans);
        if(node.right != null) helper(node.right, new StringBuilder(s), ans);
    }
}