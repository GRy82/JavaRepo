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
    private int size;

    //add first
    public void addFirst(int newValue){
        var newNode = new Node(newValue);

         if(first == null)
            first = last = newNode;
        else{
            newNode.next = first;
            first = newNode;
        }

        size++;
    }

    public void addLast(int newValue){
        var newNode = new Node(newValue);

        if(first == null)
            first = last = newNode;
        else{
            last.next = newNode;
            last = newNode;
        }

        size++;
    }

    public void deleteFirst(){
        if (first == null)
            throw new NoSuchElementException();

        if(first == last)
            first = last = null;
        else{
            var second = first.next;
            first.next = null;
            first = second;
        }

        size--;
    }

    public void deleteLast(){
        if(first == null) throw new NoSuchElementException();

        if (first == last)
            first = last = null;
        else{
            var previous = getPrevious(last);
            last = previous;
            last.next = null;
        }
    
        size--;
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

    public int[] toArray(){
        int[] array = new int[size];
        var probe = first;
        int index = 0;
        while(probe != null){
            array[index++] = probe.value;
            probe = probe.next;
        }

        return array;
    }

    public void reverse(){
        var previous = first;
        var current = first.next;

        while(current != null){
            var next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        last = first;
        last.next = null;
        first = previous;
    }

    public int getKthFromTheEnd(int K){
        if (first == null)
            throw new IllegalStateException();

        var pointerA = first;
        var pointerB = first;

        for(int i = 0; i < K - 1; i++)
            pointerB = pointerB.next;
            if (pointerB == null)
             throw new IllegalArgumentException();

        while(pointerB != last){
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        } 

        return pointerA.value;
    }

    public void printMiddle(){
        if(first == null)
            return;

        Node traverserFast = first;
        Node traverserHalf = first;
        boolean unfinished = traverserFast == null || traverserFast.next == null;

        while(unfinished){
            traverserFast = traverserFast.next.next;
            traverserHalf = traverserHalf.next;
        }

        if(traverserFast == last)
            System.out.println(traverserHalf.value);
        else
            System.out.println(traverserHalf.value + "and " + traverserHalf.next.value)
        
    }

    public int size(){
        return size;
    }

    //add last
    //delete first
    //delete last
    //contains
    //indexOf
}
