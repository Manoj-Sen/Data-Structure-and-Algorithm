//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            long[] ans = new long[n];
            ans = ob.productExceptSelf(array);

            for (int i = 0; i < n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static long[] productExceptSelf(int nums[]) {
        long[] leftProduct = new long[nums.length];
        long[] rightProduct = new long[nums.length];
        
        long product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightProduct[i] = product;
            product = product * nums[i];
        }
        
        product = 1;
        for (int i = 0; i < nums.length; i++) {
            leftProduct[i] = product;
            product = product * nums[i];
        }
        
        long[] solution = new long[nums.length];
        for (int i = 0; i < nums.length; i++) {
            solution[i] = leftProduct[i] * rightProduct[i];
        }
        
        return solution;
    }
}
