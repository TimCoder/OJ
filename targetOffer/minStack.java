package tim.targetOffer;

public class minStack {

    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> minStk = new Stack<Integer>();
    int min = Integer.MAX_VALUE;
      
    public void push(int node) {
        stack.push(node);
        if (node < min) {
            min = node;
        }
        minStk.push(min);
    }
        
    public void pop() {
        stack.pop();
        minStk.pop();
    }
            
    
    public int top() {
        return stack.peek();
    }
                
        
    public int min() {
        return minStk.peek();
    }
                    
}
