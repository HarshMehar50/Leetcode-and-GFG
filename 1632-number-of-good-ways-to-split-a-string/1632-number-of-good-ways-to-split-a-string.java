class Solution {
    public int numSplits(String s) {
        /* String l1 = "s.charAt(0)";
        String r1 = s.substring(1);
        int cl = 1;
        List<Character> list = new ArrayList<>();
        list.add(r1.charAt(0));
        for(int i = 1; i < r1.length(); i++){
            if(list.contains(r1.charAt(i))) continue;
            list.add(r1.charAt(i));
        }
        int cr = list.size();
        int[] dp = new int[s.length()-1];
        if(cl == cr){
            dp[0] = 1;
        }else{
            dp[0] = 0;
        }
        for(int i = 1; i < dp.length; i++){
            if(l1.indexOf(r1.charAt(0)) == -1){
                cl++;
            }
            l1 = l1 + r1.charAt(0);
            r1 = r1.substring(1);
            if(r1.indexOf(l1.charAt(l1.length()-1)) == -1){
                cr--;
            }

            if(cr == cl){
                dp[i] = dp[i-1]+1;
            }else{
                dp[i] = dp[i-1];
            }
        }
        return dp[dp.length-1];*/
        int[] dp = new int[s.length()-1];
        List<Character> l1 = new ArrayList<>();
        List<Character> l2 = new ArrayList<>();
        l1.add(s.charAt(0));
        int c = 0;
        l2.add(s.charAt(1));
        for(int i = 2; i < s.length(); i++){
            if(l2.contains(s.charAt(i))){
                c++;
            }
            l2.add(s.charAt(i));
        }
        int cl = 1;
        int cr = s.length()-1-c;
        if(cr == cl)
            dp[0] = 1;
        else
            dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            if(!l1.contains(l2.get(0))){
                cl++;
            }
            l1.add(l2.get(0));
            l2.remove(0);
            if(!l2.contains(l1.get(l1.size()-1))){
                cr--;
            }
            if(cr == cl)
                dp[i] = dp[i-1]+1;
            else
                dp[i] = dp[i-1];
        }
        return dp[dp.length-1];
    }
}