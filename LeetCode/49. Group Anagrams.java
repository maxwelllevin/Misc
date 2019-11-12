import java.util.HashMap;
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        for (String S : strs) {
            String sorted = getSortedString(S);
            List<String> curr = groups.getOrDefault(sorted, new LinkedList<String>());
            curr.add(S);
            groups.put(sorted, curr);
        }
        return new LinkedList(groups.values());
    }
    
    /*
    ** Returns a sorted String.
    ** @param {String} S - the String to sort.
    */
    private String getSortedString(String S) {
        char[] chars = S.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}
