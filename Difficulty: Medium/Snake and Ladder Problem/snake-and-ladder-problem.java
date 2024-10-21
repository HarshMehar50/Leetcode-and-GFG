//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[2*N];
            for(int i = 0;i < 2*N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.minThrow(N, arr));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minThrow(int N, int arr[]){
        // code here
        int[] board = new int[31];
        for(int i = 0; i < arr.length; i=i+2){
            board[arr[i]] = arr[i+1];
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[31];
        q.offer(new int[]{0 , 1 , board[1]});
        visited[1] = true;
        while(!q.isEmpty()){
            int c = q.peek()[0];
            int index = q.peek()[1];
            int n = q.peek()[2];
            q.poll();
            if(index == 30)
            return c;
            /*if(n == 0){
                for(int i = 1; i <= 6; i++){
                    if(index+i < 31 && !visited[index+i]){
                    q.offer(new int[]{c+1 , index+i , board[index+i]});
                    visited[index+i] = true;
                    }
                }
            }else{
                   if(!visited[n]){
                    q.offer(new int[]{c , n , board[n]});
                    visited[n] = true;
            }*/
            for(int i = 1; i <= 6; i++){
                if(index+i <= 30 && !visited[index+i]){
                    int des = board[index+i]!=0?board[index+i]:(index+i);
                    if(!visited[des]){
                        q.offer(new int[]{c+1 , des , board[des]});
                        visited[des] = true;
                    }
                }
            }
        }
        return -1;
    }
}