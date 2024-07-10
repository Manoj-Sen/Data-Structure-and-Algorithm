//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int mat[][] = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }
            Solution ob = new Solution();
            System.out.println(ob.maxSquare(n, m, mat));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static int maxSquare(int n, int m, int mat[][]) {
        int ans=0;
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(mat[i][j]==1){
                    if(mat[i][j-1]>0 &&
                    mat[i-1][j-1]>0 && 
                    mat[i-1][j]>0){
                        mat[i][j]=Math.min(mat[i-1][j-1],Math.min(mat[i-1][j],mat[i][j-1]))+1;    
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans=Math.max(ans,mat[i][j]);
                //System.out.print(mat[i][j]);
            }
            //System.out.println();
        }
        return ans;
    }
}