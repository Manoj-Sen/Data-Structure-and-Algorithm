//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = Integer.parseInt(sc.next());
		while(t-- > 0)
		{
		    int n = Integer.parseInt(sc.next());
		    int k = Integer.parseInt(sc.next());
		    
		    String[] words = new String[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        words[i] = sc.next();
		    }
		    
		    Solution ob = new Solution();
		  //  System.out.println(T.findOrder(words,k));
		    String order = ob.findOrder(words,n,k);
		    if(order.length() == 0){
		        System.out.println(0);
		        continue;
		    }
		    if(order.length() != k){
		        System.out.println("INCOMPLETE");
		        return;
		    }
		    String temp[] = new String[n];
		    for(int i=0;i<n;i++)
		        temp[i] = words[i];
		    
		    Arrays.sort(temp, new Comparator<String>(){
		    
		      @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for(int i = 0; i < Math.min(a.length(), b.length()) 
                                        && index1 == index2; i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }
                
                    if(index1 == index2 && a.length() != b.length()) 
                    {
                        if(a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }
                
                    if(index1 < index2)
                        return -1;
                    else
                        return 1;
                        
                }
		    });
		    
		    int flag = 1;
		    for(int i=0;i<n;i++)
		    {
		        if(!words[i].equals(temp[i]))
	            {
	                flag = 0;
	                break;
	            }
		    }
		    
		    System.out.println(flag);
		}
	}
	
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String findOrder(String [] dict, int n, int k)
    {
        Map<Integer,ArrayList<Integer>> map = new HashMap<>();
		for(int i=0;i<k;i++) {
			map.put(i, new ArrayList<>());
		}
		for(int i=0;i<dict.length-1;i++) {
			String s1 = dict[i];
			String s2 = dict[i+1];
			int ps1 = 0;
			int ps2 = 0;
			while(ps1<s1.length() && ps2<s2.length()) {
				if(s1.charAt(ps1)!=s2.charAt(ps2)) {
					if(!map.containsKey(s1.charAt(ps1)-'a')) {
						map.get(s1.charAt(ps1)-'a').add(s2.charAt(ps2)-'a');
					}else {
						map.get(s1.charAt(ps1)-'a').add(s2.charAt(ps2)-'a');
					}
					break;
				}else {
					ps1++;
					ps2++;
				}
			}
		}
		
		//Topological sort
		int indeg[] = new int[k];
		Queue<Integer> q = new LinkedList<>();
		for(int i=0;i<map.size();i++) {
			for(Integer it : map.get(i)) {
				indeg[it]++;
			}
		}
		
		for(int i=0;i<indeg.length;i++) {
			if(indeg[i]==0) {
				q.add(i);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		while(!q.isEmpty()) {
			int val = q.poll();
			ans.add(val);
			for(Integer it : map.get(val)) {
				indeg[it]--;
				if(indeg[it]==0) {
					q.add(it);
				}
			}
			
		}
        
        //convert integer to char value
		String currAns = "";
		for(int i=0;i<ans.size();i++) {
			currAns +=  (char) (ans.get(i)+'a'); //integer to character
		}

		return currAns;
	}
}