class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int step = 0;
        for (int i = freq.length - 1; i > 0 && step < k; i--){
            for (int num: freq[i]){
                res[step++] = num;
                if (step == k) return res;
            }
        }
        return res;
    }
}
