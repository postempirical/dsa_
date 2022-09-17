class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                st.push(i);
            }
            if (c == ')') {
                if (!st.isEmpty() && s.charAt(st.peek()) == '(') st.pop();
                else {
                    st.push(i);
                }
            }
            sb.append(c);
        }
        while (!st.isEmpty()) sb.deleteCharAt(st.pop());
        
        return sb.toString();
    }
}
