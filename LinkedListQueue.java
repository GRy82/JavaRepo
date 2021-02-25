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

    public void enqueue(int value){
    
    }

    public boolean isEmpty(){
        return first == null;
    }
    
}
