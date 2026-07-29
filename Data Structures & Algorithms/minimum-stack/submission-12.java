class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        // push into stack always, minstack only if peek isn't less than current one?
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val) minStack.push(val);
    }
    
    public void pop() {
        // pop into int var then check if minstack has it then pop?
        int popped = stack.pop();
        if (!minStack.isEmpty() && minStack.peek().equals(popped)) minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
