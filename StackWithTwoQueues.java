import java.util.Queue;
import java.util.ArrayDeque;

public class StackWithTwoQueues {
    private Queue<Integer> storageQ = new ArrayDeque<>();
    private Queue<Integer> trafficQ = new ArrayDeque<>();
    private int top;

    // O(1)
    public void push(int item) {
        storageQ.add(item);
        top = item;
    }

    // O(n)
    public int pop() {
        if (isEmpty())
            throw new IllegalStateException();

        while (storageQ.size() > 1) {
            top = storageQ.remove();
            trafficQ.add(top);
        }

        swapQueues();

        return trafficQ.remove();
    }

    private void swapQueues() {
        var temp = storageQ;
        storageQ = trafficQ;
        trafficQ = temp;
    }

    // O(1)
    public boolean isEmpty() {
        return storageQ.isEmpty();
    }

    // O(1)
    public int size() {
        return storageQ.size();
    }

    // O(1)
    public int peek() {
        if (isEmpty())
            throw new IllegalStateException();

        return top;
    }

    @Override
    public String toString() {
        return storageQ.toString();
    }
}
