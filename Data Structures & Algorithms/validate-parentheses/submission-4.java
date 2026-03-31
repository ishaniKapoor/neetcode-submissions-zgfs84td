class Solution {
    public boolean isValid(String s) {
        // in string s every open followed by close
        // HashMap<Character> key: close value: open
        // Stack<Characters> 
        // for every char in string s, check if s is in map
        // if stack is not empty and the peek of stack is value of s in map
        // stack.pop
        // return false;
        // add to stack
        // return true

        // O(n), O(n)

        HashMap<Character, Character> parenth = new HashMap<>();
        parenth.put(')', '(');
        parenth.put('}', '{');
        parenth.put(']', '[');
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()){
            if (parenth.containsKey(c)){
                if (!stack.isEmpty() && stack.peek() == parenth.get(c)){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
