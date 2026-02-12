class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int[][] a = new int[bobValues.length][3];
        for(int i = 0; i < a.length; i++){
            a[i][0] = aliceValues[i]+bobValues[i];
            a[i][1] = aliceValues[i];
            a[i][2] = bobValues[i];
        }
        Arrays.sort(a , (x , y)->Integer.compare(y[0] , x[0]));
        int score = 0;
        for(int i = 0; i < a.length; i++){
            if(i%2 == 0)
            score += a[i][1];
            else
            score -= a[i][2];
        }
        if(score > 0)
        return 1;
        else if(score == 0)
        return 0;
        else
        return -1;
    }
}