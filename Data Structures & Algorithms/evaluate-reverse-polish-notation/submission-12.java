class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str: tokens){
            if (str.equals("+")){
                stack.push(stack.pop() + stack.pop());
            } else if (str.equals("-")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (str.equals("*")){
                stack.push(stack.pop() * stack.pop());
            } else if (str.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(str));
            }
        }
        return stack.peek();
    }
}
