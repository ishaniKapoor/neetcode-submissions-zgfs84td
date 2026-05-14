class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String t: tokens){
            if (t.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if (t.equals("-")){
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x - y);
            } else if (t.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if (t.equals("/")){
                int y = stack.pop();
                int x = stack.pop();
                stack.push(x / y);
            } else {
                stack.push(Integer.parseInt(t));
            }
        }
        return stack.peek();
    }
}
