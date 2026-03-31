class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(0, 0, new ArrayList<>(), candidates, target);
        return res;
    }

    public void dfs(int total, int i, List<Integer> curr, int[] candidates, int target){
        if (total == target){
            res.add(new ArrayList<>(curr));
            return;
        }

        if (total > target || i == candidates.length){
            return;
        }

        curr.add(candidates[i]);
        dfs(total + candidates[i], i + 1, curr, candidates, target);
        curr.remove(curr.size() - 1);
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]){
            i++;
        }
        dfs(total, i + 1, curr, candidates, target);
    }
}
