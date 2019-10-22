import java.lang.StringBuilder;

class Solution {
    
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int sb_len = 0;
        for(char c : S.toCharArray()) {
            if (sb_len != 0 && c == sb.charAt(sb_len - 1)) {
                sb.deleteCharAt(sb_len - 1);
                sb_len--;
            }
            else {
                sb.append(c);
                sb_len++;
            }
        }
        return sb.toString();
    }
    
}
