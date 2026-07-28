class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        for(int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int idx = 0;
        int[] res = new int[k];
        for (int i = freq.length - 1; i >= 0 && idx < k; i--){
            for (int nei: freq[i]){
                res[idx++] = nei;
                if (idx == k) return res;
            }
        }

        return res;
    }
}
