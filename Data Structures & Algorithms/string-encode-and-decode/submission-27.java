class Solution {
    /**
    ["Hello", "World"]
        encode using # and length of the str append all into on string
        5#Hello5#World

        decode

        while (not at end of str)
            if current char is not # ++
            else 
                len = str at 1 + cur indx
                for (i = len + 1 till i + len) keep appending into
                string builder
                add to list of string output at the end
        return list of string

        
    **/
    public String encode(List<String> strs) {
        StringBuilder res = new StringBuilder();
        for(String str: strs){
            res.append(str.length()).append('#').append(str);
        }
        return res.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while(i < str.length()){
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
