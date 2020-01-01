class Solution:
    def isStrobogrammatic(self, num: str) -> bool:
        pairings = {'0':'0', '1':'1', '6':'9', '8':'8', '9':'6'}
        length = len(num)
        for i in range(0, (length + 1) // 2):
            char1, char2 = num[i], num[length - 1 - i]
            if char1 not in pairings or pairings[char1] != char2:
                return False
        return True
