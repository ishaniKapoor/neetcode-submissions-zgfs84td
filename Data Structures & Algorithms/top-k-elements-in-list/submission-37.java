class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /**
            Brain dump:
            bucket sort
            freq buckets -> 2 bucket should have 2
                            3 bucket should have 3
            count hashmap -> count of each number
            for every entry of hashmap, put the value as bucket
            and key as list entry

            then for up to add to int[]
        **/

        List<Integer>[] freq = new List[nums.length + 1];

        for (int i = 0; i < freq.length; i++){
            freq[i] = new ArrayList<>();
        }

        HashMap<Integer, Integer> count = new HashMap<>();

        for (int num: nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int index = 0;
        int[] result = new int[k];
        for (int i = freq.length - 1; i > 0 && index < k; i--){
            for (int num: freq[i]){
                result[index++] = num;
                if (index == k) break;
            }
        }
        return result;
    }
}
