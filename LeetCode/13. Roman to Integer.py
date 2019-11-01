class Solution:
    def romanToInt(self, s: str) -> int:
        if not s: 
            return 0
        values = {"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
        prev = s[0]
        ans = values[prev]
        i = 1       
        while i < len(s):
            c = s[i]
            if (values[c] > values[prev]):
                ans -= values[prev]
                ans += values[c] - values[prev]
            else:
                ans += values[c]
            prev = c
            i += 1
        return ans
