class Solution {
    List<List<Integer>> adj;
    List<Integer> output = new ArrayList<>();
    int[] indegree;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++){
            adj.add(new ArrayList<>());
        }

        indegree = new int[numCourses];
        for (int[] pre: prerequisites){
            indegree[pre[0]]++;
            adj.get(pre[1]).add(pre[0]);
        }

        for (int i = 0; i < numCourses; i++){
            if (indegree[i] == 0) dfs(i);
        }

        if (output.size() != numCourses) return new int[0];
        int[] res = new int[output.size()];
        for (int i = 0; i < output.size(); i++) res[i] = output.get(i);
        return res;
    }

    void dfs(int i){
        output.add(i);
        indegree[i]--;
        for (int nei: adj.get(i)){
            indegree[nei]--;
            if (indegree[nei] == 0) dfs(nei);
        }
    }
}
