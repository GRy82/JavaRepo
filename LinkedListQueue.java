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

    public int dequeue(){ //O(n)
        if(isEmpty()) throw new IllegalStateException();

        int dequeuedValue;

        if(first == last){
            dequeuedValue = last.value;
            first = last = null;
        }
        else{
            Node probe = first;
            while(probe.next != last)
                probe = probe.next;
    
            dequeuedValue = last.value;
            last = probe;
            last.next = null;
        }

        return dequeuedValue;
    }

    public int peek(){
        return last.value;
    }

    public boolean isEmpty(){
        return first == null;
    }
    
}
