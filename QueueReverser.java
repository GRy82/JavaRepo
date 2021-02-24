import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public static Queue<Integer> reverse(Queue<Integer> queue){
        Queue<Integer> reversed = new ArrayDeque<>();
        Stack<Integer> middleMan = new Stack<>();

        while(!queue.isEmpty())
            middleMan.push(queue.remove());

        while(!middleMan.isEmpty())
            reversed.add(middleMan.pop());

        return reversed;
    }

    public static Queue<Integer> reverse(Queue<Integer> queue, int k){
        Stack<Integer> reverser = new Stack<>();

        int counter = 1;
        while(counter <= k)
            reverser.push(queue.remove());

        while(!reverser.isEmpty())
            queue.add(reverser.pop());

        for(int i = 0; i < queue.size() - k; i++)
            queue.add(queue.remove());
        
        return queue;
    }
}
