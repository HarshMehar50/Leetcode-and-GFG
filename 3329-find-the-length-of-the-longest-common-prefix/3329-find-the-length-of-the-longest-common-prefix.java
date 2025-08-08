class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[10];
        int wordCount = 0;
        int prefixCount = 0;
    }
    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - '0';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                node.prefixCount++;
            }
            node.wordCount++;
        }

        public int search(String word) {
            TrieNode node = root;
            int l = 0;
            for (char ch : word.toCharArray()) {
                int idx = ch - '0';
                if (node.children[idx] == null)
                return l;
                node = node.children[idx];
                l++;
            }
            return l;
        }
        
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie trie = new Trie();
        for(int i = 0; i < arr1.length; i++){
            trie.insert(Integer.toString(arr1[i]));
        }
        int ans = 0;
        for(int i = 0; i < arr2.length; i++){
            ans = Math.max(ans , trie.search(Integer.toString(arr2[i])));
        }
        return ans;
    }
}