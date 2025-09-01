class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        /*TreeMap<Integer , Integer> map = new TreeMap<>();
        for(int i = indexDifference; i < nums.length; i++){
            map.put(nums[i] ,  map.getOrDefault(nums[i] , 0)+1);
        }
        int[] ans = {-1 , -1};
        if!((map.firstKey() > nums[0]-valueDifference && map.lastKey() < nums[0]+valueDifference))*/
        int[][] pmax = new int[nums.length][2];
        int[][] pmin = new int[nums.length][2];
        pmax[0][0] = nums[0];
        pmin[0][0] = nums[0];
        pmax[0][1] = 0;
        pmin[0][1] = 0;
        for(int i = 1; i < nums.length; i++){
            pmax[i][0] = Math.max(pmax[i-1][0] , nums[i]);
            pmin[i][0] = Math.min(pmin[i-1][0] , nums[i]);
            if(pmax[i][0] == pmax[i-1][0])
            pmax[i][1] = pmax[i-1][1];
            else
            pmax[i][1] = i;
            if(pmin[i][0] == pmin[i-1][0])
            pmin[i][1] = pmin[i-1][1];
            else
            pmin[i][1] = i;
        }
        int[][] smax = new int[nums.length][2];
        int[][] smin = new int[nums.length][2];
        smax[nums.length-1][0] = nums[nums.length-1];
        smin[nums.length-1][0] = nums[nums.length-1];
        smax[nums.length-1][1] = nums.length-1;
        smin[nums.length-1][1] = nums.length-1;
        for(int i = nums.length-2; i >= 0; i--){
            smax[i][0] = Math.max(smax[i+1][0] , nums[i]);
            smin[i][0] = Math.min(smin[i+1][0] , nums[i]);
            if(smax[i][0] == smax[i+1][0])
            smax[i][1] = smax[i+1][1];
            else
            smax[i][1] = i;
            if(smin[i][0] == smin[i+1][0])
            smin[i][1] = smin[i+1][1];
            else
            smin[i][1] = i;
        }
        int[][] rangeRight = new int[nums.length][2];
        int[][] rangeLeft = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            if(i+indexDifference < nums.length){
                rangeRight[i][0] = i+indexDifference;
                rangeRight[i][0] = nums.length-1;
            }else{
                rangeRight[i][0] = nums.length;
                rangeRight[i][0] = nums.length;
            }
            if(i-indexDifference >= 0){
                rangeLeft[i][0] = 0;
                rangeLeft[i][1] = i-indexDifference;
            }else{
                rangeLeft[i][0] = -1;
                rangeLeft[i][1] = -1;
            }
        }
        int[] ans = {-1 , -1};
        for(int i = 0; i < nums.length; i++){
            if(rangeRight[i][0] != nums.length){
                int l = rangeRight[i][0];
                int r = rangeRight[i][1];
                int min = smin[l][0];
                int max = smax[l][0];
                if(!(min > nums[i]-valueDifference && max < nums[i]+valueDifference)){
                    if(min <= nums[i]-valueDifference){
                        ans[0] = i;
                        ans[1] = smax[l][1];
                        break;
                    }else if(max >= nums[i]+valueDifference){
                        ans[0] = i;
                        ans[1] = smax[l][1];
                        break;
                    }
                }
            }
            if(rangeLeft[i][0] != -1){
                int l = rangeLeft[i][0];
                int r = rangeLeft[i][1];
                int min = pmin[r][0];
                int max = pmax[r][0];
                if(!(min > nums[i]-valueDifference && max < nums[i]+valueDifference)){
                    if(min <= nums[i]-valueDifference){
                        ans[0] = i;
                        ans[1] = pmin[r][1];
                        break;
                    }else if(max >= nums[i]+valueDifference){
                        ans[0] = i;
                        ans[1] = pmax[r][1];
                        break;
                    }
                }
            }
        }
        return ans;
    }
}