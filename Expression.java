import java.util.Stack;

public class Expression {
    public boolean isBalanced(String input){
        Stack<Character> brackets = new Stack<>();

        for (char character : input.toCharArray()){
            if(character == '(' || character == '<' || character == '['){
                brackets.push(character);
            }

            if(character == ')' || character == '>' || character == ']'){
                if(brackets.empty()) return false;
                char stackBracket = brackets.peek();
                if((character == '>' || character == ']') && stackBracket != character + 2)
                    return false;
                else if(character == ')' && stackBracket != character + 1){
                    return false;
                }
                else{
                    brackets.pop();
                }
            }
        }

        if(brackets.empty())
            return true;
        else
            return false;
        
    }
}
