import java.util.Stack;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty() || !isMatch(stack.pop(), c)) return false;
            }
            else stack.push(c);
        }
        return stack.isEmpty();
    }
    
    private boolean isMatch(char open, char close) {
        if (open == '(') return close == ')';
        if (open == '[') return close == ']';
        if (open == '{') return close == '}';
        return false;
    }
}
