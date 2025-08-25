class Solution {
    List<Integer> topoSort(int[]indegree , HashMap<Integer , List<Integer>> adj){
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
            q.offer(i);
        }
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(node);
            for(Integer x : adj.get(node)){
                indegree[x]--;
                if(indegree[x] == 0)
                q.offer(x);
            }
        }
        if(ans.size() == indegree.length)
        return ans;
        else 
        return new ArrayList<>();
    }
    public int[] sortItems(int n, int m, int[] group, List<List<Integer>> beforeItems) {
        int gc = m-1;
        for(int i = 0; i < n; i++){
            if(group[i] == -1){
                gc++;
                group[i] = gc;
            }
        }
        HashMap<Integer , List<Integer>> adj = new HashMap<>();
        HashMap<Integer , List<Integer>> adjgroup = new HashMap<>();
        HashMap<Integer , List<Integer>> map = new HashMap<>();
        int[] indegree = new int[n];
        int[] indegreegroup = new int[gc+1];
        for(int i = 0; i < n; i++){
            adj.put(i , new ArrayList<>());
        }
        for(int i = 0; i <= gc; i++){
            adjgroup.put(i , new ArrayList<>());
            map.put(i , new ArrayList<>());
        }
        for(int i = 0; i < beforeItems.size(); i++){
            for(int j = 0; j < beforeItems.get(i).size(); j++){
                adj.get(beforeItems.get(i).get(j)).add(i);
                indegree[i]++;
                if(group[beforeItems.get(i).get(j)] != group[i]){
                adjgroup.get(group[beforeItems.get(i).get(j)]).add(group[i]);
                indegreegroup[group[i]]++;
                }
            }
        }
        List<Integer> topoNode = topoSort(indegree , adj);
        List<Integer> topoGroup = topoSort(indegreegroup , adjgroup);
        for(Integer x : topoNode){
            map.get(group[x]).add(x);
        }
        List<Integer> ans = new ArrayList<>();
        for(Integer x : topoGroup){
            ans.addAll(map.get(x));
        }
        int[] fans = new int[ans.size()];
        for(int i = 0; i < ans.size(); i++){
            fans[i] = ans.get(i);
        }
        return fans;
    }
}