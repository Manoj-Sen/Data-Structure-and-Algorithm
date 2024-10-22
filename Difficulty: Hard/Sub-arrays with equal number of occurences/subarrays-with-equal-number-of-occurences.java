//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends
// User function Template for Java

class Solution {

    static int sameOccurrence(int arr[], int x, int y) {
        // write code here
        Map<Integer,Integer>hmap = new HashMap<>();
        hmap.put(0,1);
        int sum = 0;
        int ans = 0;
        for(int val:arr){
            sum+=(val==x?1:(val==y?-1:0));
            ans+=hmap.getOrDefault(sum,0);
            hmap.put(sum,hmap.getOrDefault(sum,0)+1);
        }
        return ans;
    }
}

//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int x = Integer.parseInt(br.readLine());
            int y = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            int ans = ob.sameOccurrence(arr, x, y);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends