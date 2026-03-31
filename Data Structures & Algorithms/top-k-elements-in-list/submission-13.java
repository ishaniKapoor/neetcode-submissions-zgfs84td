class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer>[] freq = new List[nums.length + 1];
        HashMap<Integer, Integer> count = new HashMap<>();

        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entrySet : count.entrySet()){
            freq[entrySet.getValue()].add(entrySet.getKey());
        }

        int step = 0;
        int[] result = new int[k];
        for (int i = freq.length - 1; i > 0 && step < k; i--){
            for (int n : freq[i]){
                result[step++] = n;
                if (step == k) return result;
            }
        }

        return result;

    }
}
