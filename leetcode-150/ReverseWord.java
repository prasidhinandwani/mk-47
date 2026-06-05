/*

Input: s = "the sky is blue"
Output: "blue is sky the"
string tokenizer
*/

import java.util.*;

class ReverseWord{
    public static String rev(String s){
        StringTokenizer st = new StringTokenizer(s);
        Stack<String> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();
        while(st.hasMoreTokens()){
            stack.push(st.nextToken());
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
            if(!stack.isEmpty()) ans.append(" ");
        }
        return ans.toString();
    }
    public static void main (String[] args) {
        
        String s = "the sky is blue";
        System.out.println(rev(s));
    }
}