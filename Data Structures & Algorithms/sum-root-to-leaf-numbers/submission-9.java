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
    public int sumNumbers(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        TreeNode curr = root;
        int res = 0, num = 0;
        while (curr != null || !stack.isEmpty()){
            if (curr != null){
                num = num * 10 + curr.val;
                if (curr.left == null && curr.right == null) res += num;
                stack.push(new Pair<>(curr.right, num));
                curr = curr.left;
            } else {
                Pair<TreeNode, Integer> p = stack.pop();
                curr = p.getKey();
                num = p.getValue();
            }
        }
        return res;
    }
}