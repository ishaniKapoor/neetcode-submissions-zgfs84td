class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    public void dfs(int i, int total, List<Integer> curr, int[] candidates, int target){
        if (total == target){
            res.add(new ArrayList<>(curr));
            return;
        }
        if (total > target || i == candidates.length){
            return;
        }
        curr.add(candidates[i]);
        dfs(i + 1, total + candidates[i], curr, candidates, target);
        curr.remove(curr.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        dfs(i + 1, total, curr, candidates, target);

    }
}
