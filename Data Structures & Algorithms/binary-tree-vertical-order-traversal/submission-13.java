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

        HashMap<Integer, List<Integer>> map = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.offer(new Pair<>(root, 0));
        int minCol = 0, maxCol = 0;

        while (!q.isEmpty()){
            Pair<TreeNode, Integer> p = q.poll();
            TreeNode curr = p.getKey();
            int val = p.getValue();
            map.computeIfAbsent(val, x -> new ArrayList<>()).add(curr.val);
            minCol = Math.min(minCol, val);
            maxCol = Math.max(maxCol, val);
            if (curr.left != null) q.offer(new Pair<>(curr.left, val - 1));
            if (curr.right != null) q.offer(new Pair<>(curr.right, val + 1));
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = minCol; i <= maxCol; i++){
            res.add(map.get(i));
        }
        return res;
    }
}