class Solution {

    public String encode(List<String> strs) {
        StringBuilder str = new StringBuilder();
        for (String s: strs){
            str.append(s.length()).append('#').append(s);
        }
        return str.toString();
    }

    public List<String> decode(String str) {
        List<String> s = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            s.add(str.substring(i, i + len));
            i = i + len;
        }
        return s;
    }
}
