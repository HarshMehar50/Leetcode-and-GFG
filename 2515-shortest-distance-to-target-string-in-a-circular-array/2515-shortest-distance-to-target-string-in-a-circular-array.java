class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(target))
            l.add(i);
        }
        int ans = Integer.MAX_VALUE;
        for(Integer x : l){
            ans = Math.min(Math.abs(startIndex-x) , ans);
            if(x > startIndex)
            ans = Math.min(ans , startIndex+words.length-x);
            else
            ans = Math.min(ans , words.length-startIndex+x);
        }
        if(ans != Integer.MAX_VALUE)
        return ans;
        return -1;
    }
}