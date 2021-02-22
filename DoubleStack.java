public class DoubleStack {
    private int[] stack = new int[10];
    private int limiter1;
    private int limiter2 = stack.length - 1;

    public void push1(int pushed){
        if (isFull1()) throw new StackOverflowError();

        stack[limiter1++] = pushed;
    }

    public void push2(int pushed){
        if (isFull2()) throw new StackOverflowError();

        stack[limiter2--] = pushed;
    }

    public int pop1(){
        if (isEmpty1()) throw new IllegalStateException();

        return stack[--limiter1];
    }

    public int pop2(){
        if (isEmpty2()) throw new IllegalStateException();

        return stack[++limiter2];
    }

    public boolean isEmpty1(){
        return limiter1 == 0;
    }

    public boolean isEmpty2(){
        return limiter2 == stack.length - 1;
    }
    
    public boolean isFull1(){
        return limiter2 <= limiter1;
    }
    public boolean isFull2(){
        return limiter2 <= limiter1;
    }
}
