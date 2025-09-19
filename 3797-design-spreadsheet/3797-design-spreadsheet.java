class Spreadsheet {
    int[][] sheet;
    public Spreadsheet(int rows) {
        sheet = new int[rows][26];
    }
    
    public void setCell(String cell, int value) {
        int c = (int)(cell.charAt(0)-'A');
        int r = Integer.parseInt(cell.substring(1))-1;
        if(r > sheet.length){
            int[][] t = new int[sheet.length][26];
            for(int i = 0; i < t.length; i++){
                for(int j = 0; j < 26; j++){
                    t[i][j] = sheet[i][j];
                }
            }
            sheet = new int[r][26];
            for(int i = 0; i < sheet.length; i++){
                for(int j = 0; j < 26; j++){
                    sheet[i][j] = t[i][j];
                }
            }
        }
        sheet[r][c] = value;
    }
    
    public void resetCell(String cell) {
        int c = (int)(cell.charAt(0)-'A');
        int r = Integer.parseInt(cell.substring(1))-1;
        sheet[r][c] = 0;
    }
    
    public int getValue(String formula) {
        int opi = 0;
        for(int i = 0; i < formula.length(); i++){
            if(formula.charAt(i) == '+' || formula.charAt(i) == '/' || formula.charAt(i) == '*' || formula.charAt(i) == '-'){
                opi = i;
                break;
            }
        }
        char op = formula.charAt(opi);
        String op1 = formula.substring(1 , opi);
        String op2 = formula.substring(opi+1);
        int o1 = 0;
        int o2 = 0;
        if(op1.charAt(0) >= 'A' && op1.charAt(0) <= 'Z'){
            int c = (int)(op1.charAt(0)-'A');
            int r = Integer.parseInt(op1.substring(1))-1;
            o1 = sheet[r][c];
        }else
            o1 = Integer.parseInt(op1);

        if(op2.charAt(0) >= 'A' && op2.charAt(0) <= 'Z'){
            int c = (int)(op2.charAt(0)-'A');
            int r = Integer.parseInt(op2.substring(1))-1;
            o2 = sheet[r][c];
        }else
            o2 = Integer.parseInt(op2);

        if(op == '+')
            return o1+o2;
        else if(op == '-')
            return o1-o2;
        else if(op == '*')
            return o1*o2;
        else
            return o1/o2;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */