import java.util.Stack;

public class QueueOfStacks {
    Stack<Integer> enqueueStack = new Stack<>();
    Stack<Integer> dequeueStack = new Stack<>();

    public void enqueue(int enqueued){
        enqueueStack.push(enqueued);
    }

    public int dequeue(){
        if (isEmpty())
            throw new IllegalStateException();
        
        stackTransfer();

       return dequeueStack.pop();
    }

    public boolean isEmpty(){
        return enqueueStack.isEmpty() && dequeueStack.isEmpty();
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException();

        stackTransfer();
        
        return dequeueStack.peek();
    }

    private void stackTransfer(){
        if(dequeueStack.isEmpty())
            while(!enqueueStack.isEmpty())
                dequeueStack.push(enqueueStack.pop());
    }

}
