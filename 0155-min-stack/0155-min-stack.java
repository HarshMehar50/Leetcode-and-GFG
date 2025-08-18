class MinStack {
    Stack<int[]> s;
    public MinStack() {
        s = new Stack<>();
    }
    
    public void push(int val) {
        int min = Integer.MAX_VALUE;
        if(!s.isEmpty())
        min = s.peek()[1];
        s.push(new int[]{val , Math.min(min , val)});
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek()[0];
    }
    
    public int getMin() {
        return s.peek()[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */