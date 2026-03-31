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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        HashMap<Integer, List<Integer>> cols = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        int minCol = 0, maxCol = 0;

        while (!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode node = p.getKey();
            int col = p.getValue();

            cols.computeIfAbsent(col, x -> new ArrayList<>()).add(node.val);
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);
            if (node.left != null) q.offer(new Pair<>(node.left, col - 1));
            if (node.right != null) q.offer(new Pair<>(node.right, col + 1));
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int i = minCol; i <= maxCol; i++){
            res.add(cols.get(i));
        }
        return res;

    }
}