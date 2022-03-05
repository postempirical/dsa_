// unique subsets
// https://www.youtube.com/watch?v=lfFqW1DTsqM&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=14
 public static void main(String[] args) {
    Set<String> uniqueSubset = new HashSet<>();
    uniqueSubset = printUnique("aab", "", uniqueSubset);
    System.out.println("Unique subsets: ");
    uniqueSubset.forEach(System.out::println);
  }

  public static Set<String> printUnique(String ipStr, String opStr,
    Set<String> resMap) {
    if (ipStr.isEmpty()) {
      resMap.add(opStr);
      return new HashSet<>();
    }
    String opStr2 = opStr;
    opStr2 += ipStr.charAt(0);
    ipStr = ipStr.substring(1);
    printUnique(ipStr, opStr, resMap);
    printUnique(ipStr, opStr2, resMap);
    return resMap;
  }
}


// abc with spaces
// https://www.youtube.com/watch?v=1cspuQ6qHW0&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=14
  public static void main(String[] args) {
    String ip = "ABCD", op = "";

    // since _abc wont be a valid output
    op += ip.charAt(0);
    ip = ip.substring(1);
    solve(ip, op);
  }

  private static void solve(String ip, String op) {
    if (ip.isEmpty()) {
      System.out.println(op);
      return;
    }
    String op1 = op, op2 = op;
    op1 += " ";
    op1 += ip.charAt(0);
    op2 += ip.charAt(0);
    ip = ip.substring(1);
    solve(ip, op1);
    solve(ip, op2);
  }
}


// permutations with case change
// https://www.youtube.com/watch?v=J2Er5XceU_I&list=PL_z_8CaSLPWeT1ffjiImo0sYTcnLzo-wY&index=15
void check(String ip,String op) {
    if(ip.length()==0) {
        System.out.println(op);
        return;
    }
  
    String op1 = op;
    String op2 = op;
    op1 += ip.charAt(0);
    op2 += Character.toUpperCase(ip.charAt(0));
    ip = ip.substring(1);
    check(ip, op1);
    check(ip, op2);
 }
