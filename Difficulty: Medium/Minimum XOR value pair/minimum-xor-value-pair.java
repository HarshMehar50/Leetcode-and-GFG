class Solution {
    static class TrieNode{
        boolean end;
        TrieNode[] children;
        public TrieNode(){
            end = false;
            children = new TrieNode[2];
            children[0] = null;
            children[1] = null;
        }
    }
    static class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        void insert(int n){
            TrieNode c = root;
            for(int i = 31; i >= 0; i--){
                int bv = (n>>i)&1;
                if(c.children[bv] == null)
                c.children[bv] = new TrieNode();
                c = c.children[bv];
            }
            c.end = true;
        }
        int search(int n){
            TrieNode c = root;
            int minxor = 0;
            for(int i = 31; i >= 0; i--){
                int bv = 0;
                if((n&(1<<i)) != 0)
                bv = 1;
                int rbv = bv;
                int frbv = rbv^1;
                if(c.children[rbv] != null){
                    /*if(rbv == 1)
                    minxor = minxor|(1<<i);*/
                    c = c.children[rbv];
                }else{
                    //if(frbv == 1)
                    minxor = minxor|(1<<i);
                    c = c.children[frbv];
                }
            }
            return minxor;
        }
    }
    static int minxorpair(int N, int arr[]) {
        // code here
        int ans = Integer.MAX_VALUE;
        Trie trie = new Trie();
        /*for(int i = 0; i < N; i++){
            trie.insert(arr[i]);
        }*/
        trie.insert(arr[0]);
        for(int i = 1; i < N; i++){
            ans = Math.min(ans , trie.search(arr[i]));
            trie.insert(arr[i]);
        }
        return ans;
    }
}