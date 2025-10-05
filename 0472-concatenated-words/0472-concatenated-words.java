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

        public boolean search(String word , int s , int e) {
            TrieNode node = root;
            for(int i = s; i <= e; i++){
                char ch = word.charAt(i);
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
            if (!search(word , 0 , word.length()-1)) return;
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
    boolean solve(String s , int i){
        if(i >= s.length())
        return true;
        boolean ans = false;
        for(int j = i; j < s.length(); j++){
            if(trie.search(s , i , j))
            ans = ans|solve(s , j+1);
        }
        return ans;
    }
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words , (x , y)->Integer.compare(x.length() , y.length()));
        trie = new Trie();
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(solve(words[i] , 0))
            ans.add(words[i]);
            trie.insert(words[i]);
        }
        return ans;
    }
}