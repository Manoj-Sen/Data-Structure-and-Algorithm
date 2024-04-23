//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.firstElement(n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    static int firstElement(int n) {
        // code here
        int mod = 1000000007;
        int f0 = 1;
        int f1 = 1;
        int fib = 1;
        
        for(int i=2;i<n;i++){
            fib = ((f0 % mod) + (f1 % mod)) % mod;
            f0 = f1;
            f1 = fib;
        }
        
        return fib % mod;
    }
}