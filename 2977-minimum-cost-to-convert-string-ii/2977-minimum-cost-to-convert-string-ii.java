class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordCount = 0;
        int prefixCount = 0;
        int index = -1;
    }
    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word , int i) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.prefixCount++;
            }
            node.wordCount++;
            node.index = i;
        }

        public int search(String word , int s , int e) {
            TrieNode node = root;
            for (int i = s; i <= e; i++) {
                int idx = word.charAt(i) - 'a';
                if (node.children[idx] == null) return -1;
                node = node.children[idx];
            }
            if(node.wordCount > 0)
            return node.index;
            else
            return -1;
        }
    }
    Trie trie;
    /*long solve(String source , String target , long[][] d , int i , long[] dp){
        if(i == source.length())
        return 0;
        if(dp[i] != -1)
        return dp[i];
        long ans = (long)(1e15);
        if(source.charAt(i) == target.charAt(i))
        ans = Math.min(ans , solve(source , target , d , i+1 , dp));
        for(int j = i; j < source.length(); j++){
            int ids = trie.search(source , i , j);
            int idt = trie.search(target , i , j);
            if(ids != -1 && idt != -1)
            ans = Math.min(ans , d[ids][idt]+solve(source , target , d , j+1 , dp));
        }
        dp[i] = ans;
        return dp[i];
    }*/
    long solve(String source, String target, long[][] d, int i, long[] dp) {
    if (i == source.length()) return 0;
    if (dp[i] != -1) return dp[i];

    long ans = (long) 1e15;

    // Case 1: no cost if characters already match
    if (source.charAt(i) == target.charAt(i)) {
        ans = Math.min(ans, solve(source, target, d, i + 1, dp));
    }

    TrieNode nodeS = trie.root;
    TrieNode nodeT = trie.root;

    for (int j = i; j < source.length(); j++) {
        int cs = source.charAt(j) - 'a';
        int ct = target.charAt(j) - 'a';

        if (nodeS.children[cs] == null || nodeT.children[ct] == null)
            break;

        nodeS = nodeS.children[cs];
        nodeT = nodeT.children[ct];

        if (nodeS.wordCount > 0 && nodeT.wordCount > 0) {
            int ids = nodeS.index;
            int idt = nodeT.index;
            ans = Math.min(ans, d[ids][idt] + solve(source, target, d, j + 1, dp));
        }
    }

    return dp[i] = ans;
}
    public long minimumCost(String source, String target, String[] original, String[] changed, int[] cost) {
        HashMap<String , Integer> id = new HashMap<>();
        int ids = 0;
        int[] ai = new int[original.length];
        int[] af = new int[changed.length];
        for(int i = 0; i < ai.length; i++){
            if(!id.containsKey(original[i])){
                id.put(original[i] , ids);
                ai[i] = ids;
                ids++;
            }else
            ai[i] = id.get(original[i]);
        }
        for(int i = 0; i < af.length; i++){
            if(!id.containsKey(changed[i])){
                id.put(changed[i] , ids);
                af[i] = ids;
                ids++;
            }else
            af[i] = id.get(changed[i]);
        }
        long[][] d = new long[ids][ids];
        for(long[] a : d){
            Arrays.fill(a , (long)(1e15));
        }
        for(int i = 0; i < ids; i++){
            d[i][i] = 0;
        }
        for(int i = 0; i < ai.length; i++){
            d[ai[i]][af[i]] = Math.min(d[ai[i]][af[i]] , cost[i]);
        }
        for(int k = 0; k < ids; k++){
            for(int i = 0; i < ids; i++){
                if(d[i][k] != (long)(1e15)){
                    for(int j = 0; j < ids; j++){
                        if(d[k][j] != (long)(1e15))
                        d[i][j] = Math.min(d[i][j] , d[i][k]+d[k][j]);
                    }
                }
            }
        }
        trie = new Trie();
        for(String s : id.keySet()){
            trie.insert(s , id.get(s));
        }
        long[] dp = new long[source.length()];
        Arrays.fill(dp , -1);
        long ans = solve(source , target , d , 0 , dp);
        if(ans == (long)(1e15))
        return -1;
        return ans;
    }
}