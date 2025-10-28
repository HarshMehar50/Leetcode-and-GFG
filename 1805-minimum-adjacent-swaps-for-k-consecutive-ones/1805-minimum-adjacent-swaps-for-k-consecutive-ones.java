class Solution {
    public int minMoves(int[] nums, int k) {
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 1)
            l.add(i-l.size());
        }
        /*int[] median = new int[l.size()-k+1];
        for(int i = 0; i < median.length; i++){
            median[i] = l.get(i+(k-1)/2);
        }
        int[] ps = new int[l.size()];
        ps[0] = l.get(0);
        int medi = (k-1)/2;
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i-1]+l.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < median.length; i++){
            int ls = 0;
            if(i+medi-1 >= 0)
            ls = ps[i+medi-1];
            if(i-1 >= 0)
            ls -= ps[i-1];
            int rs = 0;
            if(i+medi < ps.length)
            rs = ps[i+medi];
            if(i+medi < ps.length)
            rs -= ps[i+medi];
            int cost = (medi*median[i])-(((k*k)-1)/8)-ls + rs-((medi*median[i])+(((k*k)-1)/8));
            ans = Math.min(ans , cost);
        }
        return ans;*/
        int[] ps = new int[l.size()+1];
        for(int i = 0; i < l.size(); i++){
            ps[i+1] = ps[i]+l.get(i);
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i+k <= l.size(); i++){
            int median = l.get(i+(k/2));
            int ls = (median*(k/2))-(ps[i+(k/2)]-ps[i]);
            int rs = (ps[i+k]-ps[i+(k/2)+1])-(median*(k-(k/2)-1));
            ans = Math.min(ans , ls+rs);
        }
        return ans;
    }
}