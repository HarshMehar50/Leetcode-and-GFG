

class Solution
{
    public int wordLadderLength(String beginWord, String endWord, String[] word)
    {
        // Code here
        List<String> wordList = new ArrayList<>();
        for(int i = 0; i < word.length; i++){
            wordList.add(word[i]);
        }
        if(!wordList.contains(endWord)){
            return 0;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int l = 0;
        while(!q.isEmpty()){
            int s = q.size();
            l++;
            for(int i = 0; i < s; i++){
                String c = q.poll();
                for(int j = 0; j < c.length(); j++){
                    char[] temp = c.toCharArray();
                    for(char ch = 'a'; ch <= 'z'; ch++){
                        temp[j] = ch;
                        String newWord = new String(temp);
                        if(newWord.equals(endWord))
                        return l+1;
                        if(wordList.contains(newWord) && !visited.contains(newWord)){
                            q.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                }
            }
        }
        return 0;
    }
}