//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        while (tc-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int arr[][] = new int[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            new Solution().setMatrixZeroes(arr);
            for (int[] row : arr) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


//Back-end complete function Template for Java
class Solution {
    public void setMatrixZeroes(int[][] mat) {
        List<Integer> is = new ArrayList<Integer>();
        List<Integer> js = new ArrayList<Integer>();
        int n = mat.length, m=mat[0].length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(mat[i][j]==0) {
                    if(!is.contains(i)) is.add(i);
                    if(!js.contains(j)) js.add(j);
                }
            }
        }
        
        for(int i=0;i<is.size(); i++) {
            for(int j=0;j<m; j++) {
                mat[is.get(i)][j]=0;
            }
        }
        for(int j=0;j<js.size(); j++) {
            for(int i=0;i<n; i++) {
                mat[i][js.get(j)]=0;
            }
        }
    }
}