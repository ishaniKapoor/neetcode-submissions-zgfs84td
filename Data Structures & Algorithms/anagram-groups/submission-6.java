class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        /*
        hashmap of string (count of string) to list of strings
        for every string in strs, go through every char in string and create int[] count
        make a key string using to string
        putifabsent in map the key with a new empty array list
        otherwise add to the list

        return new array list <>(map.values)
        */

        HashMap<String, List<String>> map = new HashMap<>();

        for (String str: strs){
            int[] count = new int[26];
            for (char c: str.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }
}
