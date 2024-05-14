//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0) {
            String arr[] = in.readLine().trim().split("\\s+");
            int S = Integer.parseInt(arr[0]);
            int N = Integer.parseInt(arr[1]);
            int M = Integer.parseInt(arr[2]);
            
            Solution ob = new Solution();
            System.out.println(ob.minimumDays(S, N, M));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minimumDays(int S, int N, int M){
        // code here
        int sunday = S/7;
        
        int buyying  = S - sunday;
        
        int totalfood = S*M;
        
        int ans = 0;
        
        if((S*M)%N!=0){
            ans = totalfood/N + 1;
        }else{
            ans = totalfood/N;
        }
        
        if(ans<=buyying)
            return ans;
        else
            return -1;
        
    }
}