#User function Template for python3

class Solution:
    def solve(self, col, board, n, sol):
        if col == n:
            sol.append(board[:])
        for row in range(1, n + 1):
            if all(board[i] != row and abs(board[i] - row) != col - i for i in range(col)):
                board[col] = row
                self.solve(col + 1, board, n, sol)
    
    def nQueen(self, n):
        sol = []
        self.solve(0, [0] * n, n, sol)
        return sol


#{ 
 # Driver Code Starts
#Initial Template for Python 3

if __name__ == '__main__':
    t = int(input())
    for _ in range(t):
        n = int(input())
        
        ob = Solution()
        ans = ob.nQueen(n)
        if(len(ans) == 0):
            print("-1")
        else:
            for i in range(len(ans)):
                print("[",end="")
                for j in range(len(ans[i])):
                    print(ans[i][j],end = " ")
                print("]",end = " ")
            print()
                
# } Driver Code Ends