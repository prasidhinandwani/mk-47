/*Q20 leetcode: https://leetcode.com/problems/valid-parentheses/description/?envType=problem-list-v2&envId=stack
Input: s = "()[]{}"
Output: true
hashmap me key value pair banaya
Opening bracket mile -> stack mein dalo.
Closing bracket mile -> stack k top se matching opening bracket check karo
Kahin mismatch hua ya end mein stack empty nahi hua -> invalid, wrna valid
*/

import java.util.*;

class ValidParentheses{
    public static boolean valid(String s){
        HashMap<Character, Character> map = new HashMap<>();
        Stack<Character> st = new Stack<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for(char c : s.toCharArray()){
            if(!map.containsKey(c)) st.push(c);
            else{
                if (st.isEmpty() || st.pop() != map.get(c)) return false;
            }
        }
        return st.isEmpty();
    }
    public static void main (String[] args) {
        String s = "()[]{}";
        System.out.println(valid(s));
    }
}
