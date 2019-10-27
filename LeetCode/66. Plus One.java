class Solution {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            int[] result = {1};
            return result;
        }
        int carry = 0;
        int i = digits.length - 1;
        do {
            if (digits[i] == 9){
                digits[i] = 0;
                carry = 1;
            }
            else {
                digits[i]++;
                carry = 0;
            }
            i--;
        } while (carry == 1 && i >= 0);
        
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int j = 1; j < result.length; j++) result[j] = digits[j-1];
            return result;
        }
        return digits;
    }
}
