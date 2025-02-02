class Solution {
    public long wonderfulSubstrings(String word) {
        HashMap<Long , Long> map = new HashMap<>();
        map.put(0L , 1L);
        int xor = 0;
        long ans = 0;
        for(char c : word.toCharArray()){
            xor ^= (1<<((int)c-'a'));
            ans += map.getOrDefault((long)xor , 0L);
            for(char c1 = 'a'; c1 <= 'j'; c1++){
                long cxor = xor^(1<<((int)c1-'a'));
                ans += map.getOrDefault(cxor , 0L);
            }
            map.put((long)xor , map.getOrDefault((long)xor , 0L)+1);
        }
        return ans;
    }
}