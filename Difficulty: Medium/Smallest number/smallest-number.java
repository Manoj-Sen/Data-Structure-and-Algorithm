//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while (tc-- > 0) {
            int s = sc.nextInt();
            int d = sc.nextInt();

            Solution obj = new Solution();
            String res = obj.smallestNumber(s, d);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends



class Solution {
    public String smallestNumber(int s, int d) {
        if (s == 0) {
            return (d == 1) ? "0" : "-1";
        }
        if (s > 9 * d) {
            return "-1";
        }
        
        int[] result = new int[d];
        
        for (int i = d - 1; i >= 0; i--) {
            if (s > 9) {
                result[i] = 9;
                s -= 9;
            } else {
                result[i] = s;
                s = 0;
            }
        }
        
       
        if (result[0] == 0) {
            result[0] = 1;
            for (int i = 1; i < d; i++) {
                if (result[i] > 0) {
                    result[i]--;
                    break;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            sb.append(num);
        }
        
        return sb.toString();
    }
}
