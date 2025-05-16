class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        //Set<Integer> set = new HashSet<>();
        Queue<List<Integer>> q = new LinkedList<>();
        visited[0] = true;
        q.offer(rooms.get(0));
        while(!q.isEmpty()){
            List<Integer> node = q.peek();
            q.poll();
            for(int i = 0; i < node.size(); i++){
                if(!visited[node.get(i)]){
                    q.offer(rooms.get(node.get(i)));
                    visited[node.get(i)] = true;
                }
            }
        }
        int c = 0;
        for(int i = 0; i < visited.length; i++){
            if(visited[i])
                c++;
        }
        if(c == rooms.size())
            return true;
        else
            return false;
    }
}