class ATM {
    int[] f;
    public ATM() {
        f = new int[5];
    }
    
    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < banknotesCount.length; i++){
            f[i] += banknotesCount[i];
        }
    }
    
    public int[] withdraw(int amount) {
        int[] ans = new int[5];
        int i = 4;
        while(i >= 0 && amount != 0){
            int d = 0;
            if(i == 4)
            d = 500;
            else if(i == 3)
            d = 200;
            else if(i == 2)
            d = 100;
            else if(i == 1)
            d = 50;
            else d = 20;
            int r = amount/d;
            r = Math.min(r , f[i]);
            f[i] -= r;
            amount -= r*d;
            ans[i] += r;
            i--;
        }
        if(amount != 0){
            for(int j = 0; j < 5; j++){
                f[j] += ans[j];
            }
            return new int[]{-1};
        }
        return ans;
    }
}

/**
 * Your ATM object will be instantiated and called as such:
 * ATM obj = new ATM();
 * obj.deposit(banknotesCount);
 * int[] param_2 = obj.withdraw(amount);
 */