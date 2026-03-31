class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, int[]> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.putIfAbsent(c, new int[]{0, i});
            map.get(c)[0]++;
        }

        int result = Integer.MAX_VALUE;
        for (int[] v : map.values()){
            if(v[0] == 1){
                result = Math.min(v[1], result);
            }
        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
}