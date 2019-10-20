class Solution {
    /**
    ** Checks if the number is a perfect square.
    ** For each unique prime in the prime decomposition of the number
    ** there must be an even number of occurances of that prime. 
    ** Additionally, no perfect squares end in a 2, 3, 7, or 8.
    ** Returns true if the number is a perfect square, false otherwise.
    */
    public boolean isPerfectSquare(int num) {
        if (!isPossibleSquare(num) || num < 0) return false;
        int p = 2, p_count = 0;
        int num_copy = num;
        while (num_copy > 1) {
            if (p * p > num) return false;
            if (num_copy % p == 0) {
                num_copy /= p;
                p_count++;
            }
            else if (p_count % 2 == 1) {
                return false;
            }
            else {
                p++;
                p_count = 0;
            }
        }
        return p_count % 2 == 0;   
    }

    /**
    ** Check the unit's place to see if it is possibly a perfect square.
    ** A perfect square cannot end in a 2, 3, 7, or 8.
    ** Returns true if the number is a possible square, false otherwise
    */
    private boolean isPossibleSquare(int num) {
        int end = num % 10;
        return !(end == 2 || end == 3 || end == 7 || end == 8);
    }
}
