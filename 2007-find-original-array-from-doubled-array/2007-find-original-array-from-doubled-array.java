class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        // if we don't have an even length array then this is not valid
        if (changed.length % 2 != 0) return new int[]{};
        
        // sort the array in ascending order
        Arrays.sort(changed);
        
        // create a hashmap that contains each value in the input array 
        // and its corresponding frequency 
        HashMap<Integer, Integer> freqMap = new HashMap();
        for(int i = 0; i < changed.length; i++) {
            int curr = changed[i];
            freqMap.put(curr, freqMap.getOrDefault(curr, 0) + 1);
        }
    
        // the final array should be half the size of the input array
        int[] result = new int[changed.length / 2];
        int index = 0;
        for(int i: changed) {
            // edge case: if the nubmer is 0, then the double is also 0
            //and we must decrement by 2
            if (i == 0 && freqMap.containsKey(0) && freqMap.get(0) >= 2) {
                decrementValue(freqMap, 0, 2);
                result[index] = 0;
                index++;
            } else if (i != 0 
                       && freqMap.containsKey(i) 
                       && freqMap.containsKey(i * 2)) {
                // if a value and its double is in the map, then decrement both values
                decrementValue(freqMap, i, 1);
                decrementValue(freqMap, i * 2, 1);
                result[index] = i;
                index++;
            } 
        }
        
        if (freqMap.size() > 0) return new int[]{};
        
        return result;
    }
    
    // decrments the frequency of a particular key in the hashmap.  If we end up at 0 frequency,
    // we will remvove the key from the map
    public void decrementValue(HashMap<Integer, Integer> freqMap, int value, int amount) {
        freqMap.put(value, freqMap.get(value) - amount);
        if (freqMap.get(value) == 0) {
            freqMap.remove(value);
        }
    }
}