class Solution {
    class TrieNode{
        boolean end;
        TrieNode[] children;
        int count;
        public TrieNode(){
            end = false;
            children = new TrieNode[2];
            children[0] = null;
            children[1] = null;
            count = 0;
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
            c.end = true;
        }
        public void delete(int num) {
            deleteHelper(root, num, 31);
        }

    private boolean deleteHelper(TrieNode node, int num, int bitPos) {
        if (node == null)
            return false;

        if (bitPos < 0) {
            node.count--;
            return node.count == 0;
        }

        int bit = (num >> bitPos) & 1;
        boolean shouldDeleteChild = deleteHelper(node.children[bit], num, bitPos - 1);

        if (shouldDeleteChild) {
            node.children[bit] = null;
        }

        node.count--;
        return node.count == 0 && node.children[0] == null && node.children[1] == null;
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
    public int maximumStrongPairXor(int[] nums) {
        Arrays.sort(nums);
        /*int ans = 0;
        for(int i = 0; i < nums.length; i++){
            Trie trie = new Trie();
            int j = i;
            while(j < nums.length && nums[j] <= 2*nums[i]){
                trie.insert(nums[j]);
                j++;
            }
            ans = Math.max(ans , trie.search(nums[i])^nums[i]);
        }
        return ans;*/
        Trie trie = new Trie();
        int ans = 0;
        trie.insert(nums[nums.length-1]);
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((x , y)->Integer.compare(y[0] , x[0]));
        pq.offer(new int[]{nums[nums.length-1] , nums.length-1});
        for(int i = nums.length-2; i >= 0; i--){
            trie.insert(nums[i]);
            pq.offer(new int[]{nums[i] , i});
            while(!pq.isEmpty() && pq.peek()[0] > 2*nums[i]){
                int t = pq.peek()[0];
                pq.poll();
                trie.delete(t);
            }
            ans = Math.max(ans , trie.search(nums[i])^nums[i]);
        }
        return ans;
    }
}