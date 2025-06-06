class Solution {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        boolean[] vis = new boolean[n];
        for (int i = 0; i < restricted.length; i++) {
            vis[restricted[i]] = true;
        }
        if (vis[0] == true)
            return 0;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        vis[0] = true;
        q.offer(0);
        while (!q.isEmpty()) {
            int node = q.poll();
            count++;
            for (Integer it : adj.get(node)) {
                if (!vis[it]) {
                    vis[it] = true;
                    q.offer(it);
                }
            }
        }
        return count;
    }
}