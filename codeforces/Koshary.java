/*2227 A. Koshary codeforces: https://codeforces.com/problemset/problem/2227/A
(0,0) se start kiya long step +2 short step +1
even,even reachable
idd, even reachable
even odd reachable
odd odd not recheable
only imposible case x y dod odd honge to 2 short step lagenge
*/

import java.util.*;

public class Koshary{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(x % 2 == 1 && y % 2 == 1) System.out.println("NO");
            else System.out.println("YES");
        }
    }
}