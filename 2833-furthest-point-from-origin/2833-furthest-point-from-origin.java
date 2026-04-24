class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int d = 0;
        int c = 0;
        for(int i = 0; i < moves.length(); i++){
            if(moves.charAt(i) == 'L')
            d--;
            else if(moves.charAt(i) == 'R')
            d++;
            else
            c++;
        }
        if(d <= 0)
        d -= c;
        else
        d += c;
        return Math.abs(d);
    }
}