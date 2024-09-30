//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.math.*;
import java.util.*;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = Integer.parseInt(sc.next());
        while (t-- > 0) {
            int n = Integer.parseInt(sc.next());
            int k = Integer.parseInt(sc.next());

            String[] words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = sc.next();
            }

            Solution ob = new Solution();
            //  System.out.println(T.findOrder(words,k));
            String order = ob.findOrder(words, n, k);
            if (order.length() == 0) {
                System.out.println(0);
                continue;
            }
            if (order.length() != k) {
                System.out.println("INCOMPLETE");
                return;
            }
            String temp[] = new String[n];
            for (int i = 0; i < n; i++) temp[i] = words[i];

            Arrays.sort(temp, new Comparator<String>() {
                @Override
                public int compare(String a, String b) {
                    int index1 = 0;
                    int index2 = 0;
                    for (int i = 0;
                         i < Math.min(a.length(), b.length()) && index1 == index2;
                         i++) {
                        index1 = order.indexOf(a.charAt(i));
                        index2 = order.indexOf(b.charAt(i));
                    }

                    if (index1 == index2 && a.length() != b.length()) {
                        if (a.length() < b.length())
                            return -1;
                        else
                            return 1;
                    }

                    if (index1 < index2)
                        return -1;
                    else
                        return 1;
                }
            });

            int flag = 1;
            for (int i = 0; i < n; i++) {
                if (!words[i].equals(temp[i])) {
                    flag = 0;
                    break;
                }
            }

            System.out.println(flag);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void topoDFS(int node , HashMap<Integer , List<Integer>> adj , boolean[] visited , Stack<Integer> s){
        visited[node] = true;
        for(Integer x : adj.get(node)){
            if(!visited[x]){
                topoDFS(x , adj , visited , s);
            }
        }
        s.push(node);
    }
    List<Integer> topoSort(HashMap<Integer , List<Integer>> adj , int k){
        List<Integer> topoList = new ArrayList<>();
        boolean[] visited = new boolean[k];
        Arrays.fill(visited , false);
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < k; i++){
            if(!visited[i]){
                topoDFS(i , adj , visited , s);
            }
        }
        while(!s.isEmpty()){
            int e = s.pop();
            topoList.add(e);
        }
        return topoList;
    }
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < k; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < dict.length-1; i++){
            for(int j = 0; j < Math.min(dict[i].length() , dict[i+1].length()); j++){
                if(dict[i].charAt(j) != dict[i+1].charAt(j)){
                    adj.get(dict[i].charAt(j)-'a').add(dict[i+1].charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(adj , k);
        String ans = "";
        for(int i = 0; i < topo.size(); i++){
            ans += (char)(topo.get(i)+'a');
        }
        return ans;
    }
}