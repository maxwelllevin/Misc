class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0;
        int stop = 0;
        
        for(int i = 0; i < s.length(); i++) {
            int odd = MaxPalindromeLength(s, i, i);  // L/R are the same
            int even = MaxPalindromeLength(s, i, i+1);  // L is one less than R
            int localMax = odd > even ? odd : even;
            if (localMax > stop - start) {
                start = i - (localMax - 1) / 2;  // 
                stop = i + localMax / 2;
            }
        }
        
        return s.substring(start, stop + 1);  // stop is inclusive
    }
    
    private int MaxPalindromeLength(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
