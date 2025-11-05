class Solution {
    class Pair implements Comparable<Pair> {
        int num;
        int freq;

        Pair(int num, int freq) {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Pair p) {
            // ascending by freq then num
            if (this.freq == p.freq) {
                return this.num - p.num; // smallest by number
            }
            return this.freq - p.freq; // smallest by freq
        }
    }

    long sum;
    TreeSet<Pair> top;
    TreeSet<Pair> rest;

    public void insertInSet(int num, int freq, int x) {
        Pair p = new Pair(num, freq);
        if (top.size() < x || p.compareTo(top.first()) > 0) { // if top set doesnt have x elements or this pair > top's smallest
            sum += (long) p.num * p.freq; // update sum
            top.add(p); // add this pair to top set

            if (top.size() > x) { // if top size exceeded ( > x ) 
                Pair smallest = top.first(); // remove smallest from top set
                sum -= (long) smallest.num * smallest.freq; // update sum again
                top.remove(smallest); // remove
                rest.add(smallest); // add it to the other i.e rest set
            }
        } else { // when top have x elements and this pair is not > top's smallest
            rest.add(p); // just add it to the rest set
        }
    }

    public void removeFromSet(int num, int freq, int x) {
        Pair p = new Pair(num, freq);
        if (top.contains(p)) { // if this pair is in top set
            sum -= (long) p.num * p.freq; // update sum
            top.remove(p); // and remove it from top

            if (rest.size() != 0) { // if rest has some pairs
                Pair largest = rest.last(); // pick the largest pair
                sum += (long) largest.num * largest.freq; // update sum
                top.add(largest); // and add the largest pair to top
                rest.remove(largest); // then remove it from rest set
            }
        } else { // if this pair is in rest
            rest.remove(p); // just remove it
        }
    }

    public long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] result = new long[n - k + 1]; // ans

        HashMap<Integer, Integer> map = new HashMap<>(); // will store num and its freq

        // Sets
        top = new TreeSet<>(); // will store top x
        rest = new TreeSet<>(); // will store remainings
        sum = 0; // will store sum of top x 

        int i = 0;
        int j = 0;
        int a = 0; // just to fill the result
        while (j < n) {
            if (map.containsKey(nums[j])) { // if it is in map => definitely present in one of the sets
                removeFromSet(nums[j], map.get(nums[j]), x); // remove old pair
            }

            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1); // update freq of this element
            insertInSet(nums[j], map.get(nums[j]), x); // insert new pair

            if (j - i + 1 == k) { // when window completed
                result[a++] = sum; // fill the result

                // move the window

                removeFromSet(nums[i], map.get(nums[i]), x); // remove ith element from pair
                map.put(nums[i], map.get(nums[i]) - 1); // decrease the freq of ith by 1 in map

                if (map.get(nums[i]) == 0) { // if ith elements's freq becomes 0 
                    map.remove(nums[i]); // remove from map
                } else { // not becomes 0
                         // insert updated freq in set
                    insertInSet(nums[i], map.get(nums[i]), x); // updated freq
                }
                i++; // move forward
            }
            j++; // move forward
        }
        return result;
    }
}