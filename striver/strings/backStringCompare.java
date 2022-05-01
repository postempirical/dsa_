// extra space
class Solution {
    public boolean backspaceCompare(String s, String t) {
        // if not # push to stack
        // else if #, pop if stack not empty
        Stack<Character> s_stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '#') s_stack.push(c);
            else if (!s_stack.isEmpty()) s_stack.pop(); 
        }
        
        // repeat for other string
        Stack<Character> t_stack = new Stack<>();
        for (char c : t.toCharArray()) {
            if (c != '#') t_stack.push(c);
            else if (!t_stack.isEmpty()) t_stack.pop(); 
        }
        
        // now compare stacks
        while (!s_stack.isEmpty()) {
            char curr = s_stack.pop();
            if (t_stack.isEmpty() || t_stack.pop() != curr) return false;
        }
        
        // now retrun true if both stacks are empty in the end
        return t_stack.isEmpty() && s_stack.isEmpty();
    }
}

// constant space
