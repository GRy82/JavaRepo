import java.util.Arrays;

public class PriorityQueue {
    private int[] queue = new int[5];
    private int count;

    public void add(int newElement){
        if (count == queue.length){
            int[] array = new int[queue.length * 2];
            for(int j = 0; j <= queue.length; j++)
                array[j] = queue[j];

            queue = array;
        }

        int i;
        for(i = count - 1; i >= 0; i--){
            if(queue[i] > newElement)
                queue[i + 1] = queue[i];
            else
                break;
        }

        queue[i+1] = newElement;
        count++;     
    } 

    public int remove(){
        if(isEmpty())
            throw new IllegalStateException();

        return queue[--count];
    }

    public boolean isEmpty(){
        return count == 0;
    }
    
    @Override
    public String toString(){
        return Arrays.toString(queue);
    }


}
