import java.util.HashMap;
class Solution {
    
    /**
    ** Returns a list of lists of strings grouped by their shifting sequence.
    ** A shifting sequence of a word is the sequence of words that can be made
    ** by increasing the lexicographical value of each character in the word any number of times.
    ** 
    ** EX:  "abc" -> "bcd" by adding a value of 1 to each character. 
    **      Thus "abc" and "bcd belong to the same shifting sequence.
    ** 
    ** EX:  "az" -> "ba" by adding 1 to each character of "az" (Note: wrapping)
    **      Thus "az" and "ba" belong to the same shifting sequence.
    **
    ** @param {String[]} strings                    - the strings to group into shifting sequences.
    ** @returns {LinkedList<LinkedList<String>>}    - the groupings of shifting sequences. 
    */
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String S: strings) {
            String dist_str = getDistancesAsString(S);
            List<String> curr = groups.getOrDefault(dist_str, new LinkedList<String>());
            curr.add(S);
            groups.put(dist_str, curr);
        }
        return new LinkedList(groups.values());
    }
    
    /**
    ** Maps a String to its lexicographical distances between adjacent characters.
    ** The returned mapping is represented as a String of characters, centered around 'a'.
    **
    ** EX:  if given the string "abc", return "bb".
    **      'b' - 'a' = 1  --> 'b'
    **      'c' - 'b' = 1  --> 'b'
    **
    ** @param {String} S - the string to map to distances
    ** @returns {String} - the mapping of distances as characters in the range ['a', 'z']
    */
    private String getDistancesAsString(String S) {
        if (S.length() == 1) return ".";
        char[] dists = new char[S.length() - 1];
        for (int i = 1; i < S.length(); i++) {
            int dist = S.charAt(i) - S.charAt(i-1);
            if (dist < 0) dist += 26;
            dists[i-1] = (char)('a' + dist);
        }
        return new String(dists);
    }
}
