import java.util.NoSuchElementException;

public class LinkedList {
    private class Node {
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
    
    }

    private Node last;
    private Node first;

    //add first
    public void addFirst(int newValue){
        var newNode = new Node(newValue);

         if(first == null)
            first = last = newNode;
        else{
            newNode.next = first;
            first = newNode;
        }
    }

    public void addLast(int newValue){
        var newNode = new Node(newValue);

        if(first == null)
            first = last = newNode;
        else{
            last.next = newNode;
            last = newNode;
        }
    }

    public void deleteFirst(){
        if (first == null)
            throw new NoSuchElementException();

        if(first == last){
            first = last = null;
            return;
        }

        var second = first.next;
        first.next = null;
        first = second;
    }

    public void deleteLast(){
        if(first == null) throw new NoSuchElementException();

        if (first == last){
            first = last = null;
            return;
        }
        
        var previous = getPrevious(last);
        last = previous;
        last.next = null;
    }

    private Node getPrevious(Node node){
        var probe = first;
        while(probe != null){
            if (probe.next == node) return probe;
            probe = probe.next;
        }
        return null;
    }

    public boolean contains(int value){
        return indexOf(value) != -1;
    }

    public int indexOf(int value){
        var probe = first;
        int counter = 0; 
        while(probe != null){
            if(probe.value == value)
                return counter;
            probe = probe.next;
            counter++;
        }
        return -1;
    }

    //add last
    //delete first
    //delete last
    //contains
    //indexOf
}
