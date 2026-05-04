class Solution {

    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for (String str: strs){
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()){
            int del = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, del));
            res.add(str.substring(del + 1, del + 1 + len));
            i = del + 1 + len;
        }
        return res;
    }
}
