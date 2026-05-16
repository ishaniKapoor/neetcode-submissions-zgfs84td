class Solution {

    public String encode(List<String> strs) {
        StringBuilder st = new StringBuilder();
        for (String str: strs){
            st.append(str.length()).append('#').append(str);
        }
        return st.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j + 1, j + 1 + len));
            i = j + 1 + len;
        }
        return res;
    }
}
