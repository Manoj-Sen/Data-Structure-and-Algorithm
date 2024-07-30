//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> ans = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        int n = mat.length;

        dfs(mat, 0, 0, new ArrayList<>(), ans, visited, n);

        if (ans.isEmpty()) {
            ans.add("-1");
        }
        return ans;
        
    }
    private void dfs(int[][] mat, int r, int c, List<Character> dirs, ArrayList<String> ans, Set<String> visited, int n) {
        if (r < 0 || r >= n || c < 0 || c >= n || mat[r][c] == 0 || visited.contains(r + "," + c)) {
            return;
        }

        if (r == n - 1 && c == n - 1) {
            StringBuilder path = new StringBuilder();
            for (char dir : dirs) {
                path.append(dir);
            }
            ans.add(path.toString());
            return;
        }

        visited.add(r + "," + c);
        char[] directions = {'U', 'D', 'L', 'R'};
        int[] rowChanges = {-1, 1, 0, 0};
        int[] colChanges = {0, 0, -1, 1};

        for (int i = 0; i < directions.length; i++) {
            dirs.add(directions[i]);
            dfs(mat, r + rowChanges[i], c + colChanges[i], dirs, ans, visited, n);
            dirs.remove(dirs.size() - 1);
        }

        visited.remove(r + "," + c);
    }
}