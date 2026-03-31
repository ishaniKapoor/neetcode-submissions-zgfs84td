class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()){

            //leading zero
            if (j < abbr.length() && abbr.charAt(j) == '0') return false;

            if (Character.isLetter(abbr.charAt(j))){
                if (i < word.length() && word.charAt(i) == abbr.charAt(j)){
                    i++; j++;
                } else return false;
            } else {
                int num = 0;
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))){
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                i += num;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}