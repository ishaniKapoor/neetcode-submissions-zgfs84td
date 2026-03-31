class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        /**
            - topological sort O(V + E), O(V + E)
            - dfs and visited path set O(V + E), O(V + E)

            Hashmap integer -> list of integer 0 -> {1}, 1 -> {}
            Set of Integer visited

            dfs
        */

        for (int i = 0; i < numCourses; i++){
            map.put(i, new ArrayList<>()); // 0, 1
        }

        for (int[] pre: prerequisites){
            map.get(pre[0]).add(pre[1]); //0 -> {1}, 1 -> {}
        }

        for (int c = 0; c < numCourses; c++){
            if (!dfs(c)) return false; 
        }

        return true;
    }

    private boolean dfs(int cors){
        if (visited.contains(cors)) return false; 
        if (map.get(cors).isEmpty()) return true;

        visited.add(cors); // 0
        // {1}
        for (int c : map.get(cors)){
            if (!dfs(c)) return false;
        }

        visited.remove(cors);
        map.put(cors, new ArrayList<>());
        return true;
    }
}
