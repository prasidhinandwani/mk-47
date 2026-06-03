/* Q71 leetcode: https://leetcode.com/problems/simplify-path/description/?envType=study-plan-v2&envId=top-interview-150
Input: path = "/home//foo/"
Output: "/home/foo"
given conditions k basis pe push pop kiya -> stack -> '/' pe split kiya
*/

import java.util.*;

class SimplifyPath{
    public static String simplifyP(String path){
        Stack<String> st = new Stack<>();
        String[] p = path.split("/");
        for(String s : p){
            if(s.equals(".") || s.equals("")){
                continue;
            }
            if(s.equals("..")){
                if(!st.isEmpty()) st.pop();
            }
            else{
                st.push(s);
            }
        }
        if(st.isEmpty()) return "/";
        StringBuilder ans = new StringBuilder();
        for(String dir : st){
            ans.append("/").append(dir);
        }
        return ans.toString();
    }
    public static void main (String[] args) {
        String path = "/home//foo/";
        System.out.println(simplifyP(path));
    }
}