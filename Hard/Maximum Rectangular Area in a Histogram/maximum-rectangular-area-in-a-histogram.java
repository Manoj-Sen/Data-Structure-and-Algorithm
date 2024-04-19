//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}




// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    private static long[] nextSmaller(long[] arr, long n) {
        Stack<Long> st = new Stack<>();
        st.add(-1L);
        long[] ans = new long[(int)n];

        for (int i = (int)n - 1; i >= 0; i--) {
            long curr = arr[i];

            while (st.peek() != -1 && arr[st.peek().intValue()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.add((long)i);
        }
        return ans;
    }
    
    private static long[] prevSmaller(long[] arr, long n) {
        Stack<Long> st = new Stack<>();
        st.add(-1L);
        long[] ans = new long[(int)n];

        for (int i = 0; i < n; i++) {
            long curr = arr[i];

            while (st.peek() != -1 && arr[st.peek().intValue()] >= curr) {
                st.pop();
            }
            ans[i] = st.peek();
            st.add((long)i);
        }
        return ans;
    }

    public static long getMaxArea(long[] hist, long n) {
        long[] next = nextSmaller(hist, n);
        long[] prev = prevSmaller(hist, n);
        long area = Long.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            long l = hist[i];
            if (next[i] == -1) {
                next[i] = n;
            }
            long b = next[i] - prev[i] - 1;

            long newArea = l * b;
            area = Math.max(area, newArea);
        }
        return area;
    }
        
}



