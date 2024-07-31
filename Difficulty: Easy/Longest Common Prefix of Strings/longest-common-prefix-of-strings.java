//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        String res = "";
        int len = arr.length;
        for(int i = 0 ; i < arr[0].length() ; i++){
            char tar = arr[0].charAt(i);
            if(check(arr, tar, i)){
                res += tar;
            } else break;
        }
        return res.length() > 0 ? res : "-1";
    }
    public boolean check(String[] arr , char tar,int ind){
        for(int i = 1 ; i < arr.length ; i++){
            if(ind >= arr[i].length() || arr[i].charAt(ind) != tar) return false;
        }
        return true;
    }
}