class Solution {
    public int minCostConnectPoints(int[][] points) {
        int startx = points[0][0];
        int starty = points[0][1];
        int[] parent = new int[points.length];
        boolean[] mst = new boolean[points.length];
        int[] key = new int[points.length];
        Arrays.fill(parent , -1);
        Arrays.fill(key , Integer.MAX_VALUE);
        key[0] = 0;
        for(int i = 0; i < points.length; i++){
            int min = Integer.MAX_VALUE;
            int u = 0;
            for(int v = 0; v < points.length; v++){
                if(mst[v] == false && key[v] < min){
                    u = v;
                    min = key[v];
                }
            }
            mst[u] = true;
            for(int j = 0; j < points.length; j++){
                int v = j;
                int w = Math.abs(points[u][0]-points[v][0])+Math.abs(points[u][1]-points[v][1]);
                if(mst[v] == false && w < key[v]){
                    parent[v] = u;
                    key[v] = w;
                }
            }
        }
        int s = 0;
        for(int i = 0; i < key.length; i++){
            s += key[i];
        }
        return s;
    }
}