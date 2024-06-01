//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String s;
            s = br.readLine();

            Solution obj = new Solution();
            String res = obj.oddEven(s);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static String oddEven(String s) {
        // code here
        HashMap<Character,Integer> m=new HashMap<>();
        for(char ch:s.toCharArray()) m.put(ch,m.getOrDefault(ch,0)+1);
        int x=0,y=0;
        for(char ch:m.keySet())
        {
            if(m.get(ch)%2==0   && (ch-'0')%2==0) x++;
            if(m.get(ch)%2!=0   && (ch-'0')%2!=0) y++;
            
        }
        return (x+y)%2==0? "EVEN":"ODD";
    }
}
