/* Q 238 leetcode: https://leetcode.com/problems/product-of-array-except-self/description/?envType=study-plan-v2&envId=top-interview-150
Input: nums = [1,2,3,4]
Output: [24,12,8,6]
jaise prefixsum aur suffixsum hota hai vaise prefixprod 
*/


class ProdArrayExceptSelf{
    public static int[] prod(int[] a){
        int[] out = new int[a.length];
        out[0] = 1;
        for(int i = 1; i < a.length; i++){
            out[i] = out[i-1] * a[i-1];
        }
        int rp =1;
        for(int i = a.length-1; i >= 0; i--){
            out[i] *= rp;
            rp *= a[i];
        }
        return out;
    }
    public static void main (String[] args) {
        int[] a = {1,2,3,4};
        int[] o = prod(a);
        for(int i = 0; i < o.length; i++){
            System.out.print(o[i] + " ");
        }
    }
    
}