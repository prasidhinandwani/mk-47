/*Q2230A codeforces: https://codeforces.com/problemset/problem/2230/A
*/

import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextInt();
            long a = sc.nextInt();
            long b = sc.nextInt();
            long ans;
            if(b >= 3*a){
                ans = n * a;
            }
            else{
                long g = n / 3;
                long r = n % 3;
                ans = g * b + Math.min(r * a, b);
            }
            System.out.println(ans);
        }
    }
}