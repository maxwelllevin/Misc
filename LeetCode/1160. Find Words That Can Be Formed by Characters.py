class Solution:
    def countCharacters(self, words: List[str], chars: str) -> int:
        letters = Counter(chars)
        num_letters = 0
        for word in words:
            flag = True
            for (letter, count) in Counter(word).items():
                if letters[letter] < count:
                    flag = False
                    break
            if flag:
                num_letters += len(word) 
        return num_letters
        
