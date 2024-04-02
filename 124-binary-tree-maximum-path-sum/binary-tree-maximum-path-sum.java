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

    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }

        calPathSum(root);
        return maxSum; 
    }

    private int calPathSum(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftSum = Math.max(0, calPathSum(node.left));
        int rightSum = Math.max(0, calPathSum(node.right));

        int currSum = node.val + leftSum + rightSum;

        maxSum = Math.max(maxSum, currSum);

        return node.val + Math.max(leftSum, rightSum);

    }
}