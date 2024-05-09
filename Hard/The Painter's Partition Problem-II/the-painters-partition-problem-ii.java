//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line1[] = read.readLine().trim().split("\\s+");
            int k = Integer.parseInt(input_line1[0]);
            int n = Integer.parseInt(input_line1[1]);
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minTime(arr,n,k));
        }
    }
}


// } Driver Code Ends


//User function Template for Java

 class Solution{
     static long minTime(int[] arr,int n,int k)
    {
        
        long mini=Long.MIN_VALUE;
        long maxi=0;
        for(int i=0;i<n;i++)
        {
            maxi+=arr[i];
            if(mini<arr[i])
            {
                mini=arr[i];
            }
        }
        long low=mini;
        long high=maxi;
        int mid,sum,c;
        while(low<=high)
        {
            sum=0;
            c=1;
            mid=((int)low+(int)high)/2;
            for(int i=0;i<arr.length;i++)
            {
                if(sum+arr[i]<=mid)
                {
                    sum+=arr[i];
                }
                else
                {
                    c++;
                    sum=arr[i];
                }
            }
            if(c<=k)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return low;
    }
}


