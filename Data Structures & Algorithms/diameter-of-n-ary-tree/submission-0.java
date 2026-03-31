/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public int diameter(Node root) {
        int[] res = new int[1];
        dfs(root, res);
        return res[0];
    }

    public int dfs(Node root, int[] res){
        if (root == null) return 0;
        int max1 = 0, max2 = 0;
        for (Node child: root.children){
            int h = dfs(child, res);
            if (h > max1){
                max2 = max1;
                max1 = h;
            } else if (h > max2){
                max2 = h;
            }
        }
        res[0] = Math.max(res[0], max1 + max2);
        return max1 + 1;
        
    }
}
