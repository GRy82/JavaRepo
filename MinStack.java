public class MinStack {
    private int[] stack = new int[5];
    private int count;
    private int[] minsHistory = new int[5];
    private int minsCount;


    
    public void push(int pushed){
        stack[count++] = pushed;
        
        if(count == 1 || pushed <= minsHistory[minsCount - 1])
            minsHistory[minsCount++] = pushed;
    }
    
    public int pop(){
        if (count == 0) throw new IllegalStateException();

        if (stack[count - 1] == minsHistory[minsCount - 1])
            minsCount--;

        return stack[--count];
    }

    public void min(){
        System.out.println(minsHistory[minsCount - 1]);
    }
}
