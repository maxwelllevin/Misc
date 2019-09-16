class Solution {
    public int lengthOfLongestSubstring(String s) {
        int largest = 0;
        int[] map = new int[128];  // key: character, value: index in string s
        
        for (int i = 0, j = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            j = Math.max(j, map[c]);
            largest = Math.max(largest, i - j + 1);
            map[c] = i + 1;
        }
        return largest;
    }
}
