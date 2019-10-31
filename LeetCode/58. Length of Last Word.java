class Solution {
    public int lengthOfLastWord(String S) {
        int i = S.length() - 1;
        int len = 0;
        while (i >= 0 && S.charAt(i) == ' ') { i--; }
        while (i >= 0 && S.charAt(i) != ' ') {
            len++;
            i--;
        }
        return len;
    }
}
