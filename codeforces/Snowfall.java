/*
array l elements ese reorder krne hai ki product divisible by 6 wale subarray ki count min ho jaye
prod 6 se kb divisible hoga -> ek 2 ka factor aur ek 3 ka factor dono chaiye 
Numbers ko 4 k grp me divide kiya
d = 6 se div, b = 2 se, c = 3 se, a = kisi se nhi
goal  b aur c ko door rakhna hai: d b a c or d c a b
*/

import java.io.*;
import java.util.*;


public class Snowfall{
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            List<Integer> d = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            List<Integer> c = new ArrayList<>();
            List<Integer> a = new ArrayList<>();
            for(int i = 0; i < n; i++){
                int x = Integer.parseInt(st.nextToken());
                if(x % 6 == 0) d.add(x);
                else if(x % 2 == 0) b.add(x);
                else if(x % 3 == 0) c.add(x);
                else a.add(x);
            }
            boolean first = true;
            for(int x : d){
                if(!first) ans.append(" ");
                ans.append(x);
                first = false;
            }
            for(int x : b){
                if(!first) ans.append(" ");
                ans.append(x);
                first = false;
            }
            for(int x : a){
                if(!first) ans.append(" ");
                ans.append(x);
                first = false;
            }
            for(int x : c){
                if(!first) ans.append(" ");
                ans.append(x);
                first = false;
            }
            ans.append("\n");
        }
        System.out.print(ans);
    }
}