class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            if (count.containsKey(num)){
                count.put(num, count.get(num) + 1);
            } else count.put(num, 1);
        }

        for (Map.Entry<Integer, Integer> entry: count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] result = new int[k];
        int std = 0;
        for (int i = freq.length - 1; i > 0 && std < k; i--){
            for (int node: freq[i]){
                result[std++] = node;
                if (std == k) return result;
            }
        }
        return result;
    }
}
