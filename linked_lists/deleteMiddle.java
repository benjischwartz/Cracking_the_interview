

public class deleteMiddle {

    public static void deleteMiddle(Node n) {
        Node next = n.getNext();
        n.setData(next.getData());
        n.setNext(next.getNext());
        n = null;
    } 
    public static void printLinkedList(Node n) {
        while (n.getNext() != null) {
            System.out.print(n.getData());
            System.out.print("-->");
            n = n.getNext();
        }
        System.out.println(n.getData());
    }

    public static void main(String[] args) {
        Node nodeOne = new Node(1);
        nodeOne.appendToTail(2);
        nodeOne.appendToTail(3);
        nodeOne.appendToTail(4);
        printLinkedList(nodeOne);
       
        Node secondNode = nodeOne.getNext();
        deleteMiddle(secondNode);
        printLinkedList(nodeOne);
    }


}



