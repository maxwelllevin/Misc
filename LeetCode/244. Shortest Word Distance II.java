import java.util.HashMap;
import java.util.ArrayList;

class WordDistance {
    Map<String, List<Integer>> map;
        
    public WordDistance(String[] words) {
        // Build mapping of word -> indices
        map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            List<Integer> indices = map.getOrDefault(word, new ArrayList<Integer>());
            indices.add(i);
            map.put(word, indices);
        }
    }
    
    public int shortest(String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        List<Integer> idxs1 = map.get(word1), idxs2 = map.get(word2);
        for (int i = 0, j = 0; i < idxs1.size() && j < idxs2.size(); ) {
            minDist = Math.min(minDist, Math.abs(idxs1.get(i) - idxs2.get(j)));
            if (idxs1.get(i) < idxs2.get(j)) i++;
            else if (idxs1.get(i) > idxs2.get(j)) j++;
            else return -1;  // indices are in the same position --impossible
        }
        return minDist;
    }
    
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);
 */
