class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < supplies.length; i++){
            set.add(supplies[i]);
        }
        HashMap<String , List<Integer>> adj = new HashMap<>();
        for(List<String> l : ingredients){
            for(String s : l){
                if(!set.contains(s))
                adj.put(s , new ArrayList<>());
            }
        }
        int[] indegree = new int[recipes.length];
        for(int i = 0; i < ingredients.size(); i++){
            for(String s : ingredients.get(i)){
                if(!set.contains(s) && adj.containsKey(s)){
                    adj.get(s).add(i);
                    indegree[i]++;
                }
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0)
            q.offer(i);
        }
        List<String> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            ans.add(recipes[node]);
            if(adj.containsKey(recipes[node])){
                for(Integer x : adj.get(recipes[node])){
                    indegree[x]--;
                    if(indegree[x] == 0)
                    q.offer(x);
                }
            }
        }
        return ans;
    }
}