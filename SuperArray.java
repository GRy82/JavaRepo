public class SuperArray {

    private int count;
    private int capacity;
    private int[] array;
    
    public SuperArray(int length){
        this.count = 0;
        this.array = new int[length];
        this.capacity = length;
    }

    public void insert(int value){
        if(array.length == count){
            int[] tempArray = new int[count * 2];
            
            for (int i = 0; i < count; i++)
                tempArray[i] = array[i];
    
            array = tempArray;
        }

        array[count++] = value;
    }

    
    
}
