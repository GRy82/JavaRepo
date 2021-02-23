
import java.util.Arrays;

public class ArrayQueue {

    private int[] queue;
    private int rear;
    private int count;
    private int front;

    public ArrayQueue(int capacity){
        this.queue = new int[capacity];
    }
    public void enqueue(int enqueued){
        if (count == queue.length)
            throw new IllegalStateException();

        queue[rear] = enqueued;     
        rear = (rear + 1) % queue.length;
        count++;   
    }

    public int dequeue(){
        int item = queue[front];
        queue[front] = 0;
        front = (front + 1) % queue.length;
        count--;
        return item;
    }

    public int peek(){
        return queue[front];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){
        return count == queue.length;
    }

    @Override
    public String toString(){
        return Arrays.toString(queue);
    }
}
