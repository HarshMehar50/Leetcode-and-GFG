class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start , arr[start]});
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        while(!q.isEmpty()){
            int index = q.peek()[0];
            int n = q.peek()[1];
            q.poll();
            if(n == 0)
            return true;
            if(index+arr[index] < arr.length && index+arr[index] >= 0 && !visited[index+arr[index]]){
            q.offer(new int[]{index+arr[index] , arr[index+arr[index]]});
            visited[index+arr[index]] = true;
            }
            if(index-arr[index] < arr.length && index-arr[index] >= 0 && !visited[index-arr[index]]){
            q.offer(new int[]{index-arr[index] , arr[index-arr[index]]});
            visited[index-arr[index]] = true;
            }
        }
        return false;
    }
}