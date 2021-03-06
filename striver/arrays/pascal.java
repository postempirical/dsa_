// PRINT TRIANGLE
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0 ; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j <= i ; j++) {
                if(j == 0 || j == i) {
                    list.add(1);
                }
                else {
                    int a = result.get(i - 1).get(j - 1);
                    int b = result.get(i - 1).get(j);
                    list.add(a + b);
                }
            }
            result.add(list);
         }
        return result;
      }
}

// rth row cth col
(r-1)C(c-1)
      
// rth row
  for (int i = 0; i < rows; i++) {
    ans *= n - i;
    ans /= i + 1;
