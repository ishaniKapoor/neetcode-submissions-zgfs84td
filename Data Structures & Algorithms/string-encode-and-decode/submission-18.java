class Solution {

    // hash and length -> string
    public String encode(List<String> strs) {
        StringBuilder result = new StringBuilder();
        for (String str: strs){
            result.append(str.length()).append('#').append(str);
        }
        return result.toString();
    }

    // if hash, then one after is length, so current index
    // till length aggregate
    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int delm = str.indexOf('#', i); // first #
            int size = Integer.parseInt(str.substring(i, delm)); 
            i = delm + 1 + size;
            result.add(str.substring(delm + 1, i));
        }
        return result;
    }
}
