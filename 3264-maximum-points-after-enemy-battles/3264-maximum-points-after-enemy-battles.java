class Solution {
    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        if(currentEnergy < enemyEnergies[0])
        return 0;
        /*long ans = 0;
        for(int i = enemyEnergies.length-1; i >= 0; i--){
            if(currentEnergy >= enemyEnergies[i]){
                int n = currentEnergy/enemyEnergies[i];
                ans += n;
                currentEnergy -= n*enemyEnergies[i];
            }
            currentEnergy += enemyEnergies[i];
        }
        return ans;*/
        long ans = currentEnergy;
        for(int i = 1; i < enemyEnergies.length; i++){
            ans += enemyEnergies[i];
        }
        ans = ans/enemyEnergies[0];
        return ans;
    }
}