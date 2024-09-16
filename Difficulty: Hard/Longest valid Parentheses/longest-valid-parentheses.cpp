//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
    int maxLength(string s) {
        // code here
        int sum = 0;
        map<int, int> mp;
        mp[0] = 0;
        int prev = 0, big = 0;
        
        for(int i = 0; i<s.length(); i++)
        {
            if(s[i] == '(')
                sum++;
            else
                sum--;
            if(sum < 0)
            {
                sum = 0;
                prev = i+1;
                mp[0] = i+1;
                continue;
            }
            
            if(s[i] == ')' && mp.find(sum) != mp.end())
            {
                if(mp[sum] >= prev)
                    big = max(big, i+1 - mp[sum]);
                else
                    mp[sum] = i+1;
            }
            else
                mp[sum] = i+1;
        }
        return big;
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        cin >> S;

        Solution ob;
        cout << ob.maxLength(S) << "\n";
    }
    return 0;
}
// } Driver Code Ends