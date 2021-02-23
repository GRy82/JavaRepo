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
}
