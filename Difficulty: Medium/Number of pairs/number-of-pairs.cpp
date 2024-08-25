//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution {
  public:
    long long countPairs(vector<int> &arr, vector<int> &brr) {
        int n = arr.size(), m = brr.size();
        vector<double> a, b;
        for(auto it: arr) {
            a.push_back(log(it) / (it * 1.0));
        }
        for(auto it: brr) {
            b.push_back(log(it) / (it * 1.0));
        }
        
        sort(a.begin(), a.end());
        sort(b.begin(), b.end());
        
        long long res = 0;
        for(int i = 0, j = 0; i < n; i++) {
            while(j < m && b[j] < a[i]) j++;
            res += j;
        }
        
        return res;
    }
};

//{ Driver Code Starts.

int main() {
    int T;
    cin >> T;
    cin.ignore();
    while (T--) {
        vector<int> ex;
        vector<int> a, b;
        string input;
        getline(cin, input);
        stringstream ss(input);
        int num;
        while (ss >> num)
            ex.push_back(num);
        a = ex;
        getline(cin, input);
        ss.clear();
        ss.str(input);
        int num2;
        while (ss >> num2)
            b.push_back(num2);

        Solution ob;
        cout << ob.countPairs(a, b) << endl;
    }
}
// } Driver Code Ends