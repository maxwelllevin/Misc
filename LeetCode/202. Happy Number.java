class Solution {
    public boolean isHappy(int n) {
        if (n == 1) return true;
        Set<Integer> seen = new HashSet<>();
        seen.add(n);
        for (n = next(n); !seen.contains(n); n = next(n)) {
            if (n == 1) return true;
            seen.add(n);
        }
        return false;
    }
    
    
    private int next(int n) {
        int sum = 0;
        char[] digits = ("" + n).toCharArray();
        for (char digit : digits) {
            int d = parseDigit(digit);
            sum += d * d;
        }
        return sum;
    }
    
    private int parseDigit(char d) {
        return (int) (d - '0');
    }
}
