//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {

     int countPairs(int arr[], int target) {
        // Complete the function
        
        
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i:arr)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        int ans=0;
        for(Map.Entry<Integer,Integer>count:map.entrySet())
        {
            int key=count.getKey();
            //if the sum==target
            if(key+key==target)
            {
                int value=count.getValue();
                ans+=(value*(value-1))/2;
                
                if(map.size()==1)
                return ans;
            }
            else{
            int rem=target-key;

//rem>key is used to remove the duplicate countings
            if(map.containsKey(rem)&&rem>key)
            {
                int pair=(count.getValue()*map.get(rem));
                ans+=pair;
            }
        }
        }
        return ans;
    }
}


//{ Driver Code Starts.
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            String[] inputLine = br.readLine().trim().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }
            inputLine = br.readLine().trim().split(" ");
            int target = Integer.parseInt(inputLine[0]);

            Solution obj = new Solution();
            int res = obj.countPairs(arr, target);
            System.out.println(res);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends