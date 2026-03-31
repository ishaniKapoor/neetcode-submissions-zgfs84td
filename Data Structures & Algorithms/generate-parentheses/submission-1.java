class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    public void backtrack(int openCount, int closeCount, int n, List<String> res, StringBuilder stack){
        if (openCount == closeCount && openCount == n){
            res.add(stack.toString());
            return;
        }
        if (openCount < n){
            stack.append('(');
            backtrack(openCount + 1, closeCount, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closeCount < openCount){
            stack.append(')');
            backtrack(openCount, closeCount + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
