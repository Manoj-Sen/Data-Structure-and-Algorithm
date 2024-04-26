//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s1 = br.readLine();
            String[] S = s1.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            int ans = ob.editDistance(s, t);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int editDistance(String s, String t) {
        // Code here
        int dp[][] = new int[s.length()+1][t.length()+1];
        
        
        for(int i = 0 ; i <=s.length() ; i++){
            dp[i][0] = i ;
        }
        
        for(int j = 0 ; j <=t.length() ; j++){
            dp[0][j] = j ;
        }
        
        for(int i = 1 ; i <= s.length() ; i ++){
            for(int j = 1 ; j <=t.length() ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1]; 
                }
                else{
                    dp[i][j] =1+ Math.min(Math.min(dp[i-1][j] , dp[i][j-1]) , dp[i-1][j-1]);
                }
            }
        }
        
        return dp[s.length()][t.length()];
    }
}