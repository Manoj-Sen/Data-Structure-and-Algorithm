//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.HashMap;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int k = Integer.parseInt(br.readLine());

            ArrayList<Integer> ans = new Solution().countDistinct(arr, k);

            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();

            t--;
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    ArrayList<Integer> countDistinct(int arr[], int k) {
        // code here
        int i =0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer , Integer> hm = new HashMap<>();
        int n = arr.length;
        while(j<n){
            hm.put(arr[j], hm.getOrDefault(arr[j] ,0)+1);

            while(j-i+1 >k){
                hm.put(arr[i], hm.get(arr[i])-1);
                if(hm.get(arr[i]) ==0){
                    hm.remove(arr[i]);
                }
                i++;
            }
            if(j-i+1 ==k){
                ans.add(hm.size());
            }

            j++;
        }
        return ans;
    }

}
