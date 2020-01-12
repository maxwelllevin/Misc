class StockSpanner {

    private List<Integer> stocks;
    private List<Integer> spans;
    
    public StockSpanner() {
        stocks = new ArrayList<>();
        spans = new ArrayList<>();
    }
    
    public int next(int price) {       
        int span = 1;  // current span
        int prev = stocks.size() - 1; // yesterday's index
        
        while (prev >= 0 && stocks.get(prev) <= price) {
            span += spans.get(prev);
            prev = prev - spans.get(prev);
        }
        
        stocks.add(price);        
        spans.add(span);
        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
