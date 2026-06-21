/* Q286 leetcode: https://leetcode.com/problems/missing-number/description/

Missing Number
arr = [1, 2, 4, 5] output = 3
*/

import java.util.*;

public class MissingNumber{
    public static int Brutesol(int[] arr){
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int flag = 0;
            for(int j = 0; j < n-1; j++){
                if(arr[j] == i){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                return i;
            }
        }
        return -1;
    }
    //time: O(n), spac: O(n)
    public static int BetterSol(int[] arr){
        int n = arr.length;
        int[] hash = new int[n+1];
        Arrays.fill(hash, 0);
        for(int i = 0; i < n-1; i++){
            hash[arr[i]] = 1;
        }
        for(int i = 1; i < n; i++){
            if(hash[i] == 0){
                return i;
            }
        }
        return -1;
    }
    //time: O(n) space: O(1)
    public static int OptimalSol1(int[] arr){
        int n = arr.length + 1;
        int sum = n *(n+1) / 2;
        int sum2 = 0;
        for(int x : arr){
            sum2 += x;
        }
        return sum - sum2;
    }
    //
    public static int OptimalSol2(int[] arr){
        int n = arr.length + 1;
        int xor1 = 0;
        for(int x : arr){
            xor1 ^= x;
        }
        int xor2 = 0;
        for(int i = 1; i <= n; i++){
            xor2 ^= i;
        }
        return xor1 ^ xor2;
    }
    public static void main (String[] args) {
            int[] a = {1, 2, 4, 5};
            int r = Brutesol(a);
            System.out.println(r);
            int rb = BetterSol(a);
            System.out.println(rb);
            int ro1 = OptimalSol1(a);
            System.out.println(ro1);
            int ro2 = OptimalSol2(a);
            System.out.println(ro2);
    }
}