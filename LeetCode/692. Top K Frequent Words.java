class Solution {
    
    class Pair {
        public String word;
        public int freq;
        public Pair(String s, int f) {
            word = s;
            freq = f;
        }
        public String toString() {
            return "Pair: word=" + word + ", freq=" + freq;
        }
    }
    
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freqTable = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            freqTable.put(words[i], freqTable.getOrDefault(words[i], 0) + 1);
        }
        PriorityQueue<Pair> pQueue = new PriorityQueue<>((p1, p2) -> {
            if (p1.freq != p2.freq) return p1.freq - p2.freq;
            return p2.word.compareTo(p1.word);

        });
        for (String word : freqTable.keySet()) {
            Pair pair = new Pair(word, freqTable.get(word));
            pQueue.add(pair);
            if (pQueue.size() > k) pQueue.remove();
        }
        List<String> answer = new LinkedList<>();
        while (pQueue.size() > 0) {
            answer.add(pQueue.remove().word);
        }
        Collections.reverse(answer);
        return answer;
    }
}
