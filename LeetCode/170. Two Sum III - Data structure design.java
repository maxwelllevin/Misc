import java.util.HashMap;
class TwoSum {

    private Map<Integer, Integer> data;
    
    
    /** Initialize your data structure here. */
    public TwoSum() {
        data = new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        data.put(number, data.getOrDefault(number, 0) + 1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for (int key : data.keySet()) {
            int find_key = value - key;
            if (data.containsKey(find_key)) {
                if (find_key != key || data.get(find_key) > 1) return true;
            }
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
