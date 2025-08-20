class Solution {
    public int minJumps(int[] arr) {
        if(arr.length == 1)
        return 0;
        if(arr[0] == arr[arr.length-1] && arr.length != 1)
        return 1;
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            adj.put(arr[i] , new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i++){
            adj.get(arr[i]).add(i);
        }
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        q.offer(new int[]{0 , arr[0] , 0});
        visited[0] = true;
        while(!q.isEmpty()){
            int index = q.peek()[0];
            int n = q.peek()[1];
            int c = q.peek()[2];
            q.poll();
            if(index == arr.length-1)
            return c;
            if(index+1 < arr.length && !visited[index+1]){
                q.offer(new int[]{index+1 , arr[index+1] , c+1});
                visited[index+1] = true;
            }
            if(index-1 >= 0 && !visited[index-1]){
                q.offer(new int[]{index-1 , arr[index-1] , c+1});
                visited[index-1] = true;
            }
            for(int i = 0; i < adj.get(n).size(); i++){
                if(adj.get(n).get(i) != index && !visited[adj.get(n).get(i)]){
                        q.offer(new int[]{adj.get(n).get(i) , arr[adj.get(n).get(i)] , c+1});
                        visited[adj.get(n).get(i)] = true;
                }
            }
           /* if(index != adj.get(n).get(adj.get(n).size()-1) && !visited[adj.get(n).get(adj.get(n).size()-1)]){
                q.offer(new int[]{adj.get(n).get(adj.get(n).size()-1) , arr[adj.get(n).get(adj.get(n).size()-1)] , c+1});
                visited[adj.get(n).get(adj.get(n).size()-1)] = true;
            }*/
            adj.get(n).clear();
        }
        return -1;
    }
}