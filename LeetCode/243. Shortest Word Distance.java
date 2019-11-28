class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int pos_1 = -1, pos_2 = -1;
        int minDist = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (words[i].equals(word1)) {
                    pos_1 = i;
                }
                else if (words[i].equals(word2)) {
                    pos_2 = i;
                }
                if (pos_1 != -1 && pos_2 != -1) {
                    minDist = Math.min(minDist, Math.abs(pos_1 - pos_2));
                }
            }
        }
        return minDist;
    }
}
