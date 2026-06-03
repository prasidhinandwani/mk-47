/*Q167 leetcode: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
sorted array given hai, output me 1-based indexing -> 2 pointer -> jb tk l < r(sum=a[l]+a[r] agr sum=target(output) agr sum<target(l++) else(r--))
2nd approach hashmap se 
*/

import java.util.*;

class TwosumSorted{
    public static int[] twoSum(int[] a, int t){
        int l = 0;
        int r = a.length - 1;
        while(l < r){
            int sum = a[l] + a[r];
            if(sum == t){
                return new int[] {l+1, r+1};
            }
            else if(sum < t){
                l++;
            }
            else{
                r--;
            }
        }
        return new int[] {-1, -1};
        
    }
    public static int[] twoSumHash(int[] a, int t){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            int rem = t - a[i];
            if(map.containsKey(rem)) return new int[] {map.get(rem) + 1, i + 1};
            map.put(a[i], i);
        }
        return new int[]{-1, -1};
    }
    public static void main (String[] args) {
        int[] a = {2,7,11,15};
        int t = 9;
        int[] n1 = twoSum(a, t);
        for(int i = 0; i < n1.length; i++){
            System.out.print(n1[i] + " ");
        }
        int[] n2 = twoSumHash(a, t);
        for(int i = 0; i < n2.length; i++){
            System.out.print(n2[i] + " ");
        }
    }
}