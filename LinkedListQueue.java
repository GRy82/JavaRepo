public class LinkedListQueue {
    private Node first;
    private Node last;
    private int size;

    private class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    }

    public void enqueue(int value){//O(1)
        Node enqueuedNode = new Node(value);

        if(!isEmpty())
            enqueuedNode.next = first;
        else
            last = enqueuedNode;
        
        first = enqueuedNode;
    }

    public boolean isEmpty(){
        return first == null;
    }
    
}
