class Solution {
    
    private int sieveEratosthenes(int n) {
        boolean[] sieve = new boolean[n];  // defaults to false
        int primeCount = 0;
        for (int i = 2; i < n; i++) {
            if (!sieve[i]) {
                primeCount++;
                for (int j = i + i; j < n; j += i) sieve[j] = true;
            }
        }
        return primeCount;
    }
    
    public int countPrimes(int n) {
        return sieveEratosthenes(n);
    }
}
