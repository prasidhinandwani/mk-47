/*Q3 leetcode: https://leetcode.com/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-interview-150
Input: s = "abcabcbb"
Output: 3
sliding window left = 0, ans = 0, HashSet jisme unique elem jayenge -> r ko traverse kra l to r(agr set me s.charAt(r) nhi hai to add kro -> 
agr set me vo hai to window shrink kro -> st.remove(s.charAt(l))l-- -> ans me maxValue (ans, r-l+1)) -> return ans
*/

import java.util.*;

class LongestSubstring{
    public static int longestSubstring(String s){
        int l = 0;
        int ans = 0;
        HashSet<Character> st = new HashSet<>();
        for(int r = 0; r < s.length(); r++){
            while(st.contains(s.charAt(r))){
                st.remove(s.charAt(l));
                l++;
            }
            st.add(s.charAt(r));
            ans = Math.max(ans, r - l + 1);
        }
        return ans;
    }
    public static void main (String[] args) {
        String s = "abcabcbb";
        System.out.println(longestSubstring(s));
    }
}