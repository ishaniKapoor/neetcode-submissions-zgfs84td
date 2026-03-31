class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> res = new HashMap<>();

        for (String s: strs){
            int[] count = new int[26];
            for (char c: s.toCharArray()){
                count[c - 'a']++;
            }
            String cString = Arrays.toString(count);
            res.putIfAbsent(cString, new ArrayList<>());
            res.get(cString).add(s);
        }
        return new ArrayList<>(res.values());
    }
}
