//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


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