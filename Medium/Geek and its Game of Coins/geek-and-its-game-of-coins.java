//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int x;
            x = Integer.parseInt(br.readLine());

            int y;
            y = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            int res = obj.findWinner(n, x, y);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static int findWinner(int n, int x, int y) {
        int []dp = new int[n+1];
        Arrays.fill(dp,-1);
        
        return solve(n,x,y,dp);
    }
    
    static int solve(int n, int x, int y, int[] dp)
    {
        if(n <= 1)
            return n;
        if(dp[n] != -1)
            return dp[n];
        int ans = 1;
        if(n >= x)
            ans &= solve(n - x, x, y, dp);
        if(n >= y)
            ans &= solve(n - y, x, y, dp);
        ans &= solve(n - 1, x, y, dp);
        return dp[n] = ans ^ 1;
    }
}
