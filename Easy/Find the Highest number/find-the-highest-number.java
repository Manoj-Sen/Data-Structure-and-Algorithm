//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String s = br.readLine().trim();
            int n = Integer.parseInt(s);
            String S = br.readLine();
            String[] s1 = S.split(" ");
            List<Integer> a = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                a.add(Integer.parseInt(s1[i]));
            }
            Solution ob = new Solution();
            int ans = ob.findPeakElement(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public int findPeakElement(List<Integer> a) {
        // Code here
        int n = a.size();
        
        if(a.get(0)>a.get(1))  return a.get(0);
        
        if(a.get(n-1)>a.get(n-2)) return a.get(n-1);
        
        int low = 1;
        int high = n-2;
        
        while(low<=high){
            int mid = (low+high)/2;
            
            if(a.get(mid-1)<a.get(mid)  && a.get(mid+1)<a.get(mid)){
                return a.get(mid);
            }else if(a.get(mid)>a.get(mid-1)){
                low = low+1;
            }else{
                high = high-1;
            }
        }
        
        return -1;
    }
}