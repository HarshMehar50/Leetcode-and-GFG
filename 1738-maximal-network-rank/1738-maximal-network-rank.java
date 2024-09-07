class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        int[] indegree = new int[n];
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
            indegree[roads[i][0]]++;
            indegree[roads[i][1]]++;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < indegree.length-1; i++){
            for(int j = i+1; j < indegree.length; j++){
                if(adj.get(i).contains(j))
                ans = Math.max(indegree[i]+indegree[j]-1 , ans);
                else
                ans = Math.max(indegree[i]+indegree[j] , ans);
            }
        }
        return ans;
    }
}