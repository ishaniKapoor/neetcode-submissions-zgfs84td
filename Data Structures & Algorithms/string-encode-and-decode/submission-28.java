class Solution {
    /**
        ENCODE 
        len + # + actual string

        DECODE
        have an i keep track of curr ind
        j keep track of first # starting with i
        len calc with substring i to j
        i = j + 1
        string curr from substrings i to len + i
        add to res list
    **/
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
            int j = str.indexOf('#', i);
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            String curr = str.substring(i, i + len);
            i += len;
            res.add(curr);
        }
        return res;
    }
}
