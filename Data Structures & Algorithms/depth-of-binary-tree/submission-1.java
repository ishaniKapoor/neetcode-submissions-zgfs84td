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
        // BFS
        // create a queue, add the root node to queue if not null
        // create a variable level
        // while q is not empty, create a var for size of q
        // for i = 0 to size
        // treenode node = q.poll
        // if node is null, return
        // if node's left and right value not null add to queue
        // level++ after for loop ends
        // return level

        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) q.add(root);
        int level = 0;
        while (!q.isEmpty()){
            int size = q.size();
            for (int i = 0; i < size; i++){
                TreeNode node = q.poll();
                if (node == null) continue;
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            level++;
        }
        return level;


    }
}
