class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] indexes = new int[26];
        for (int i = 0; i < 26; i++) {
            char c = keyboard.charAt(i);
            indexes[(int) (c - 'a')] = i;
        }
        int time = 0;
        int prev = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int curr = indexes[(int)(word.charAt(i) - 'a')];
            time += Math.abs(curr - prev);
            prev = curr;
        }
        return time;
    }
}
