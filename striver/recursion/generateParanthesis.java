void generate(String op,int open, int close, 
              List<String> res) {
    if(open == 0 && close == 0) {
        vec.add(op);
        return;
    }
    if(open != 0) {
        String op1 = op + "(";
        generate(op1, open - 1, close, res);
    }
    if(close>open) {
        String op2 = op + ")";
        generate(op2, open, close -1, res);
    }
}
