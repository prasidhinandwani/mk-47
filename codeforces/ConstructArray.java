/* A. Construct an Array codeforces: https://codeforces.com/problemset/problem/2231/A
input: n = 3
output: 6 2 3 
how: 6+2=8, 2+3=5 ser: 6 2 3 8 5

input diya usr ne no. of test case phir diye utne no., jo num diya us size ki esi array banani hai taki us array k adjacent no. ka sum aur us array k sare no. unique ho, repetion not allowed
logic: num do type k even odd ye common kabhi nhi honge aur 2 odd ka sum even hoga to ye use kiya a[i] = 2*i - 1
*/

import java.util.*;

public class ConstructArray{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            for(int i = 1; i <= n; i++){
                System.out.print(2*i - 1 + " ");
            }
        }
    }
}