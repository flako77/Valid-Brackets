import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args){

        String s = "{}([]())";
        if(Solution.isValid(s)){
            System.out.print("Valid");
        }else{
            System.out.print("Invalid");
        }

    }
}

class Solution{

    public static boolean isValid(String s){
        boolean result = false;
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
        if (brackets.isEmpty()){
            result = true;
        }
        return result;
    }
}