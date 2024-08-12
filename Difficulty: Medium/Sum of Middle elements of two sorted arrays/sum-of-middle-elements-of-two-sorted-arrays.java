//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int m=arr1.length;
        int n=arr2.length;
        int sum=n+m;
        int mid=sum/2;
        int i=0,j=0,cnt=0,res=0;
        while(i<m&&j<n){
            if(arr1[i]<=arr2[j]){
                
                cnt++;
                if(cnt==mid){
                    res+=arr1[i];
                }
                if(cnt==mid+1){
                    res+=arr1[i];
                    return res;
                }
                i++;
            }else{
                
                 cnt++;
                if(cnt==mid){
                    res+=arr2[j];
                }
                if(cnt==mid+1){
                    res+=arr2[j];
                    return res;
                }
                j++;
            }
        }
        return res;
        
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends