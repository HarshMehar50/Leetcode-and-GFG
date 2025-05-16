class Solution {
    class edges{
        int node;
        char edgeColour;
        public edges(int node , char edgeColour){
            this.node = node;
            this.edgeColour = edgeColour;
        }
    }
    class details{
        int node;
        char edgeColour;
        int distance;
        public details(int node , char edgeColour , int distance){
            this.node = node;
            this.edgeColour = edgeColour;
            this.distance = distance;
        }
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        HashMap<Integer , List<edges>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < redEdges.length; i++){
            adj.get(redEdges[i][0]).add(new edges(redEdges[i][1] , 'R'));
        }
        for(int i = 0; i < blueEdges.length; i++){
            adj.get(blueEdges[i][0]).add(new edges(blueEdges[i][1] , 'B'));
        }
        int[] d = new int[n];
        Arrays.fill(d , (int)(1e9));
        d[0] = 0;
        boolean[][] visited = new boolean[n][2];
        Queue<details> q = new LinkedList<>();
        q.offer(new details(0 , 'N' , 0));
        while(!q.isEmpty()){
            int node = q.peek().node;
            char color = q.peek().edgeColour;
            int distance = q.peek().distance;
            q.poll();
            for(int i = 0; i < adj.get(node).size(); i++){
                int adjnode = adj.get(node).get(i).node;
                char ecolor = adj.get(node).get(i).edgeColour;
                if(ecolor != color || color == 'N'){
                    int colorindex = (ecolor == 'R')?0:1;
                    if(!visited[adjnode][colorindex]){
                        visited[adjnode][colorindex] = true;
                        d[adjnode] = Math.min(distance+1 , d[adjnode]);
                        q.offer(new details(adjnode , ecolor , distance+1));
                    }
                }
            }
        }
        for(int i = 0; i < n; i++){
            if(d[i] == (int)(1e9))
                d[i] = -1;
        }
        return d;
    }
}