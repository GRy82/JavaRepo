import java.util.HashSet;

public class FirstRepeating {

    public char FindFirstRepeating(){
        HashSet<Character> set = new HashSet<>();
        String phrase = "green apple";
        
        for(char letter : phrase.toCharArray()){
            if (set.contains(letter))
                return letter;

            set.add(letter);
        }

        return Character.MIN_VALUE;
    }
    
}
