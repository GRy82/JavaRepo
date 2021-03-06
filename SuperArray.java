public class SuperArray {

    private int count;
    private int[] array;
    
    public SuperArray(int length){
        this.count = 0;
        this.array = new int[length];
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

    public void removeAt(int removalIndex){
        if(removalIndex < 0 || removalIndex >= count)
            throw new IllegalArgumentException();  

        for(int i = removalIndex; i < count; i++)
            array[i] = array[i+1];

        count--;
    }

    public int indexOf(int element){
        for(int i = 0; i < count; i++)
            if(array[i] == element)
                return i;

        return -1;
    }
    
}
