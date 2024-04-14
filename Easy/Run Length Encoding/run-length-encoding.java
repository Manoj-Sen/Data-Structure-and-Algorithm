//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.encode(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String encode(String s) {
        // code here
        int n = s.length();
        String str = "";
        int i=0;
        int idx = 0;
        StringBuilder e = new StringBuilder();
        while(i<n){
            int cnt = 0;
            char c = s.charAt(i);
            
            while(i<n && s.charAt(i)==c){
                cnt++;
                i++;
            }
            
            e.append(c);
            idx++;
            
            if(cnt>=1){
                e.append(cnt);
            }
            
        }
        
        return e.toString();
    }
}
    