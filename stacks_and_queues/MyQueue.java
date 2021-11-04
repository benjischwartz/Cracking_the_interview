

// implement a MyQueue class which implements a queue using two stacks

public class MyQueue {
    private Stack<Integer> s1 = new Stack<Integer>();
    private Stack<Integer> s2 = new Stack<Integer>();

    // Functions: add(item), remove(), peek(), isEmpty();

    public void add(int item) throws Exception {
        if (s1.isEmpty()) {
            s1.push(item);
        } else {
            // move everything over from s1 to s2
            // push item into s1
            // move everything back over from s2 to s1
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            s1.push(item);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }
    }

    public void printQueue() throws Exception {
        while (!s1.isEmpty()) {
            System.out.print(s1.pop());
            System.out.print("-->");
        }
        System.out.println("end");
    }

    public static void main(String[] args) throws Exception {
        MyQueue testQueue = new MyQueue();
        testQueue.add(1);
        testQueue.add(2);
        testQueue.add(3);
        testQueue.add(1);
        testQueue.printQueue();
    }

}
