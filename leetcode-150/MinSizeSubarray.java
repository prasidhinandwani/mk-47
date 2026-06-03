/* Q209 leetcode: https://leetcode.com/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
sliding window liye -> left=0, sum=0, ans=inf -> right ko left to right move kiya expand kri window(sum+=a[right] -> 
jb tk window valid hai sum>=t(ans me min length(0, r-l+1 -> ab window shrink krne ka try kro -> sum -a[left] -> left++))) 
return ans (min value k liye MAX_VAL and vice versa)
*/

class MinSizeSubarray{
    public static int min(int[] a, int t){
        int l = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for(int r = 0; r < a.length; r++){
            sum += a[r];
            while(sum >= t){
                ans = Math.min(ans, r-l+1);
                sum -= a[l];
                l++;
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    public static void main (String[] args) {
        int[] a = {2,3,1,2,4,3};
        int t = 7;
        System.out.println((min(a, t)));
    }
}