import java.lang.*;

public class Stack<T> { 
    // Methods: pop(), push(item), peek(), isEmpty();
    private class StackNode<T> {
        private T data;
        private StackNode<T> next;

        public StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop () throws Exception {
        if (top == null) {
            throw new Exception();
        }

        T topData = top.data;
        this.top = top.next;
        return topData;
    }

    public void push(T item) {
        StackNode<T> newTop = new StackNode(item);
        newTop.next = this.top;
        this.top = newTop;
    }

    public T peek() throws Exception {
        if (top == null) {
            throw new Exception();
        }

        return top.data;
    }

    public boolean isEmpty() {
        return (top == null);
    }

    public void printStack(Stack<Integer> stack) throws Exception {
        int[] temp = new int[64];
        int i = 0;
        while (!stack.isEmpty()) {
            int item = stack.pop();
            temp[i] = item;
            System.out.print(item);
            System.out.print("-->");
            i++;
        }
        System.out.print("end\n");    
        
        // restore stack
        while (i >= 0) {
            stack.push(temp[i]);
            i--;
        }

    }
}






