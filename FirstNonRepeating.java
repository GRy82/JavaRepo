import java.util.HashMap;

public class FirstNonRepeating {
    public static char findFirstNonRepeating(String phrase){
        HashMap<Character, Integer> repeats = new HashMap<>();
        for(char letter : phrase.toCharArray())
            if (!repeats.containsKey(letter))
                repeats.put(letter, 1);
            else{
                var value = repeats.get(letter);
                repeats.replace(letter, ++value);
            }
        char firstNonRepeat = ' ';
        for (var pair : repeats.entrySet()){
            if (pair.getValue() == 1){
                firstNonRepeat = pair.getKey();
                break;
            }
        }

        return firstNonRepeat;
    }
}
