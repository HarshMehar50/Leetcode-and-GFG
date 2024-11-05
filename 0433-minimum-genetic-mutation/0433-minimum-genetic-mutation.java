class Solution {
    class Node{
        int c;
        String s;
        public Node(int c , String s){
            this.c = c;
            this.s = s;
        }
    }
    public int minMutation(String startGene, String endGene, String[] bank) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0 , startGene));
        List<String> visited = new ArrayList<>();
        visited.add(startGene);
        while(!q.isEmpty()){
            int count = q.peek().c;
            String g = q.peek().s;
            q.poll();
            if(g.equals(endGene))
            return count;
            for(int i = 0; i < bank.length; i++){
                if(!visited.contains(bank[i])){
                int d = 0;
                for(int j = 0; j < bank[i].length(); j++){
                    if(g.charAt(j) != bank[i].charAt(j))
                    d++;
                }
                if(d == 1){
                    q.offer(new Node(count+1 , bank[i]));
                    visited.add(bank[i]);
                }
                }
            }
        }
        return -1;
    }
}