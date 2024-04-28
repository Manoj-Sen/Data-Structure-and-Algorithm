//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.removeOuter(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String removeOuter(String s) {
        // code here
        Stack<Character> st = new Stack<>();
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            
            if(ch=='('){
                if(st.size()>0){
                    sb.append(ch);   // ch = '('
                }
                st.push(ch);
            }else{
                st.pop();
                if(st.size()>0){
                    sb.append(ch);   // ch = ')'
                }
            }
        }
        return sb.toString();
    }
}
