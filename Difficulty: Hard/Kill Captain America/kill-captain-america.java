class Solution {

    static final int MAXN = 40000;
    List<List<Integer>> graph = new ArrayList<>();
    List<List<Integer>> graphT = new ArrayList<>();
    List<Integer> sol = new ArrayList<>();
    boolean[] visited;
    int[] conne;
    int[] in;

    void dfs1(int s) {
        visited[s] = true;
        for (int next : graph.get(s)) {
            if (!visited[next]) {
                dfs1(next);
            }
        }
        sol.add(s);
    }

    void dfs2(int s, int c) {
        visited[s] = false;
        conne[s] = c;
        for (int next : graphT.get(s)) {
            if (visited[next]) {
                dfs2(next, c);
            }
        }
    }

    public int captainAmerica(int n, int[][] gates) {
        sol.clear();
        graph.clear();
        graphT.clear();

        for (int i = 0; i <= MAXN; i++) {
            graph.add(new ArrayList<>());
            graphT.add(new ArrayList<>());
        }

        visited = new boolean[MAXN + 1];
        conne = new int[MAXN + 1];
        in = new int[MAXN + 1];

        // Build graph and transpose
        for (int[] edge : gates) {
            int u = edge[0];
            int v = edge[1];
            graph.get(v).add(u);
            graphT.get(u).add(v);
        }

        // First DFS to fill order
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs1(i);
            }
        }

        // Second DFS to assign components
        int compon = 0;
        for (int i = sol.size() - 1; i >= 0; i--) {
            int node = sol.get(i);
            if (visited[node]) {
                dfs2(node, compon++);
            }
        }

        // Count in-degrees of components
        for (int i = 1; i <= n; i++) {
            for (int next : graph.get(i)) {
                if (conne[i] != conne[next]) {
                    in[conne[next]]++;
                }
            }
        }

        int sources = 0;
        for (int i = 0; i < compon; i++) {
            if (in[i] == 0) {
                sources++;
            }
        }

        if (sources > 1) {
            return 0;
        } else {
            int result = 0;
            for (int i = 1; i <= n; i++) {
                if (in[conne[i]] == 0) {
                    result++;
                }
            }
            return result;
        }
    }
}