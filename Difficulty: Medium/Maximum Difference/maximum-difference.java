//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] leftMin(int[] arr, int n)
    {
        int result[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++)
        {
            int num = arr[i];
            while(st.size() > 0 && num <= st.peek())
            {
                st.pop();
            }
            
            if(st.size() == 0)
            {
                result[i] = 0;
            }
            else
            {
                result[i] = st.peek();
            }
            st.push(num);
        }
        return result;
    }
    
    public int[] rightMin(int[] arr, int n)
    {
        int result[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--)
        {
            int num = arr[i];
            while(st.size() > 0 && num <= st.peek())
            {
                st.pop();
            }
            
            if(st.size() == 0)
            {
                result[i] = 0;
            }
            else
            {
                result[i] = st.peek();
            }
            st.push(num);
        }
        return result;
    }
    public int findMaxDiff(int[] arr) {
        int n = arr.length;
        int left[] = leftMin(arr, n);
        int[] right = rightMin(arr, n);
        
        int max = 0;
        for(int i=0; i<n; i++)
        {
            int curr_max = Math.abs(left[i] - right[i]);
            max = Math.max(curr_max, max);
        }
        return max;
    }
}
