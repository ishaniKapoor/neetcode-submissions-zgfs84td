class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');map.put('}', '{');map.put(']', '[');
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()){
            if (map.containsKey(c)){
                if (stack.isEmpty() || stack.pop() != map.get(c)) return false;
            } else stack.push(c);
        }
        return stack.isEmpty();
    }
}
