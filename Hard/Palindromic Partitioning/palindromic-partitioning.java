//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
     static int palindromicPartition(String str){
        
        int n=str.length();
        int dp[][]=new int[n][n];
        boolean isPal[][]=new boolean[n][n];
        //dp[i][j]->represents minimum cuts for substring[i...j]
        
        for(int i=0;i<n;i++){
            dp[i][i]=0;
            isPal[i][i]=true;
        }
        
        for(int gap=1;gap<n;gap++){
            for(int i=0;i+gap<n;i++){
                int j=i+gap;
                dp[i][j]=Integer.MAX_VALUE;
                if(str.charAt(i)==str.charAt(j) && (isPal[i+1][j-1] || gap==1)){
                    dp[i][j]=0;
                    isPal[i][j]=true;
                }
                else{
                    for(int k=i;k<j;k++){
                        dp[i][j]=Math.min(dp[i][j],1+dp[i][k]+dp[k+1][j]);
                    }
                }
            }
        }
        
        return dp[0][n-1];
        
    }
}