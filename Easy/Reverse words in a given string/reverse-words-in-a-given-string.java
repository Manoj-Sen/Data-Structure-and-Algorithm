//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.reverseWords(s));
            t--;
        }
    }
}

// } Driver Code Ends



class Solution 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        // code here 
        Stack<String> st = new Stack<>();
        S += ".";
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char ch = S.charAt(i);

            if (ch == '.') {
                st.push(str.toString());
                str = new StringBuilder();
            } else {
                str.append(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (st.size() != 1) {
            ans.append(st.peek()).append(".");
            st.pop();
        }

        ans.append(st.peek());

        return ans.toString();
    }
}