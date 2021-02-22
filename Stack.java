import java.util.Arrays;

public class Stack {
    private int[] stack;
    private int count;

    public void push(int pushed){
        if (count == stack.length)
            throw new StackOverflowError();

        stack[count++] = pushed;
    }
    
    public int peek(){
        if (isEmpty()) throw new IllegalStateException();

        return stack[count - 1];
    }

    public int pop(){
        if (isEmpty()) throw new IllegalStateException();

        return stack[--count];
    }

    
    public boolean isEmpty(){
        return count == 0;
    }
    
    @Override
    public String toString(){
        var content = Arrays.copyOfRange(stack, 0, count);
        return Arrays.toString(content);
    }


}
