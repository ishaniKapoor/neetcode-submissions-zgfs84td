class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    HashSet<Integer> set = new HashSet<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for (int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for (int[] pre: prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        for (int i = 0; i < numCourses; i++){
            if (!dfs(i)) return false;
        }
        return true;
    }

    boolean dfs(int node){
        if (set.contains(node)) return false;

        if (map.get(node).isEmpty()) return true;

        set.add(node);
        for (int nei: map.get(node)){
            if (!dfs(nei)) return false;
        }
        set.remove(node);
        map.put(node, new ArrayList<>());
        return true;
    }
}
