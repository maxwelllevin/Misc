class Solution {
    public boolean validPalindrome(String S) {
        int left = 0, right = S.length() - 1;
        int delete = 0;
        while (left < right) {
            if (S.charAt(left) != S.charAt(right)) {
                return isValid(S, left + 1, right) || isValid(S, left, right - 1);
            }
            left++; right--;
        }
        return true;
    }
    
    private boolean isValid(String S, int left, int right) {
        while (left < right) {
            if (S.charAt(left) != S.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}
