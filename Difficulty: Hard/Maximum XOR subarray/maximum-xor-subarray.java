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
            int maxxor = 0;
            for(int i = 31; i >= 0; i--){
                int bv = (n>>i)&1;
                int rbv = bv^1;
                if(c.children[rbv] != null){
                    if(rbv == 1)
                    maxxor = maxxor|(1<<i);
                    c = c.children[rbv];
                }else{
                    if(bv == 1)
                    maxxor = maxxor|(1<<i);
                    c = c.children[bv];
                }
            }
            return maxxor;
        }
    }
    static int maxSubarrayXOR(int N, int arr[]) {
        // code here
        int[] pxor = new int[N];
        pxor[0] = arr[0];
        for(int i = 1; i < N; i++){
            pxor[i] = pxor[i-1]^arr[i];
        }
        int ans = 0;
        Trie trie = new Trie();
        for(int i = 0; i < N; i++){
            trie.insert(pxor[i]);
        }
        for(int i = 0; i < N; i++){
            ans = Math.max(ans , trie.search(pxor[i])^pxor[i]);
        }
        for(int i = 0; i < N; i++){
            ans = Math.max(ans , pxor[i]);
        }
        return ans;
    }
}