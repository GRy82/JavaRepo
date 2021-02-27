import java.util.HashMap;

public class FirstNonRepeating {
    public static char findFirstNonRepeating(String phrase){
        
        HashMap<Character, Integer> repeats = new HashMap<>();

        char[] chars = phrase.toCharArray();

        for(var letter : chars){
            var value = repeats.containsKey(letter) ? repeats.get(letter) + 1 : 1;
            repeats.put(letter, value);
        }
           
        for(var letter : chars)
            if (repeats.get(letter) == 1)
                return letter;

        return Character.MIN_VALUE;
    }
}
