//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findMaxLen(S));
        }
    }
}


// } Driver Code Ends


//User function Template for Java
class Solution {
    static int findMaxLen(String S) {
        Stack<Character> st = new Stack<>();
        Stack<Integer> index = new Stack<>();
        index.push(-1);
        int maxl = 0;
        
        for(int i =0; i< S.length();i++){
            char ch = S.charAt(i);
            if(ch =='('){
                st.push(ch);
                index.push(i);
            }
            else if(ch ==')' && !st.isEmpty()){
                st.pop();
                index.pop();
                maxl = Math.max(maxl ,i - index.peek());
            }
            else if(st.isEmpty()){
                index.push(i);
            }
        }
        return maxl;
    }
};