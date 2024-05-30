//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s1;
            s1 = br.readLine();

            String s2;
            s2 = br.readLine();

            Solution obj = new Solution();
            int res = obj.countWays(s1, s2);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    static final int MOD = (int)1e9 + 7;
    
    
    public static int countWays(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        
        // Create a 2D array dp[][].
        int[][] dp = new int[m + 1][n + 1];

        // Initialize dp[i][0] as 1 and dp[0][j] as 0 for all valid i, j.
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j <= n; j++) {
            dp[0][j] = 0;
        }

        // Fill rest of the entries in dp[][] using recursive formula.
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Return total count of subsequences of s1 equal to s2 modulo 1e9+7.
        return dp[m][n];
    }
}
