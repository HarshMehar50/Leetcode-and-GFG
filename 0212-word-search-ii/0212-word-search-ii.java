class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        int wordCount = 0;
        int prefixCount = 0;
        String word = null;
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
            node.word = word;
        }

    }

    int[] dR = {1 , 0 , -1 , 0};
    int[] dC = {0 , 1 , 0 , -1};

    void DFS(char[][] board , boolean[][] visited , int r , int c , TrieNode node , List<String> ans){
        
        if(node.wordCount > 0){
            ans.add(node.word);
            node.wordCount = 0;
        }
        visited[r][c] = true;
        for(int i = 0; i < 4; i++){
            int nr = r+dR[i];
            int nc = c+dC[i];
            if(nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length && !visited[nr][nc] && node.children[board[nr][nc]-'a'] != null)
            DFS(board , visited , nr , nc , node.children[board[nr][nc]-'a'] , ans);
        }
        visited[r][c] = false;
    }
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for(int i = 0; i < words.length; i++){
            trie.insert(words[i]);
        }
        List<String> ans = new ArrayList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(trie.root.children[board[i][j]-'a'] != null){
                    TrieNode node = trie.root.children[board[i][j]-'a'];
                    DFS(board , visited , i , j , node , ans);
                }
            }
        }
        return ans;
    }
}