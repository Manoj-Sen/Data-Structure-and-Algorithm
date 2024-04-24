//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java


class Solution
{
    public static int ways(int n, int m)
    {
        int[] [] dp = new int[n+1][m+1];
        for(int []r: dp){
            Arrays.fill(r,-1);
        }
        return solve(n,m,dp);
        
    }
    
    static int solve(int i,int j,int[][] dp){
        int mod = 1000000007;
        if(i<0 || j<0)  return 0;
        if(i==0 || j==0)  return 1;
        
        if(dp[i][j]!=-1)  return dp[i][j];
        int ls = solve(i-1,j,dp);
        int rs = solve(i,j-1,dp);
        
        return dp[i][j] = (ls+rs)%mod;
    }
}

//{ Driver Code Starts.

// Driver class
class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    int x=Integer.parseInt(elements[0]);
		    int y=Integer.parseInt(elements[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.ways(x,y));
		}
	}
}
// } Driver Code Ends