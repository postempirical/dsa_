// integer to roman
// [1] 
class Solution {
    public String intToRoman(int num) {
    int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    String[] strs = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    
    StringBuilder sb = new StringBuilder();
    
    for(int i=0;i<values.length;i++) {
        while(num >= values[i]) {
            num -= values[i];
            sb.append(strs[i]);
        }
    }
    return sb.toString();
}

// [2] 
class Solution {
    public String intToRoman(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }
}
  

// roman to integer
class Solution {
    public int romanToInt(String s) {
        //Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）and Ⅿ（1000）
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        int res = 0;
        
        // if current is lesser than next, add their difference
        // ALSO SKIP THE NEXT DIGIT
        int i = 0;
        while (i < s.length() - 1) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))
                res += map.get(s.charAt(i + 1)) - map.get(s.charAt(i++));
            else res += map.get(s.charAt(i));
            i++;
        }
        // if is is still on the last digit we need to add it
        if (i == s.length() - 1) res += map.get(s.charAt(i));
        return res;
    }
	
	  // ANOTHER APPROACH
		// for (int i = 0; i < s.length(); i++) {
		//     // if current is greater than prev, minus 2 times prev to negate its addition
		//     if (i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i - 1)))
		//         res += map.get(s.charAt(i)) - 2 * map.get(s.charAt(i - 1));
		//     else res += map.get(s.charAt(i));
		// }
}


