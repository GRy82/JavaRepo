import java.util.Stack;

public class QueueOfStacks {
    Stack<Integer> enqueueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int enqueued){
        while(!dequeueStack.isEmpty())
            enqueueStack.push(dequeueStack.pop());
        
        enqueueStack.push(enqueued);
    }

    public int dequeue(){
        if (enqueueStack.isEmpty())
            throw new IllegalStateException();
        
        while(!enqueueStack.isEmpty())
            dequeueStack.push(enqueueStack.pop());

       return dequeueStack.pop();
    }

}
