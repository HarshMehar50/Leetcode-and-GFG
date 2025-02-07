class Solution {
    public List<String> stringSequence(String target) {
        List<String> ans = new ArrayList<>();
        for(int i = 0; i < target.length(); i++){
            if(target.charAt(i) == 'a')
            ans.add(target.substring(0 , i)+'a');
            else{
                for(char c = 'a'; c <= target.charAt(i); c++){
                    ans.add(target.substring(0 , i)+c);
                }
            }
        }
        return ans;
    }
}