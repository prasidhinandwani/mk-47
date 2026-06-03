/* Q56 leetcode: https://leetcode.com/problems/merge-intervals/description/?envType=study-plan-v2&envId=top-interview-150
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
sort kra kaise -> arr me a aur b liya a ka first el- b ka firtel (ex: 1-2: -ve a phele, +ve b phele, equal) s me firstel, 
(first interval ka) -> index 1 se start kiya kyuki 0 already sort hogaya (check kro kya overlap hai if yes then merge) a
gr overlap nhi hai to phele vala interval store kr lo 
*/

import java.util.*;

class MergeInterval{
    public static int[][] merge(int[][] arr){
        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        List<int[]> ans = new ArrayList<>();
        int s = arr[0][0];
        int e = arr[0][1];
        for(int i = 1; i < arr.length; i++){
            if(arr[i][0] <= e){
                e = Math.max(e, arr[i][1]);
            }
            else{
                ans.add(new int[]{s, e});
                s = arr[i][0];
                e = arr[i][1];
            }
        }
        ans.add(new int[] {s, e});
        return ans.toArray(new int[ans.size()][]);
    }
    public static void main (String[] args) {
        int[][] arr = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] res = merge(arr);

        for(int i = 0; i < res.length; i++) {
            System.out.print("[" + res[i][0] + "," + res[i][1] + "] ");
        }
    }
}
