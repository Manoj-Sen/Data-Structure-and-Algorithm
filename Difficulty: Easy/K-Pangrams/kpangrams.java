//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        if(str.length() < 26)
            return false;
        
        int charCountPresent = 0, charCountAbsent = 0;
        int alphabet[] = new int[26];
        
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <='z')
                alphabet[ch - 'a'] += 1;
        }
        for(int i=0; i<26; i++){
            if(alphabet[i] == 0)
                charCountAbsent++;
            else
                charCountPresent += alphabet[i];
        }
        
        int extraCharPresent = charCountPresent - (26 - charCountAbsent);
        
        if(charCountAbsent <= extraCharPresent && charCountAbsent <= k)
            return true;
        return false;
    }
}