public class ArrayStack {

    private int maxsize;
    private int top;
    private int[] items;

    public ArrayStack(int maxsize) {
        if (maxsize <= 0) {
            throw new ArrayStackException("Stack size must be positive");
        }
        
        this.maxsize = maxsize;
        this.items = new int[maxsize];
        this.top = 0;
    }

    public void push(int item) {
        if (top == maxsize) {
            throw new ArrayStackException("Overflow Error: Stack is full");
        }
        
        items[top] = item;
        top++;
    }

    public int pop() {
        if (isEmpty()) {
            throw new ArrayStackException("Underflow Error: Stack is empty");
        }
        
        return items[--top];
    }

    public boolean isEmpty() {
        return (top == 0);
    }

    public int peek() {
        if (isEmpty()) {
            throw new ArrayStackException("Underflow Error: Cannot peek, stack is empty");
        }
        return items[top - 1];
    }

    public static class ArrayStackException extends RuntimeException {
        
        public ArrayStackException(String message) {
            super(message);
        }
    }
    
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);

        try {
            stack.push(1);
            stack.push(2);
            stack.push(3);
            
            System.out.println(stack.pop());
            System.out.println(stack.pop());
            System.out.println(stack.pop());

        } catch (ArrayStackException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}