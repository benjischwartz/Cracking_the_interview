import java.util.Random;

public class sortStack {
    // Sort a stack such that the smallest items are on the top. Can use an 
    // additional temporary stack, but you may not copy the elements into any
    // other data structure (such as an array). The stack supports the operations:
    // push, pop, peek, and isEmpty.

    public static Stack<Integer> sortStack(Stack<Integer> s1) throws Exception {
        // Keep temporary stack in sorted order
        // Insert from first stack into temporary stack in order:
        // store the popped element as a variable and move all 
        // nodes above it back into s1. After pushing the new element
        // move elements back over from s1 to s2. 

        // Pop first element from s1 to s2
        Stack<Integer> s2 = new Stack<Integer>();
        int temp = s1.pop();
        s2.push(temp);
        
        while (!s1.isEmpty()) {
            temp = s1.pop();
            int itemsMoved = 0;
            while (!s2.isEmpty() && temp > s2.peek()) {
                int temp2 = s2.pop();
                s1.push(temp2);
                itemsMoved++;
            }
            s2.push(temp);
            for (int i = 0; i < itemsMoved; i++) {
                temp = s1.pop();
                s2.push(temp);
            }
        }
        return s2;
    }

    public static void main(String args[]) throws Exception {
        Stack<Integer> testStack = new Stack<Integer>();
        Random rand = new Random();
        for (int i = 0; i < 50; i++) {
            testStack.push(rand.nextInt(100));
        }
        testStack.printStack(testStack);

        System.out.println("After sorting");
        Stack<Integer> sortedStack = sortStack(testStack);
        sortedStack.printStack(sortedStack);
    }
}









