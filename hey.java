import java.util.ArrayList;
import java.util.List;

class Solution {
    public static List<String> generateParenthesis(int n) {

        int o =n, c=n;
        StringBuilder stack = new StringBuilder();

        List<String> list = new ArrayList<>();
        recursion(stack,o,c,list);
        return list;


    }
    public static void recursion(StringBuilder stack, int o, int c, List<String> list) {

        if(o==0 && c==0){
            list.add(stack.toString());
            return ;
        }
        if(o>0){
            //open par
            stack.append('(');
            recursion(stack, o-1,c, list);
            stack.deleteCharAt(stack.length()-1);
        }

        if(c>0 && o<c){
            //close par
            stack.append(')');
            recursion(stack, o,c-1, list);
            stack.deleteCharAt(stack.length()-1);
            
        }
    }

    public static void main(String[] args) {

        int n = 3;
         System.out.println(generateParenthesis(n));
 
 
 
     }
}