class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
            bucket sort
            bucket of 1 -> contains 1s
            output of max k 
        **/
        List<Integer>[] freq = new List[nums.length + 1];
        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> count = new HashMap<>();
        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int std = 0;
        int[] result = new int[k];
        for (int i = freq.length - 1; i > 0 && std < k; i--){
            for (int nei: freq[i]){
                result[std++] = nei;
                if (std == k) return result;
            }
        }

        return result;
    }
}
