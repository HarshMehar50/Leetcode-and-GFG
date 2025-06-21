class Solution {
    public int maxDistance(String s, int k) {
        int n = 0;
        int s1 = 0;
        int e = 0;
        int w = 0;
        int ans = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == 'N')
            n++;
            else if(s.charAt(i) == 'S')
            s1++;
            else if(s.charAt(i) == 'E')
            e++;
            else
            w++;
            int d = Math.abs(n-s1)+Math.abs(e-w);
            int steps = i+1;
            int wasted = steps-d;
            int rem = Math.min(2*k , wasted);
            ans = Math.max(ans , d+rem);
        }
        return ans;
    }
}