import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Expression {

    private final List<Character> leftBrackets = Arrays.asList('(', '[', '{', '<');
    private final List<Character> rightBrackets = Arrays.asList(')', ']', '}', '>');

    public boolean isBalanced(String input){
        Stack<Character> brackets = new Stack<>();

        for (char character : input.toCharArray()){
            if(isLeftBracket(character)){
                brackets.push(character);
            }

            if(isRightBracket(character)){
                if(brackets.empty()) return false;

                if(!bracketsMatch(character, brackets.pop())) return false;
            }
        }

        return brackets.empty();   
    }

    private boolean isLeftBracket(char character){
        return leftBrackets.contains(character);
    }

    private boolean isRightBracket(char character){
        return rightBrackets.contains(character);
    }

    private boolean bracketsMatch(char character, char popped){
        return leftBrackets.indexOf(popped) == rightBrackets.indexOf(character);
    }
}
