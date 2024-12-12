class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
       /* int[][] a = new int[aliceValues.length][2];
        int[][] b = new int[bobValues.length][2];
        for(int i = 0; i < aliceValues.length; i++){
            a[i][0] = aliceValues[i];
            b[i][0] = bobValues[i];
            a[i][1] = i;
            b[i][1] = i;
        }
        Arrays.sort(a , (x , y)->Integer.compare(y[0] , x[0]));
        Arrays.sort(b , (x , y)->Integer.compare(y[0] , x[0]));*/
        int as = 0;
        int bs = 0;
       // boolean[] visiteda = new boolean[aliceValues.length];
        // boolean[] visitedb = new boolean[aliceValues.length];
        /*int turn = 1;
        for(int i = 0; i < aliceValues.length; i++){
            if(turn == 1){
                if(!visited[a[i][1]]){
                    as += a[i][0];
                    visited[a[i][1]] = true;
                }else{
                    int index = i;
                    for(int j = i+1; j < a.length; j++){
                        if(!visited[a[j][1]]){
                            index = j;
                            break;
                        }
                    }
                    as += a[index][0];
                    visited[a[index][1]] = true;
                }
                turn = 0;
            }else{
                if(!visited[b[i][1]]){
                    bs += b[i][0];
                    visited[b[i][1]] = true;
                }else{
                    int index = i;
                    for(int j = i+1; j < b.length; j++){
                        if(!visited[b[j][1]]){
                            index = j;
                            break;
                        }
                    }
                    bs += b[index][0];
                    visited[b[index][1]] = true;
                }
                turn = 1;
            }
        }*/
        /*int i = 0;
        int j = 0;
        while(i < a.length || j < b.length){
            if(i < a.length && !visiteda[a[i][1]]){
                as += a[i][0];
                visiteda[a[i][1]] = true;
                i++;
            }
            if(j < b.length && !visitedb[b[j][1]]){
                bs += b[j][0];
                visitedb[b[j][1]] = true;
                j++;
            }
        }*/
        int[][] ab = new int[aliceValues.length][4];
        for(int i = 0; i < aliceValues.length; i++){
            ab[i][0] = aliceValues[i];
            ab[i][1] = bobValues[i];
            ab[i][2] = ab[i][0]+ab[i][1];

        }
        Arrays.sort(ab , (x , y)->Integer.compare(y[2] , x[2]));
        for(int i = 0; i < ab.length; i=i+2){
            as += ab[i][0];
        }
        for(int i = 1; i < ab.length; i=i+2){
            bs += ab[i][1];
        }
        if(as > bs)
        return 1;
        else if(as < bs)
        return -1;
        else
        return 0;
    }
}