class Solution {
    public boolean uniformArray(int[] nums1) {
        int ce = 0;
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i]%2 == 0)
            ce++;
        }
        if(ce == 0 || ce == nums1.length)
        return true;
        int cea = 0;
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i]%2 == 1){
                for(int j = 0; j < nums1.length; j++){
                    if(nums1[j]%2 == 1 && j != i){
                        cea++;
                        break;
                    }
                }
            }else
            cea++;
        }
        if(cea == nums1.length)
        return true;
        int ceo = 0;
        for(int i = 0; i < nums1.length; i++){
            if(nums1[i]%2 == 0){
                for(int j = 0; j < nums1.length; j++){
                    if(j != i && nums1[j]%2 == 1){
                        ceo++;
                        break;
                    }
                }
            }else
            ceo++;
        }
        if(ceo == nums1.length)
        return true;
        return false;
    }
}