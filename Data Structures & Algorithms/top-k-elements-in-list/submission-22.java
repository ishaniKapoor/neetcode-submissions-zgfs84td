class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freq = new List[nums.length + 1];

        for (int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for(int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] output = new int[k];
        for (int i = freq.length - 1; i >= 0 && index < k; i--){
            for (int nei: freq[i]){
                output[index++] = nei;
                if (index == k) return output;
            } 
        }
        return output;
    }
}
