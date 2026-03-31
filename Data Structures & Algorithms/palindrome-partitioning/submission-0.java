class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, res, part);
        return res;
    }

    public void dfs(int i, String s, List<List<String>> res, List<String> part){
        if (i >= s.length()){
            res.add(new ArrayList<>(part));
            return;
        }

        for (int j = i; j < s.length(); j++){
            if (isPali(s, i, j)){
                part.add(s.substring(i, j + 1));
                dfs(j + 1, s, res, part);
                part.remove(part.size() - 1);
            }
        }
    }

    public boolean isPali(String s, int l, int r){
        while (l < r){
            if (s.charAt(l) != s.charAt(r)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

   
}
