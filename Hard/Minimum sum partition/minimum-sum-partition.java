//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int A[] = new int[n];
                    for(int i = 0;i<n;i++)
                        A[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minDifference(A,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{

	public int minDifference(int arr[], int n) 
	{
	    int renge = 0;
	    for(int i=0;i<n;i++){
	        renge+=arr[i];
	    }
	    boolean dp[][] = new boolean[arr.length+1][renge+1];
	    
	    //apply subset sum where sum = renge
	    for(int i=0;i<=arr.length;i++){
	        for(int j=0;j<=renge;j++){
	            if(i==0 && j==0){
	                dp[i][j] = true;
	            }else if(i==0 && j>0){
	                dp[i][j] = false;
	            }else if(arr[i-1]>j){
	                dp[i][j] = dp[i-1][j];
	            }else{
	                dp[i][j] = (dp[i-1][j] || dp[i-1][j-arr[i-1]]);
	            }
	        }
	    }
	    ArrayList<Integer> list = new ArrayList<>();
	    for(int i=0;i<=renge/2;i++){
	        if(dp[dp.length-1][i]==true){
	            list.add(i);
	        }
	    }
	    
	    int ans = Integer.MAX_VALUE;
	    for(int i=0;i<list.size();i++){
	        ans = Math.min(ans,renge-(2*list.get(i)));
	    }
	    return ans;
	    
	    
	} 
}
