/*

Brute force: hash array li 256 size ki phir jo char string me hai vo check kiya list me hai ki nhi agr hai to break nhi to use hash array me store kiya len calc ki j - i + 1 return maxLen
Hash array- not hash table used for direct indexing jaise a ka ascii code 97 aur string me a aaya to 97 index pe 1 store karegi

Optimal sol: pointer l and r -> current window [l, r] containing char without repetition, maxlen jab tk r < n hai array pe iterate karo check kiya if currect char has occured before hash array se. if yes so update kro left pointer to index of current char + 1 len calc ki r-l+1 update ki maxLen, hash array update ki wirh current index r -> indicating most recent occurrence of char at point r in the string. return maxlen 
*/

import java.util.*;

class LongestNonRepeatingString{
    
    //time: O(n2) space: O(1)
    public static int Brutefsol(String s){
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            int[] hash = new int[256];
            Arrays.fill(hash, 0);
            for(int j = i; j < n; j++){
                if(hash[s.charAt(j)] == 1) break;
                hash[s.charAt(j)] = 1;
                int len = j - i + 1;
                maxLen = Math.max(maxLen, len);
            }
        }
        return maxLen;
    }
    
    //hash set 
    public static int HashSetsol(String s){
        int n = s.length();
        int l = 0; 
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            while(set.contains(s.charAt(i))){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(i));
            ans = Math.max(ans, i-l + 1);
        }
        return ans;
    }
    
    //Time: O(n) space: O(1)
    public static int Optimalsol(String s){
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int l = 0, r = 0, maxLen = 0;
        while(r < n){
            if(hash[s.charAt(r)] >= l){
                l = Math.max(hash[s.charAt(r)] + 1, l);
            }
            int len = r - l + 1;
            maxLen = Math.max(len, maxLen);
            hash[s.charAt(r)] = r;
            r++;
        }
        return maxLen;
    }
    
    public static void main (String[] args) {
        String s = "cadbzabcd";
        int len = Brutefsol(s);
        System.out.println(len);
        int len2 = Optimalsol(s);
        System.out.println(len2);
        int len3 = HashSetsol(s);
        System.out.println(len3);
    }
}
