import java.util.Stack;

public class StringReverser {
    public String reverse(String originalString){
        if(originalString == null)
            throw new IllegalArgumentException();

        Stack<Character> characterStack = new Stack<>();
        char[] characterArray = originalString.toCharArray();

        for (char character : characterArray ){
            characterStack.push(character);
        }

        StringBuffer reversedString = new StringBuffer();
        while(!characterStack.empty()){
            reversedString.append(characterStack.pop());
        }

        return reversedString.toString();
    }
}
