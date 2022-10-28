import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args){

        String s = "{}(())[}()";
        System.out.println("Valid: " + Solution.isValid(s));
    }
}

class Solution{

    public static boolean isValid(String s){
        Stack<Character> brackets = new Stack<>();
        Map<Character,Character> pairs = new HashMap<>();
        pairs.put('(',')');
        pairs.put('{','}');
        pairs.put('[',']');
        for (int i=0; i< s.length(); i++){
            if(!brackets.isEmpty()){
                Character prev = brackets.peek();
                if(pairs.get(prev) == null)
                    return false;
                if(pairs.get(prev) == s.charAt(i)){
                    brackets.pop();
                    continue;
                }
            }
            brackets.push(s.charAt(i));
        }
        return brackets.isEmpty();
    }
}