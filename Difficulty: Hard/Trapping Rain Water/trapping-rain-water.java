//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            int arr[] = new int[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().maxWater(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
     public int maxWater(int arr[]) 
    {
        int n = arr.length;
        int pre_max[] = new int[n];
        int suff_max[] = new int[n];
        
        int maximum_till_now = 0;
        
        for(int i=0; i<n; i++)
        {
            maximum_till_now = Math.max(maximum_till_now, arr[i]);
            pre_max[i] = maximum_till_now;
        }
        
        maximum_till_now = 0;
        
        for(int i=n-1; i>=0; i--)
        {
            maximum_till_now = Math.max(maximum_till_now, arr[i]);
            suff_max[i] = maximum_till_now;
        }
        
        int total_water = 0;
        
        for(int i=0; i<n; i++)
        {
            int curr_water = Math.min(pre_max[i], suff_max[i]) - arr[i];
            total_water += curr_water;
        }
        
        return total_water;
        
    }
}
