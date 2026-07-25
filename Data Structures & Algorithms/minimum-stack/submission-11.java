class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        /**
            push onto val, if top of min stack is greater than
            then push on to stack?
        **/
        stack.push(val);
        if (minStack.isEmpty() || minStack.peek() >= val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        /**
            pop from stack and store
            if top of min stack is this one then pop there too
        **/
        if (!stack.isEmpty()){
             int popped = stack.pop();
             if (minStack.peek().equals(popped)) minStack.pop();
        }
    }
    
    public int top() {
        /**
            top of stack
        **/
        return stack.peek();
    }
    
    public int getMin() {
        /**
            top of min stack
        **/
        return minStack.peek();
    }
}
