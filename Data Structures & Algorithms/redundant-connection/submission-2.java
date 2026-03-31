class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] indegrees = new int[ n + 1];
        List<List<Integer>> adj = new ArrayList<>(n + 1);

        for (int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for (int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            indegrees[u]++;
            indegrees[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++){
            if (indegrees[i] == 1){
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.poll();
            indegrees[node]--;
            for (int nei: adj.get(node)){
                indegrees[nei]--;
                if (indegrees[nei] == 1){
                    q.offer(nei);
                }
            }
        }

        for (int i = edges.length - 1; i >= 0; i--){
            int u = edges[i][0], v = edges[i][1];
            if (indegrees[u] == 2 && indegrees[v] > 0){
                return new int[]{u, v};
            }
        }
        
        return new int[0];
    }
}
