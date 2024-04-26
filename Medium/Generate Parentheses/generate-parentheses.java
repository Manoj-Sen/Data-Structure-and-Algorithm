//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        List<String> result = new ArrayList<>();
        solve(n, "", 0, 0,result);
        return result;
    }

    private void solve(int n, String curr, int open, int close,List<String> result ) {
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        if (open < n) {
            curr += '(';
            solve(n, curr, open + 1, close,result);
            curr = curr.substring(0, curr.length() - 1);
        }
        if (close < open) {
            curr += ')';
            solve(n, curr, open, close + 1,result);
            curr = curr.substring(0, curr.length() - 1);
        }
    }
}