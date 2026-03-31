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

        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] res = new int[k];
        int i = 0;
        for (int j = freq.length - 1; j > 0 && i < k; j--){
            for (int nei: freq[j]){
                res[i++] = nei;
                if (i == k) return res;
            }
        }
        return res;
    }
}
