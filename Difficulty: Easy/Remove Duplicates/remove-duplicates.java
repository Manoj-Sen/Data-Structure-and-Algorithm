//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String s = read.readLine();

            Solution ob = new Solution();
            String result = ob.removeDups(s);

            System.out.println(result);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    String removeDups(String str) {
        String result = "";
        ArrayList<Character> list = new ArrayList<>();
        int len = str.length();
        for(int i = 0; i < len; i++){
            if(!list.contains(str.charAt(i))){
                   result += str.charAt(i);
                   list.add(str.charAt(i));
            }
        }
        return result;    
    }
}