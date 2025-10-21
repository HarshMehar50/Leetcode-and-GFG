class Solution {
    class TrieNode{
        TrieNode[] children;
        int count;
        public TrieNode(){
            count = 0;
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
                c.count++;
            }
        }
        /*int solve(int x , int high , TrieNode node , int bp){
            if(node == null)
            return 1;
            int bvh = 0;
            if((high&(1<<bp)) != 0)
            bvh = 1;
            int bvx = 0;
            if((x&(1<<bp)) != 0)
            bvx = 1;
            int ans = 0;
            if(bvh == 0)
            ans = solve(x , high , node.children[bvx] , bp--);
            else
            ans = solve(x , high , node.children[0] , bp--)+solve(x , high , node.children[1] , bp--);
            return ans;
        }*/
        int count(int x , int high){
            if(high < 0)
            return 0;
            TrieNode node = root;
            //return solve(x , high , node , 31);
            int ans = 0;
            for(int i = 31; i >= 0; i--){
                if(node == null)
                break;
                int bvh = 0;
                if((high&(1<<i)) != 0)
                bvh = 1;
                int bvx = 0;
                if((x&(1<<i)) != 0)
                bvx = 1;
                if(bvh == 1){
                    if(node.children[bvx] != null)
                    ans += node.children[bvx].count;
                    node = node.children[1-bvx];
                }else
                node = node.children[bvx];
            }
            return ans;
        }
    }
    public int countPairs(int[] nums, int low, int high) {
        Trie trie = new Trie();
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            ans += trie.count(nums[i] , high+1)-trie.count(nums[i] , low);
            trie.insert(nums[i]);
        }
        return ans;
    }
}