class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordCount = 0;
        int prefixCount = 0;
        String s = null;
        int si = 0;
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
                if(node.s == null || node.s.length() > word.length()){
                    node.s = word;
                    node.si = i;
                }
            }
            node.wordCount++;
            if(node.s == null || node.s.length() > word.length()){
                node.s = word;
                node.si = i;
            }
        }

        public int search(String word) {
            TrieNode node = root;
            int l = 0;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null){
                    if(l == 0)
                    return -1;
                    else
                    return node.si;
                }
                node = node.children[idx];
                l++;
            }
            return node.si;
        }
        
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int min = Integer.MAX_VALUE;
        int mini = 0;
        Trie trie = new Trie();
        for(int i = 0; i < wordsContainer.length; i++){
            trie.insert(new StringBuilder(wordsContainer[i]).reverse().toString() , i);
            if(min > wordsContainer[i].length()){
                min = wordsContainer[i].length();
                mini = i;
            }
        }
        int[] ans = new int[wordsQuery.length];
        for(int i = 0; i < wordsQuery.length; i++){
            ans[i] = trie.search(new StringBuilder(wordsQuery[i]).reverse().toString());
            if(ans[i] == -1)
            ans[i] = mini;
        }
        return ans;
    }
}