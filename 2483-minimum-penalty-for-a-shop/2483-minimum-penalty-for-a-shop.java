class Solution {
    public int bestClosingTime(String customers) {
        int[] ss = new int[customers.length()+1];
        int[] ps = new int[customers.length()+1];
        /*if(customers.charAt(customers.length()-1) == 'Y')
        ss[ss.length-1] = 1;
        for(int i = ss.length-2; i >= 0; i--){
            ss[i] = ss[i+1];
            if(customers.charAt(i) == 'Y')
            ss[i]++;
        }
        if(customers.charAt(0) == 'N')
        ps[0] = 1;
        for(int i = 1; i < ps.length; i++){
            ps[i] = ps[i-1];
            if(customers.charAt(i) == 'N')
            ps[i]++;
        }
        int min = Integer.MAX_VALUE;
        int ans = -1;
        
        if(ss[0] <= min){
            min = ss[0];
            ans = 0;
        }
        if(ps[ps.length-1] <= min){
            min = ps[ps.length-1];
            ans = ps.length;
        }
        for(int i = 1; i < ps.length; i++){
            if(ps[i-1]+ss[i] <= min){
                min = ps[i-1]+ss[i];
                ans = i;
            }
        }
        return ans;*/
        for(int i = customers.length()- 1; i >= 0; i--) {
            ss[i] = ss[i + 1];
            if(customers.charAt(i) == 'Y') 
            ss[i]++;
        }
        for(int i = 0; i < customers.length(); i++) {
            ps[i+1] = ps[i];
            if(customers.charAt(i) == 'N') 
            ps[i+1]++;
        }
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i <= customers.length(); i++) {
            int penalty = ps[i] + ss[i];
            if (penalty < min) {
                min = penalty;
                ans = i;
            }
        }
        return ans;
    }
}