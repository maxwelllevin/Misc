class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        if (needle.length() > haystack.length()) return -1;
        int i = 0;
        while (i < haystack.length() - needle.length() + 1) {
            int matches = numMatches(haystack, i, needle);
            // System.out.println("(i=" + i + ", m=" + matches + ")");
            if (matches == needle.length()) return i;
            i++;
        }
        return -1;
    }
    
    /**
    ** Returns the length of the match.
    ** ie. if string = potatoes, index = 2, and pattern = toes,
    ** this would return 1, because the pattern toes matches the first t in tatoes.
    ** With the same string and pattern, but index = 4, then this would return 4 
    ** because the string after index 4 is toes, which matches the pattern to 4 letters.
    ** Returns -1 if the pattern is longer than the remaining string.
    */
    private int numMatches(String string, int s_index, String pattern) {
        for (int i = 0; i < pattern.length(); i++) {
            if (string.charAt(s_index + i) != pattern.charAt(i)) return i;
        }
        return pattern.length();
    }
}
