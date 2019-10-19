class Solution {
    
    // Initial idea:
    // public int climbStairs(int n) {
    //     if (n <= 3) return n;
    //     return climbStairs(n - 1) + climbStairs(n - 2);
    // }
    
    // Faster solution: note that this is same as fibonacci sequence, so can use math to get the nth term much more quickly
    public int climbStairs(int n) {
        if (n <= 3) return n;
        double Phi = (1 + Math.sqrt(5)) / 2;
        double fibN = (Math.pow(Phi, n+1) - Math.pow(1 - Phi, n+1)) / Math.sqrt(5);
        return (int) Math.round(fibN);
    }
}
