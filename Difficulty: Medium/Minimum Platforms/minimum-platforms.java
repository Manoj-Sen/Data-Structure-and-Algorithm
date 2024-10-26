//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int n = Integer.parseInt(str[0]);

            int arr[] = new int[n];
            int dep[] = new int[n];

            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(str[i]);
            str = read.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) dep[i] = Integer.parseInt(str[i]);

            System.out.println(new Solution().findPlatform(arr, dep));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find the minimum number of platforms required at the
    // railway station such that no train waits.
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
         Arrays.sort(arr);
        Arrays.sort(dep);
        
        int a = 1;
        int d = 0;
        int plat = 1; // for the first train we will need one platform at least.
        int maxPlat = 1;
        
        while( a < arr.length && d < dep.length){
            // when platform is occupied:
            if(arr[a] <= dep[d] ){
                a++;
                plat++;
                maxPlat = Math.max(maxPlat, plat);
            } else if( arr[a] > dep[d]){
                // when a platform is free:
                d++;
                plat--;
            }
        }
        
        return maxPlat;
    }
}
