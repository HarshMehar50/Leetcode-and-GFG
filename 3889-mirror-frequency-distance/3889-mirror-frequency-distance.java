class Solution {
    public int mirrorFrequency(String s) {
        int[] fc = new int[26];
        int[] fd = new int[10];
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                fc[s.charAt(i)-'a']++;
            else
                fd[s.charAt(i)-'0']++;
        }
        int ans = 0;
        for(int i = 0; i < 13; i++){
            ans += Math.abs(fc[i]-fc[25-i]);
        }
        for(int i = 0; i < 5; i++){
            ans += Math.abs(fd[i]-fd[9-i]);
        }
        return ans;
    }
}