class Solution {
    String solve(String s1 , String s2 , int i , int j , HashMap<String , String> dp){
        if(i >= s1.length() || j >= s2.length())
        return "";
        String key = i+" "+j;
        if(dp.containsKey(key))
        return dp.get(key);
        if(s1.charAt(i) == s2.charAt(j)){
            String ans = s1.charAt(i)+solve(s1 , s2 , i+1 , j+1 , dp);
            dp.put(key , ans);
            return ans;
        }else{
            String si1 = solve(s1 , s2 , i+1 , j , dp);
            String si2 = solve(s1 , s2 , i , j+1 , dp);
            String ans = "";
            if(si1.length() > si2.length())
            ans = si1;
            else
            ans = si2;
            dp.put(key , ans);
            return ans;
        }
    }
    public String shortestCommonSupersequence(String str1, String str2) {
        HashMap<String , String> dp = new HashMap<>();
        String c = solve(str1 , str2 , 0 , 0 , dp);
        String ans = "";
        if(c.length() == 0)
        return str1+str2;
        int j = 0;
        int k = 0;
        for(int i = 0; i < c.length(); i++){
            while(str1.charAt(j) != c.charAt(i)){
                ans += str1.charAt(j++);
            }
            while(str2.charAt(k) != c.charAt(i)){
                ans += str2.charAt(k++);
            }
            ans += c.charAt(i);
            j++;
            k++;
        }
        return ans+str1.substring(j)+str2.substring(k);
    }
}