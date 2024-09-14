//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;


// } Driver Code Ends
// User function template for C++
class Solution {
  public:

    void rearrange(vector<int> &arr) {
        // code here
          vector<int> pos,neg;
        for(auto num : arr)
        {
            if(num<0) neg.push_back(num);
            else pos.push_back(num);
        }
        int n=arr.size();
        arr.clear();
        assert(arr.size()==0);
        int i=0;
        int j=0;
        while(i<pos.size() || j<neg.size())
        {
            if(i<pos.size()) arr.push_back(pos[i]);
            if(j<neg.size())arr.push_back(neg[j]);
            i++;
            j++;
            
        }
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    cin.ignore();
    while (t--) {
        vector<int> arr;
        string input;
        int num;

        getline(cin, input);
        stringstream s2(input);
        while (s2 >> num) {
            arr.push_back(num);
        }
        Solution ob;
        ob.rearrange(arr);
        for (int i = 0; i < arr.size(); i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
    }
    return 0;
}

// } Driver Code Ends