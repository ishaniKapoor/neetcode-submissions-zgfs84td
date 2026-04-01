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

        for (int c = 0; c < numCourses; c++){
            if (!dfs(c)) return false;
        }
        return true;
    }

    private boolean dfs(int c){
        if (set.contains(c)) return false;

        if (map.get(c).isEmpty()) return true;

        set.add(c);
        for (int pre: map.get(c)){
            if (!dfs(pre)) return false;
        }
        set.remove(c);
        map.put(c, new ArrayList<>());
        return true;
    }
}
