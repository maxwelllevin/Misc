class Solution {
    
    private boolean check(String s, int lo, int hi) {
        if (hi - lo <= 1) {
            return true;
        }
        return s.charAt(lo) == s.charAt(hi - 1) && check(s, lo + 1, hi - 1);
    }
    
    public boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        return check(s, 0, s.length());
    }
}
