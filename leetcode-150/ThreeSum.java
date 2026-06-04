/*Q15 leetcode: https://leetcode.com/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
sort kiya (ese kya mila 2 pointer laga sakte hai aur duplicate handle kr sakte hai) -> for(n-2 kyuki 3 values chaiye)(duplicate check kiya -> ek num a se phir left right pointer (sum liya agr sum == 0 ans me add kiya phir duplicate check kiya increment kiya) (agr sum < 0 bada sum chaiye l increment kiya)(nhi to r decrement kiya) overall l inc r dec)
*/

import java.util.*;

class ThreeSum{
    public static List<List<Integer>> sum(int[] a){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(a);
        int n = a.length;
        for(int i = 0; i < n-2; i++){
            if(i > 0 && a[i] == a[i-1]) continue;
            int l = i+1;
            int r = n-1;
            while(l < r){
                int s = a[i] + a[l] + a[r];
                if(s == 0){
                    ans.add(Arrays.asList(a[i], a[l], a[r]));
                    while(l < r && a[l] == a[l+1]) l++;
                    while(l < r && a[r] == a[r-1]) r--;
                    l++;
                    r--;
                }
                else if(s < 0) l++;
                else r--;
            }
        }
        return ans;
    }
    public static void main (String[] args) {
        int[] a = {-1, 0, 1, 2, -1, -4};

        List<List<Integer>> res = sum(a);

        for (List<Integer> x : res) {
            System.out.println(x);
        }
    }
    
}