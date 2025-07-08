// User function Template for Java

class Solution {
    // Function to check if we can reach the last index from the 0th index.
    public boolean canReach(int[] arr) {
        // code here
        /*Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(0);
        visited[0] = true;
        while(!q.isEmpty()){
            int index = q.poll();
            if(index == arr.length-1)
            return true;
            for(int j = 1; j <= arr[index]; j++){
                if(index+j < arr.length && !visited[index+j]){
                    q.offer(index+j);
                    visited[index+j] = true;
                }
                /*if(index-j >= 0 && !visited[index-j]){
                    q.offer(new int[]{index-j , arr[index-j] , d+1});
                    visited[index-j] = true;
                }*/
            /*}
        }
        return false;*/
        int max = 0;
        for(int i = 0; i <= max; i++){
            max = Math.max(max , i+arr[i]);
            if(max >= arr.length-1)
            return true;
        }
        return false;
    }
}