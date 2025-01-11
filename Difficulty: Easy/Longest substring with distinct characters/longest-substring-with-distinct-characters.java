//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.longestUniqueSubstr(s));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        if(s.length() == 0 || s == null) return 0;
        
        java.util.Set<Character> set = new java.util.HashSet<>();
        
        int maxLength = 0, start = 0;
        
        for(int end = 0; end < s.length(); end++) {
            while(set.contains(s.charAt(end))) {
                set.remove(s.charAt(start));
                start++;
            }   
            set.add(s.charAt(end));
            
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}