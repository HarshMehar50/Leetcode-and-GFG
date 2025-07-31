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
        
        boolean solve(String word , int i , TrieNode node , int sc){
            if(i >= word.length()){
                if(sc <= 2 && node.wordCount > 0)
                return true;
                else
                return false;
            }
            if(sc > 2)
            return false;
            for(int j = 0; j < 26; j++){
                if(node.children[j] != null && j == word.charAt(i)-'a'){
                    if(solve(word , i+1 , node.children[j] , sc))
                    return true;
                }else if(node.children[j] != null && j != word.charAt(i)-'a'){
                    if(solve(word , i+1 , node.children[j] , sc+1))
                    return true;
                }
            }
            return false;
        }
        public boolean search(String word) {
            TrieNode node = root;
            /*for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) return false;
                node = node.children[idx];
            }
            return node.wordCount > 0;*/
            return solve(word , 0 , node , 0);
        }
    }
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> ans = new ArrayList<>();
        Trie trie = new Trie();
        for(String s : dictionary){
            trie.insert(s);
        }
        for(String s : queries){
            if(trie.search(s))
            ans.add(s);
        }
        return ans;
    }
}