/*
Input: strs = ["flower","flow","flight"]
Output: "fl"
*/

import java.util.*;

class LongestCommonPrefix{
    public static String pref(String[] s){
        String minStr = s[0];
        int minLen = s[0].length();
        for(int i = 1; i < s.length; i++){
            if(minLen > s[i].length()){
                minStr = s[i];
                minLen = s[i].length();
            }
        }
        while(minLen > 0){
            int flag = 0;
            for(int i = 0; i < s.length; i++){
                if(s[i].substring(0, minLen).contains(minStr.substring(0, minLen)) != true){
                    flag = 1;
                }
            }
            if(flag == 0) return minStr.substring(0, minLen);
            minLen--;
        }
        return "";
    }
    public static void main (String[] args) {
        String[] strs = {"flower","flow","flight"};
        System.out.println(pref(strs));
    }
}