//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[]) {
        // code here
        Arrays.sort(arr);
        int[] res = new int[2];
        int[] freq = new int[arr.length];
        for(int i=0; i<arr.length; i++){
        freq[arr[i] - 1]++;
        if(freq[arr[i] - 1] > 1){
         res[0] = arr[i];
                    }
                }
        for(int i=0; i<freq.length; i++){
        if(freq[i] == 0){
         res[1] = i + 1;
                }
            }
        return res;
    }
}