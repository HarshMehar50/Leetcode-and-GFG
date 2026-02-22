class Solution {
    public int binaryGap(int n) {
        String s = Integer.toBinaryString(n);
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '1')
            l.add(i);
        }
        int ans = 0;
        for(int i = 0; i < l.size()-1; i++){
            ans = Math.max(ans , l.get(i+1)-l.get(i));
        }
        return ans;
    }
}