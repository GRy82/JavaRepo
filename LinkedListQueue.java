
public class LinkedListQueue {
    private Node head;
    private Node tail;
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

        if(isEmpty())
            head = tail = enqueuedNode;
        else{
            tail.next = enqueuedNode;
            tail = enqueuedNode;
        }
        
        size++;
    }

    public int dequeue(){ //O(n)
        if(isEmpty()) throw new IllegalStateException();

        int dequeuedValue;

        if(head == tail){
            dequeuedValue = head.value;
            head = tail = null;
        }
        else{
            Node dequeuedNode = head;
            dequeuedValue = dequeuedNode.value;
            head = dequeuedNode.next;
            dequeuedNode.next = null;
        }

        size--;
        return dequeuedValue;
    }

    public int peek(){ //O(1)
        if (isEmpty()) throw new IllegalStateException();

        return head.value;
    }

    public boolean isEmpty(){ //O(1)
        return head == null;
    }

    public int size(){ //O(1)
        return size;
    }
    
}
