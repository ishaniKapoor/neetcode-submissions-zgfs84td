class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> parenth = new HashMap<>();
        parenth.put(')', '(');
        parenth.put('}', '{');
        parenth.put(']', '[');
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()){
            if (parenth.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == parenth.get(c)){
                    stack.pop();
                } else return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}
