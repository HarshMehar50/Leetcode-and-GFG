class Solution {
    class TrieNode{
        boolean end;
        TrieNode[] children;
        public TrieNode(){
            end = false;
            children = new TrieNode[2];
            children[0] = null;
            children[1] = null;
        }
    }
    class Trie{
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
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie trie = new Trie();
        Arrays.sort(nums);
        int[][] a = new int[queries.length][3];
        for(int i = 0; i < a.length; i++){
            a[i][0] = queries[i][0];
            a[i][1] = queries[i][1];
            a[i][2] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(x[1] , y[1]));
        int j = 0;
        int[] ans = new int[queries.length];
        Arrays.fill(ans , -1);
        for(int i = 0; i < a.length; i++){
            while(j < nums.length && nums[j] <= a[i][1]){
                trie.insert(nums[j]);
                j++;
            }
            if(j != 0)
            ans[a[i][2]] = trie.search(a[i][0])^a[i][0];
        }
        return ans;
    }
}