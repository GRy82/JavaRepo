public class Stack {
    int[] stack;
    int topElement;
    int count;

    public void push(int pushed){
        if (count + 1 > stack.length){
            int[] newArray = new int[stack.length * 2];
            for (int i = 0; i < stack.length; i++){
                newArray[i] = stack[i];
            }
            stack = newArray;
        }

        stack[count] = pushed;
        topElement = pushed;
        count++;
    }
    
    public int peek(){
        if (isEmpty()) throw new IllegalArgumentException();

        return topElement;
    }

    public int pop(){

    }

    
    public boolean isEmpty(){
        if (count == 0) return true;

        return false;
    }
    


}