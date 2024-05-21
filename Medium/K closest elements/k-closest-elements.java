//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int k = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);

            int[] ans = new Solution().printKClosest(arr, n, k, x);
            for (int xx : ans) {
                System.out.print(xx + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Pair{
    int first;
    int dist;
    Pair(int first,int dist)
    {
        this.first=first;
        this.dist=dist;
    }
}

class Solution {
    int[] printKClosest(int[] arr, int n, int k, int x) {
        // code here
        PriorityQueue<Pair> pq=new PriorityQueue<>((z,y)->{
            if(z.dist==y.dist)
            {
                return y.first-z.first;
            }
            return z.dist-y.dist;
            });
        for(int i=n-1;i>=0;i--)
        {
            if(arr[i]==x)
                continue;
            pq.add(new Pair(arr[i],Math.abs(arr[i]-x)));
        }
        int []ans=new int[k];
        for(int i=0;i<k;i++)
        {
            ans[i]=pq.remove().first;
        }
        return ans;
    }
}