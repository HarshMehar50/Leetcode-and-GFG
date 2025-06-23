class Solution {
    static int minJumps(int[] arr) {
        // code here
        if(arr[0] == 0)
        return -1;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(new int[]{0 , arr[0] , 0});
        visited[0] = true;
        while(!q.isEmpty()){
            int nodei = q.peek()[0];
            int nodev = q.peek()[1];
            int m = q.peek()[2];
            q.poll();
            if(nodei == arr.length-1)
            return m;
            for(int i = nodei+1; i <= Math.min(nodei+nodev , arr.length-1); i++){
                if(!visited[i]){
                    q.offer(new int[]{i , arr[i] , m+1});
                    visited[i] = true;
                }
            }
        }
        return -1;
    }
}