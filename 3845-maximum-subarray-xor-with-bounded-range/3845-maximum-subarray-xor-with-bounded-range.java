class Solution {
    /*TreeMap<Integer , Integer> f = new TreeMap<>();
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            while(l <= r && f.lastKey()-f.firstKey() > k){
                f.put(nums[l] , f.get(nums[l])-1);
                trie.remove(pxor[l]);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                l++;
            }
            ans = Math.max(ans , trie.max(pxor[r+1]));
            trie.insert(pxor[r+1]);
        }*/
    class TrieNode{
        TrieNode[] child = new TrieNode[2];
        int count = 0;
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        void insert(int n){
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                int bit = ((n>>i)&1);
                if(node.child[bit] == null)
                    node.child[bit] = new TrieNode();
                node = node.child[bit];
                node.count++;
            }
        }
        void remove(int n){
            TrieNode node = root;
            for(int i = 31; i >= 0; i--){
                int bit = ((n>>i)&1);
                node.child[bit].count--;
                node = node.child[bit];
            }
        }
        int max(int n){
            TrieNode node = root;
            int ans = 0;
            for(int i = 31; i >= 0; i--){
                int bit = ((n>>i)&1);
                int flip = 1-bit;
                /*if(node.child[flip] != null){
                    if(node.child[flip].count > 0){
                        ans = ans|(1<<i);
                        node = node.child[flip];
                    }else
                    node = node.child[bit];
                }*/
                if(node.child[flip] != null && node.child[flip].count > 0){
                    ans |= (1<<i);
                    node = node.child[flip];
                }else
                node = node.child[bit];
            }
            return ans;
        }
    }
    public int maxXor(int[] nums, int k) {
        int[] pxor = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            pxor[i+1] = pxor[i]^nums[i];
        }
        Trie trie = new Trie();
        int ans = 0;
        int l = 0;
        trie.insert(pxor[0]);
        
        /*Deque<Integer> mindq = new ArrayDeque<>();
        Deque<Integer> maxdq = new ArrayDeque<>();
        for(int r = 0; r < nums.length; r++){
            while(!mindq.isEmpty() && nums[mindq.peekLast()] >= nums[r]){
                mindq.pollLast();
            }
            while(!maxdq.isEmpty() && nums[maxdq.peekLast()] <= nums[r]){
                maxdq.pollLast();
            }
            mindq.offerLast(r);
            maxdq.offerLast(r);
            while(!mindq.isEmpty() && !maxdq.isEmpty() && nums[maxdq.peekFirst()]-nums[mindq.peekFirst()] > k){
                trie.remove(pxor[l]);
                if(mindq.peekFirst() == l)
                mindq.pollFirst();
                if(maxdq.peekFirst() == l)
                maxdq.pollFirst();
                l++;
            }
            ans = Math.max(ans , trie.max(pxor[r+1]));
            trie.insert(pxor[r+1]);
        }*/
        TreeMap<Integer , Integer> f = new TreeMap<>();
        for(int r = 0; r < nums.length; r++){
            f.put(nums[r] , f.getOrDefault(nums[r] , 0)+1);
            while(l <= r && f.lastKey()-f.firstKey() > k){
                f.put(nums[l] , f.get(nums[l])-1);
                trie.remove(pxor[l]);
                if(f.get(nums[l]) == 0)
                f.remove(nums[l]);
                l++;
            }
            ans = Math.max(ans , trie.max(pxor[r+1]));
            trie.insert(pxor[r+1]);
        }
        return ans;
    }
}