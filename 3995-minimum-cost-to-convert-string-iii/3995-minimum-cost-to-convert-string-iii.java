class Solution {
    int solve(String source , String target , int i , List<List<String>> rules , int[] costs , int[] ac , int[] dp){
        if(i >= source.length())
        return 0;
        if(dp[i] != -1)
        return dp[i];
        int ans = (int)(1e9);
        if(source.charAt(i) == target.charAt(i))
        ans = Math.min(ans , solve(source , target , i+1 , rules , costs , ac , dp));
        for(int k = 0; k < rules.size(); k++){
            List<String> l = rules.get(k);
            if(i+l.get(0).length()-1 >= source.length()) continue;
            boolean check1 = true;
            for(int j = 0; j < l.get(0).length(); j++){
                if(l.get(0).charAt(j) != '*' && l.get(0).charAt(j) != source.charAt(i+j)){
                    check1 = false;
                    break;
                }
            }
            if(check1){
                boolean check2 = true;
                for(int j = 0; j < l.get(1).length(); j++){
                    if(l.get(1).charAt(j) != target.charAt(i+j)){
                        check2 = false;
                        break;
                    }
                }
                if(check2)
                ans = Math.min(ans , costs[k]+ac[k]+solve(source , target , i+l.get(0).length() , rules , costs , ac , dp));
            }
        }
        dp[i] = ans;
        return dp[i];
    }
    public int minCost(String source, String target, List<List<String>> rules, int[] costs) {
        int[] ac = new int[rules.size()];
        for(int i = 0; i < ac.length; i++){
            for(int j = 0; j < rules.get(i).get(0).length(); j++){
                if(rules.get(i).get(0).charAt(j) == '*')
                ac[i]++;
            }
        }
        int[] dp = new int[source.length()];
        Arrays.fill(dp , -1);
        int ans = solve(source , target , 0 , rules , costs , ac , dp);
        if(ans == (int)(1e9))
        return -1;
        return ans;
    }
}