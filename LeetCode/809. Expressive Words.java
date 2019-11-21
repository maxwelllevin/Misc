import java.util.HashMap;
class Solution {
    
    /*
    ** Counts the number of expressive words that match the string S.
    ** 1. The query word must have the same number of groups as S
    ** 2. The groups in the query word must be in the same order as in S
    ** 3. Groups in the query word must be able to be extended to match groups in S
    */
    public int expressiveWords(String S, String[] words) {
        int expressiveCount = 0;
        Map<Integer, Group> sMap = buildGroups(S);
        for (String word : words) {
            if (isExpressive(word, sMap)) expressiveCount++;
        }
        return expressiveCount;
    }

    /*
    ** Uses the following rules to determine if the given query is expressive.
    ** 1. The query word must have the same number of groups as S
    ** 2. The groups in the query word must be in the same order as in S
    ** 3. Groups in the query word must be able to be extended to match groups in S
    **
    ** A query group can only be extended to match a group in S if 
    ** 1. Both groups consist of the same character
    ** 2. The number of characters in query group must be less than the characters in the S group
    ** 3. The number of characters in the S group must be 3 or more.
    ** Note that if rule 1 holds and the number of characters in each are equal, then the groups match.
    */
    private boolean isExpressive(String query, Map<Integer, Group> sMap) {
        Map<Integer, Group> qMap = buildGroups(query);
        if (qMap.keySet().size() != sMap.keySet().size()) return false;
        
        for (int i = 0; qMap.containsKey(i); i++) {
            Group qGroup = qMap.get(i);
            Group sGroup = sMap.get(i);
            if (qGroup.letter != sGroup.letter) return false;
            if (qGroup.count > sGroup.count) return false;
            if (qGroup.count < sGroup.count && sGroup.count < 3) return false;
        }
        
        return true;
    }
    
    
    /*
    ** Creates a mapping for the given string to simplify further calculation.
    ** sMap {Map<Integer, List<Character>} tracks groups of characters in S.
    **      key {Integer}   - the index of the current group of characters.
    **      val {Group}     - consists of the character of the current group 
    **                        and the number of characters in that group.
    */    
    private Map<Integer, Group> buildGroups(String S) {
        Map<Integer, Group> sMap = new HashMap<>();
        if (S.length() == 0) return sMap;
        
        // Build groups
        char prev = S.charAt(0);
        int prevCount = 1;
        int groupIdx = 0;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) != prev) {
                Group group = new Group(prev, prevCount);
                sMap.put(groupIdx, group);
                prev = S.charAt(i); prevCount = 1;
                groupIdx++;
            }
            else {
                prevCount++;
            }
        }
        Group group = new Group(prev, prevCount);  // Final group
        sMap.put(groupIdx, group);
        
        return sMap;
    }
    
    
    /*
    ** A class to link a character and its number of occurances.
    */
    private class Group {
        public char letter;
        public int count;
        
        public Group(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }
        
        public String toString() {
            return "Group: letter=" + letter + ", count=" + count;
        }
    }
}
