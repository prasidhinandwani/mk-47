import java.util.*;

public class LongestSubarrayPositive{
    //time: O(n^3) space: O(1)
    public static int brutesol(int[] arr, int p){
        int n = arr.length;
        int len = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                int sum = 0;
                for(int k = i; k < j; k++){
                    sum += arr[k];
                 }
                if(sum == p) len = Math.max(len, j - i);
            }
        }
        return len;
    }
    //time: O(n) space: O(n) will work for negative as well, this sol is optimal if arr has negative as well
    public static int bettersol(int[] arr, int p){
        int n = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxlen = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
            if(sum == p){
                maxlen = Math.max(maxlen, i + 1);
            }
            int rem = sum - p;
            if(map.containsKey(rem)){
                int len = i - map.get(rem);
                maxlen = Math.max(len, maxlen);
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }
        }
        return maxlen;
    }
    //time: O(n) apce: O(1)
    public static int optimalsol(int[] arr, int p){
        int n = arr.length;
        int maxlen = 0;
        int left = 0, right = 0;
        int sum = arr[0];
        while(right < n){
            while(left <= right && sum > p){
                sum -=arr[left];
                left++;
            }
            if(sum == p){
                maxlen = Math.max(maxlen, right - left + 1);
            }
            right++;
            if(right < n){
                sum += arr[right];
            }
        }
        return maxlen;
    }
    public static void main (String[] args) {
        int[] arr = {1, 2, 3, 1, 1, 1, 9};
        int p = 3;
        int n = brutesol(arr, p);
        System.out.println(n);
        int[] a = {1, 2, 0, 0, 3};
        int n2 = bettersol(a, p);
        System.out.println(n2);
        int n3 = optimalsol(arr, p);
        System.out.println(n3);
    }
}