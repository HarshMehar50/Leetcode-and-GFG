//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
     
        // Your code here
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        int mod = 100000;
        q.offer(new int[]{0 , start});
        visited.add(start);
        while(!q.isEmpty()){
            int c = q.peek()[0];
            int n = q.peek()[1];
            q.poll();
            if(n == end)
            return c;
            for(int i = 0; i < arr.length; i++){
                if(!visited.contains((n*arr[i])%mod)){
                    q.offer(new int[]{c+1 , (n*arr[i])%mod});
                    visited.add((n*arr[i])%mod);
                }
            }
        }
        return -1;
    }
}
