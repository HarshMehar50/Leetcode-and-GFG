class Solution {
    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        long[] dpA = new long[energyDrinkA.length];
        long[] dpB = new long[energyDrinkA.length];
        dpA[0] = energyDrinkA[0];
        dpA[1] = dpA[0]+energyDrinkA[1];
        dpB[0] = energyDrinkB[0];
        dpB[1] = dpB[0]+energyDrinkB[1];
        for(int i = 2; i < energyDrinkA.length; i++){
            dpA[i] = Math.max(dpA[i-1] , dpB[i-2])+energyDrinkA[i];
            dpB[i] = Math.max(dpB[i-1] , dpA[i-2])+energyDrinkB[i];
        }
        return Math.max(dpA[energyDrinkA.length-1] , dpB[energyDrinkB.length-1]);
    }
}