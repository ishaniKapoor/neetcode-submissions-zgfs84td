class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /**
            group by char count into lists
            create char count
            if char count exists in hashmap add to list
            else create new list
            return new list of all list values
        */
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            int[] count = new int[26];
            for (char c: str.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
