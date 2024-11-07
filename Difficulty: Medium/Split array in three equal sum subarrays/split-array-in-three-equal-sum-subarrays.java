//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine().trim());

        while (testCases-- > 0) {
            String[] str = br.readLine().trim().split(" ");
            int[] arr = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                arr[i] = Integer.parseInt(str[i]);
            }

            Solution ob = new Solution();
            List<Integer> result = ob.findSplit(arr);

            if (result.get(0) == -1 && result.get(1) == -1) {
                System.out.println("false");
            } else {
                System.out.println("true");
            }
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to determine if array arr can be split into three equal sum sets.
    public List<Integer> findSplit(int[] arr) {
        // code here
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        if (totalSum % 3 != 0) {
            return Arrays.asList(-1, -1);
        }
        int targetSum = totalSum / 3;
        int n = arr.length;
        int currentSum = 0;
        int firstIndex = -1, secondIndex = -1;
        int partsFound = 0;
        for (int k = 0; k < n; k++) {
            currentSum += arr[k];
            if (currentSum == targetSum) {
                partsFound++;
                if (partsFound == 1) {
                    firstIndex = k; 
                } else if (partsFound == 2) {
                    secondIndex = k; 
                    break;
                }
                currentSum = 0;
            }
        }
        if (partsFound == 2 && secondIndex != -1) {
            return Arrays.asList(firstIndex, secondIndex + 1);
        }
        return Arrays.asList(-1, -1);
    }
}