import java.lang.StringBuilder;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int longestPossible = Integer.MAX_VALUE;
        for(String s : strs) {
            longestPossible = Math.min(longestPossible, s.length());
        }
        StringBuilder build = new StringBuilder();
        for (int i = 0; i < longestPossible; i++) {
            char c = strs[0].charAt(i);
            for (String s : strs) {
                if (s.charAt(i) != c) return build.toString();
            }
            build.append(c);
        }
        return build.toString();
    }
}
