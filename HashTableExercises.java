import java.util.HashMap;

public class HashTableExercises {
    public int mostRepeated(int[] arrayOfInts){
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (var number : arrayOfInts){
            var count = hashMap.getOrDefault(number, 0);
            hashMap.put(number, count + 1);
        }
        
        int mostRepeated = arrayOfInts[0];
        int repetitions = -1;

        for(var pair : hashMap.entrySet()){
            if (pair.getValue() > repetitions){
                repetitions = pair.getValue();
                mostRepeated = pair.getKey();
            }
        }

        return mostRepeated;     
    }
}
