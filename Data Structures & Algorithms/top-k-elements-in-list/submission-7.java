class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        /*
            HashMap of frequency of nums integer to integer
            list of integer array to make buckets
            for every key in hashmap
            if bucket at that key is null then create a new list
            if not add key to that bucket f
            create output int array and idx 
            for bucket length -1 to >= 0 and idx < k
            if bucket at f is not null 
            for int num at bucket f
            res[idx] = num
            idx++ break if idx == k
            return res
        */

        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key: freq.keySet()){
            int f = freq.get(key);
            if (bucket[f] == null) bucket[f] = new ArrayList<>();;
            bucket[f].add(key);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int f = bucket.length - 1; f >= 0 && idx < k; f--){
            if (bucket[f] != null){
                for (int num: bucket[f]){
                    res[idx] = num;
                    idx++;
                    if (idx == k) break;
                }
            }
        }
        return res;
    }
}
