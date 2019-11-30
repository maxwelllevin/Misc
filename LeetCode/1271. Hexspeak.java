class Solution {
    public String toHexspeak(String num) {
        // valid chars: A  B  C  D  E  F  G  H  I  J  K  L  M  N  O
        char[] valid = {1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1};
        long n = Long.parseLong(num);
        String hex = Long.toHexString(n).toUpperCase();
        hex = hex.replace('0', 'O'); 
        hex = hex.replace('1', 'I');
        for (int i = 0; i < hex.length(); i++) {
            char c = hex.charAt(i);
            if ((int)(c - 'A') < 0) return "ERROR";
            if (valid[(int)(c - 'A')] != 1) return "ERROR";
        }
        return hex;
    }
}
