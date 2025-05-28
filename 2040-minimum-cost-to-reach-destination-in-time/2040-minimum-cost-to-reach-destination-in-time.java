class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        HashMap<Integer , List<int[]>> adj = new HashMap<>();
        for(int i = 0; i < passingFees.length; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            adj.get(edges[i][0]).add(new int[]{edges[i][1] , edges[i][2]});
            adj.get(edges[i][1]).add(new int[]{edges[i][0] , edges[i][2]});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->(x[1] != y[1])?Integer.compare(x[1] , y[1]):Integer.compare(x[2] , y[2]));
        int[][] ans = new int[passingFees.length][maxTime+1];
        for(int i = 0; i < ans.length; i++){
            Arrays.fill(ans[i] , Integer.MAX_VALUE);
        }
        ans[0][0] = passingFees[0];
        pq.offer(new int[]{0 , passingFees[0] , 0});
        while(!pq.isEmpty()){
            int node = pq.peek()[0];
            int cost = pq.peek()[1];
            int time = pq.peek()[2];
            pq.poll();
            if(node == passingFees.length-1)
                return cost;
            for(int i = 0; i < adj.get(node).size(); i++){
                int adjnode = adj.get(node).get(i)[0];
                int nextTime = adj.get(node).get(i)[1];
                int weight = passingFees[adjnode];
                if(time+nextTime <= maxTime && cost+weight < ans[adjnode][time+nextTime]){
                    ans[adjnode][time+nextTime] = cost+weight;
                    pq.offer(new int[]{adjnode , cost+weight , time+nextTime});
                }
            }
        }
        return -1;
    }
}