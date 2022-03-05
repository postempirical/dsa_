ArrayList<String> NBitBinary(int n) {
  ArrayList<String> res = new ArrayList<>();
  int ones = 0;
  int zeros = 0;
  String op = "";
  solve(ones, zeros, n, op,res);
  return res;
}
    
public void solve(int ones, int zeros, int n, 
                  String op, 
                  ArrayList<String> res) {
  if (n == 0) {
    res.add(op);
    return;
  }

  String op1 = op;
  op1 += "1";
  solve(ones + 1, zeros, n - 1, op1, res);

  if (ones > zeros) {
     String op2 = op;
     op2 += "0";
     solve(ones, zeros + 1, n-1, op2, res);
  }
  return;
}
