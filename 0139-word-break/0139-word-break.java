class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordCount = 0;
        int prefixCount = 0;
    }
    class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
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
        }

        public boolean search(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return node.wordCount > 0;
        }

        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return true;
        }

        public int countWordsEqualTo(String word) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return 0;
                node = node.children[idx];
            }
            return node.wordCount;
        }

        public int countWordsStartingWith(String prefix) {
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return 0;
                node = node.children[idx];
            }
            return node.prefixCount;
        }

        public void erase(String word) {
            if (!search(word)) return;
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                TrieNode child = node.children[idx];
                child.prefixCount--;
                node = child;
            }
            node.wordCount--;
        }
    }

    Trie trie;
    boolean solve(String s , int i , HashMap<Integer , Boolean> dp){
        if(i >= s.length())
        return true;
        if(dp.containsKey(i))
        return dp.get(i);
        for(int j = i; j < s.length(); j++){
            if(trie.search(s.substring(i , j+1))&&solve(s , j+1 , dp)){
                dp.put(i , true);
                return dp.get(i);
            }
        }
        dp.put(i , false);
        return dp.get(i);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        trie = new Trie();
        for(int i = 0; i < wordDict.size(); i++){
            trie.insert(wordDict.get(i));
        }
        HashMap<Integer , Boolean> dp = new HashMap<>();
        return solve(s , 0 , dp);
    }
}