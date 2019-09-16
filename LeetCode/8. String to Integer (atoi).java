class Solution {
    public int myAtoi(String s) {
        char c;
        int i;
        long ans = 0;
        boolean positive = true;

        // Find the starting index of the number and determine the sign 
        for(i=0; i<s.length(); i++) {
            c = s.charAt(i);
            if(c != ' ') {
                if(c == '-') {
                  positive = false;
                  i++;
                }
                if(c == '+') i++;
                break;
            }
        }

        // Loop through the remaining characters. Return the current answer if 
        // the character is non-numeric. Returns the max/min int value if there
        // would be an overflow. 
        for(; i<s.length(); i++) {
          c = s.charAt(i);
          if (Character.isDigit(c)) ans = ans*10+Character.getNumericValue(c);
          else break;
              if (ans > Integer.MAX_VALUE) {
                  if (positive) return Integer.MAX_VALUE;
                  else return Integer.MIN_VALUE;
              }
        }
        ans = positive ? ans : -ans;
        return (int) ans;
    }
}
