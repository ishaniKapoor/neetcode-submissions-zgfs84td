class Solution {

    List<String> res = new ArrayList<>();
    String[] digitsToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }

    public void backtrack(int i, String currString, String digits){
        if (currString.length() == digits.length()){
            res.add(currString);
            return;
        }
        String chars = digitsToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()){
            backtrack(i + 1, currString + c, digits);
        }
    }
}
