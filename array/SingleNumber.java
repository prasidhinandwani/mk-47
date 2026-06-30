import java.util.*;

public class SingleNumber{
    //time: O(n^2) space: O(1)
    public static int brutesol(int[] nums){
        int n = nums.length;
        for(int i = 0; i < n; i++){
            int num = nums[i];
            int cnt = 0;
            for(int j = 0; j < n; j++){
                if(nums[j] == num) cnt++;
            }
            if(cnt == 1) return num;
        }
        return 0;
    }
    
    // time: O(n + max) space: O(max) won't wokr with negative num or big num then use hashmap 
    public static int bettersol(int[] nums){
        int n = nums.length;
        int max = nums[0];
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
        }
        int[] hash = new int[max + 1];
        Arrays.fill(hash, 0);
        for(int i = 0; i < n; i++){
            hash[nums[i]]++;
        }
        for(int i= 0; i < n; i++){
            if(hash[nums[i]] == 1) return nums[i];
        }
        return 0;
    }
    //time: O(n) space: O(n)
    public static int bettersol2(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int x : nums){
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        for(int x : nums){
            if(map.get(x) == 1) return x;
        }
        return 0;
    }
    // time: O(n) space: O(1)
    public static int optimalsol(int[] nums){
        int xor = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            xor = xor ^ nums[i];
        }
        return xor;
    }
    public static void main (String[] args) {
        int[] nums = {2,2,1};
        int n = brutesol(nums);
        System.out.println(n);
        int n2 = bettersol(nums);
        System.out.println(n2);
        int n3 = bettersol2(nums);
        System.out.println(n3);
        int n4 = optimalsol(nums);
        System.out.println(n4);
    }
}