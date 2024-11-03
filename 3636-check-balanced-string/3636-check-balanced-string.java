class Solution {
    public boolean isBalanced(String num) {
        int o = 0;
        int e = 0;
        for(int i = 0; i < num.length(); i++){
            int val = Integer.parseInt(num.substring(i , i+1));
            if(i%2 == 0)
            e += val;
            else
            o += val;
        }
        if(o == e)
        return true;
        else
        return false;
    }
}