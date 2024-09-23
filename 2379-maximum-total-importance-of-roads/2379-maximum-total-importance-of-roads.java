class Solution {
    public long maximumImportance(int n, int[][] roads) {
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i < roads.length; i++){
            adj.get(roads[i][0]).add(roads[i][1]);
            adj.get(roads[i][1]).add(roads[i][0]);
        }
        int[][] details = new int[n][2];
        for(int i = 0; i < n; i++){
            details[i][0] = i;
            details[i][1] = adj.get(i).size();
        }
        Arrays.sort(details , (x , y)->Integer.compare(x[1] , y[1]));
        int[] importance = new int[n];
        for(int i = 0; i < n; i++){
            importance[details[i][0]] = i+1;
        }
        long ans = 0;
        for(int i = 0; i < roads.length; i++){
            ans += importance[roads[i][0]]+importance[roads[i][1]];
        }
        return ans;
    }
}